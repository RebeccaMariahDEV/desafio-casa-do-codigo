package br.com.zup.desafioCasaCodigo.model;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class FluxoPagamentGroupSequenceProvider implements DefaultGroupSequenceProvider<FluxoPagamento> {

    @Override
    public List<Class<?>> getValidationGroups(FluxoPagamento fluxoPagamento){
        List<Class<?>> groups = new ArrayList<>();
        groups.add(FluxoPagamento.class);

        if(isTipoDocumento(fluxoPagamento)){
            groups.add(fluxoPagamento.getTipoDocumento().getGroup());
        }
        return groups;
    }

    protected boolean isTipoDocumento(FluxoPagamento fluxoPagamento){
        return fluxoPagamento != null && fluxoPagamento.getDocumento() != null;
    }
}
