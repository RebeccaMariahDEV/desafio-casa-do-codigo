package br.com.zup.desafioCasaCodigo.controller;

import br.com.zup.desafioCasaCodigo.core.BaseController;
import br.com.zup.desafioCasaCodigo.core.erros.tipo.ColunaErro;
import br.com.zup.desafioCasaCodigo.dto.LivroDto;
import br.com.zup.desafioCasaCodigo.dto.LivroIdTitulo;
import br.com.zup.desafioCasaCodigo.dto.LivroRetornoDto;
import br.com.zup.desafioCasaCodigo.model.Autor;
import br.com.zup.desafioCasaCodigo.model.Categorias;
import br.com.zup.desafioCasaCodigo.model.Livro;
import br.com.zup.desafioCasaCodigo.repository.AutorRepository;
import br.com.zup.desafioCasaCodigo.repository.CategoriaRepository;
import br.com.zup.desafioCasaCodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/livro")
public class LivroController extends BaseController {

    LivroRepository livroRepository;
    AutorRepository autorRepository;
    CategoriaRepository categoriaRepository;
    LivroRetornoDto livroRetornoDto;

    @Autowired
    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository,
                           CategoriaRepository categoriaRepository, LivroRetornoDto livroRetornoDto){
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRetornoDto = livroRetornoDto;

    }

    @PostMapping
    public ResponseEntity<?> criarLivro(@RequestBody @Valid LivroDto livroDto){
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
                livroDto.getPreco(),  livroDto.getNumPags(), livroDto.getIsbn(),
                livroDto.getDataLancamento(),  autor.get(), categorias.get()
        );


        //validar titulo
        var findLivroTitulo = livroRepository.findByTitulo(livro.getTitulo());

        if (findLivroTitulo.isPresent()){
            throw new ColunaErro("Titulo já existente", "titulo");
        }

        //validando isbn
        var findLivroIsbn = livroRepository.findByIsbn(livro.getIsbn());

        if (findLivroIsbn.isPresent()){
            throw new ColunaErro("Isbn já existente", "isbn");
        }

        //validando categoria
        var findLivroCategoria = livroRepository.findByCategoriasId(livroDto.getCategorias_id());

        if (findLivroCategoria.isPresent()){
            throw new ColunaErro("Categorias não pode ser em branco", "categoria");
        }


       // validando autor
        var findLivroAutor = livroRepository.findByAutorId(livroDto.getAutor_id());

        if (findLivroAutor.isPresent()){
            throw new ColunaErro("Autor não pode ser em branco", "autor");
        }


        // salvando livro
        livroRepository.save(livro);


        return  sucesso("Livro cadastrado com sucesso.");
    }

    @GetMapping
    public ResponseEntity<?> listar(){
        List<LivroIdTitulo> listaLivros = livroRepository.findBy();

        return ResponseEntity.ok().body(listaLivros);
    }

    @GetMapping(value = "/livroDetalhado{id}")
    @Cacheable //guarda o resultado em memoria
    public Page<LivroDto> livroDetalhado(@RequestParam(required = false) String titulo, @PageableDefault(sort = "id",
    direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){

        if (titulo ==null) {
            //consulta e mostra todos os dados do banco de dados, herdando as funcionalidades do jpa
            Page<LivroDto> livroDetalhado = livroRepository.findByTitulo();
            return Livro;
        }
        return new ;
    }

}
