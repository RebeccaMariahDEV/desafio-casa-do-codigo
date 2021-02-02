package br.com.zup.desafioCasaCodigo.controller;

import br.com.zup.desafioCasaCodigo.core.erros.tipo.ColunaErro;
import br.com.zup.desafioCasaCodigo.dto.PaisDto;
import br.com.zup.desafioCasaCodigo.model.Pais;
import br.com.zup.desafioCasaCodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    PaisRepository paisRepository;

    @Autowired
    public PaisController(PaisRepository paisRepository){
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> criarPais(@RequestBody @Valid PaisDto paisDto){
        Pais pais = new Pais();
        pais.setPais(paisDto.getPais());

        var findPais = paisRepository.findByPais(pais.getPais());

        if(findPais.isPresent()){
            throw new ColunaErro("Pais já consta no banco de dados", "pais");

        }
        paisRepository.save(pais);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
