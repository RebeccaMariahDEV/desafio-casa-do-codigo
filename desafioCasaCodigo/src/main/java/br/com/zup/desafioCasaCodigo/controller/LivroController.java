package br.com.zup.desafioCasaCodigo.controller;

import br.com.zup.desafioCasaCodigo.core.BaseController;
import br.com.zup.desafioCasaCodigo.core.erros.tipo.ColunaErro;
import br.com.zup.desafioCasaCodigo.dto.LivroDetalhado;
import br.com.zup.desafioCasaCodigo.dto.LivroDto;
import br.com.zup.desafioCasaCodigo.dto.LivroIdTitulo;
import br.com.zup.desafioCasaCodigo.model.Autor;
import br.com.zup.desafioCasaCodigo.model.Categorias;
import br.com.zup.desafioCasaCodigo.model.Livro;
import br.com.zup.desafioCasaCodigo.repository.AutorRepository;
import br.com.zup.desafioCasaCodigo.repository.CategoriaRepository;
import br.com.zup.desafioCasaCodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Cacheable;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/livro")
public class LivroController extends BaseController {

    LivroRepository livroRepository;
    AutorRepository autorRepository;
    CategoriaRepository categoriaRepository;


    @Autowired
    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository,
                           CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;


    }

    @PostMapping
    public ResponseEntity<?> criarLivro(@RequestBody @Valid LivroDto livroDto) {
        Livro livro = new Livro();

        // busca autor
        Optional<Autor> autor = autorRepository.findById(livroDto.getAutor_id());
        // busca categoria
        Optional<Categorias> categorias = categoriaRepository.findById(livroDto.getCategorias_id());

//        System.out.println(autor.get().getId());
//        System.out.println(categorias.get().getId());
//
        //definindo os atributos da classe livro
        livro.setDadosLivro(
                livroDto.getTitulo(), livroDto.getResumo(), livroDto.getSumario(),
                livroDto.getPreco(), livroDto.getNumPags(), livroDto.getIsbn(),
                livroDto.getDataLancamento(), autor.get(), categorias.get()
        );


        //validar titulo
        var findLivroTitulo = livroRepository.findByTitulo(livro.getTitulo());

        if (findLivroTitulo.isPresent()) {
            throw new ColunaErro("Titulo já existente", "titulo");
        }

        //validando isbn
        var findLivroIsbn = livroRepository.findByIsbn(livro.getIsbn());

        if (findLivroIsbn.isPresent()) {
            throw new ColunaErro("Isbn já existente", "isbn");
        }

        //validando categoria
        var findLivroCategoria = livroRepository.findByCategoriasId(livroDto.getCategorias_id());

        if (findLivroCategoria.isPresent()) {
            throw new ColunaErro("Categorias não pode ser em branco", "categoria");
        }


        // validando autor
        var findLivroAutor = livroRepository.findByAutorId(livroDto.getAutor_id());

        if (findLivroAutor.isPresent()) {
            throw new ColunaErro("Autor não pode ser em branco", "autor");
        }


        // salvando livro
        livroRepository.save(livro);


        return sucesso("Livro cadastrado com sucesso.");
    }

    //Livros e id's
    @GetMapping
    public ResponseEntity<?> listar() {
        List<LivroIdTitulo> listaLivros = livroRepository.findBy();

        return ResponseEntity.ok().body(listaLivros);
    }

    //detalhes dos livros
    @GetMapping(value = "/livroDetalhado/{id}")
    public ResponseEntity<?> livroDetalhado(@PathVariable("id") Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        LivroDetalhado livroDetalhado = new LivroDetalhado(livro.get());

        return ResponseEntity.ok().body(livroDetalhado);

    }

}
