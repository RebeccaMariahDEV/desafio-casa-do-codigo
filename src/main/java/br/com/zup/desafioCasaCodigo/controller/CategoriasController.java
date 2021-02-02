package br.com.zup.desafioCasaCodigo.controller;

import br.com.zup.desafioCasaCodigo.core.BaseController;
import br.com.zup.desafioCasaCodigo.core.erros.tipo.ColunaErro;
import br.com.zup.desafioCasaCodigo.dto.CategoriasDto;
import br.com.zup.desafioCasaCodigo.model.Categorias;
import br.com.zup.desafioCasaCodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController extends BaseController {

    CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriasController(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<?> criarCategoria(@RequestBody @Valid CategoriasDto categoriasDto){
        Categorias categorias = new Categorias();
        categorias.setNomeCategoria(categoriasDto.getNomeCategoria());

        //validar categoria
        var findCategorias = categoriaRepository.findByNomeCategoria(categorias.getNomeCategoria());

        if(findCategorias.isPresent()){
            throw new ColunaErro("Categoria já existente", "nomeCategoria");
        }

        //salvando a categoria
        var categoriaSalvo = categoriaRepository.save(categorias);

        return sucesso("Categoria criada com sucesso.");
    }

}
