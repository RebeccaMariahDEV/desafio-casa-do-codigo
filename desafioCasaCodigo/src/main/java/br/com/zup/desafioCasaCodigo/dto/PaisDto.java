package br.com.zup.desafioCasaCodigo.dto;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


public class PaisDto {

    private Long id;

    @NotBlank
    private String pais;

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
