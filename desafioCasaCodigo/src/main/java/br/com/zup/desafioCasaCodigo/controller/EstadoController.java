package br.com.zup.desafioCasaCodigo.controller;

import br.com.zup.desafioCasaCodigo.dto.EstadosDto;
import br.com.zup.desafioCasaCodigo.model.Estados;
import br.com.zup.desafioCasaCodigo.model.Pais;
import br.com.zup.desafioCasaCodigo.repository.EstadoRepository;
import br.com.zup.desafioCasaCodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    EstadoRepository estadoRepository;
    PaisRepository paisRepository;

    @Autowired
    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository){
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> criarEstados(@RequestBody @Valid EstadosDto estadosDto){

        Estados estados = new Estados();
        Optional<Pais> pais = paisRepository.findById(estadosDto.getPais_id());
        estados.setEstadoPais(estadosDto.getEstado(), pais.get());

        estadoRepository.save(estados);
        System.out.println(pais.get());
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
