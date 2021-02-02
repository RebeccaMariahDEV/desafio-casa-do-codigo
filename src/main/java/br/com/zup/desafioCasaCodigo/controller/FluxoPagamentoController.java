package br.com.zup.desafioCasaCodigo.controller;

import br.com.zup.desafioCasaCodigo.core.erros.tipo.ColunaErro;
import br.com.zup.desafioCasaCodigo.dto.FluxoPagamentoDto;
import br.com.zup.desafioCasaCodigo.model.Estados;
import br.com.zup.desafioCasaCodigo.model.FluxoPagamento;
import br.com.zup.desafioCasaCodigo.model.Pais;
import br.com.zup.desafioCasaCodigo.repository.EstadoRepository;
import br.com.zup.desafioCasaCodigo.repository.FluxoPagametoRepository;
import br.com.zup.desafioCasaCodigo.repository.PaisRepository;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/compra")
public class FluxoPagamentoController {

    FluxoPagametoRepository fluxoPagametoRepository;
    PaisRepository paisRepository;
    EstadoRepository estadoRepository;

    @Autowired
    public FluxoPagamentoController(FluxoPagametoRepository fluxoPagametoRepository, PaisRepository paisRepository,
                                    EstadoRepository estadoRepository){
        this.fluxoPagametoRepository = fluxoPagametoRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public ResponseEntity<?> dadosPagamento(@RequestBody @Valid FluxoPagamentoDto fluxoPagamentoDto){

        FluxoPagamento fluxoPagamento = new FluxoPagamento();

        //busca o pais por id
        Optional<Pais> pais = paisRepository.findById(fluxoPagamentoDto.getPais_id());

        //busca o estado por id
        Optional<Estados> estados = estadoRepository.findById(fluxoPagamentoDto.getEstados_id());

        fluxoPagamento.setDadosPessoais(fluxoPagamentoDto.getNome(), fluxoPagamentoDto.getSobrenome(), fluxoPagamentoDto.getEmail(),
                fluxoPagamentoDto.getDocumento(), fluxoPagamentoDto.getEndereco(), fluxoPagamentoDto.getComplementar(),
                fluxoPagamentoDto.getCidade(), pais.get(), estados.get(), fluxoPagamentoDto.getTelefone(), fluxoPagamentoDto.getCep());

        //validar estado
//        var findEstado = estadoRepository.findByEstado(estados.get().getEstado());
//        if (findEstado.isPresent()){
//            throw  new ColunaErro("Estado já existe", "estado");
//            if ()
//        }

        //validando pais estado
//        var findPais = paisRepository.findByPais(pais.get().getPais());
//        var findEstado = estadoRepository.findByEstado(estados.get().getEstado());
//        if (findEstado.isPresent() && !findPais.isPresent()){
//            throw new ColunaErro("Estado já existe, selecione um pais", "pais");
//        }
//        else if(){
//            throw new ColunaErro("Pais já existente, selecione um estado", "estado");
//        }

        fluxoPagametoRepository.save(fluxoPagamento);

        return  null;

    }

}
