package br.com.zup.desafioCasaCodigo.controller;

import br.com.zup.desafioCasaCodigo.core.BaseController;
import br.com.zup.desafioCasaCodigo.core.erros.tipo.ColunaErro;
import br.com.zup.desafioCasaCodigo.dto.AutorDto;
import br.com.zup.desafioCasaCodigo.model.Autor;
import br.com.zup.desafioCasaCodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorContoller extends BaseController {

    AutorRepository autorRepository;

    @Autowired
    public AutorContoller(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }


    @PostMapping
    public ResponseEntity<?> criarAutor(@RequestBody @Valid AutorDto autorDto){
        Autor autor = new Autor();
        autor.setAutorDados(autorDto.getName(), autorDto.getEmail(), autorDto.getDescricao());

        //validando email
        var findAutor = autorRepository.findByEmail(autor.getEmail());

        if(findAutor.isPresent()){
            throw new ColunaErro("Email já cadastrado", "email");
        }

        //salvando autor
        var autorSalvo = autorRepository.save(autor);

        //refatorado
//        return ResponseEntity.status(HttpStatus.OK).build();
        return sucesso("Autor cadastrado com sucesso.");
    }

}
