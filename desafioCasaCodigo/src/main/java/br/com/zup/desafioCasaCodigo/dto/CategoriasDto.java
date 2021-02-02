package br.com.zup.desafioCasaCodigo.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CategoriasDto {

    @Id
    private  Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String nomeCategoria;

    public Long getId() {
        return id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
