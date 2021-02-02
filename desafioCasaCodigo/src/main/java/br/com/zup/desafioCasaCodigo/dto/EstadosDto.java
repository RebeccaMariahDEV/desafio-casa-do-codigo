package br.com.zup.desafioCasaCodigo.dto;

import javax.validation.constraints.NotBlank;

public class EstadosDto {

    private Long id;

    @NotBlank
    private String estado;

    private Long pais_id;

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }



}
