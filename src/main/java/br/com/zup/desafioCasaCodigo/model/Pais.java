package br.com.zup.desafioCasaCodigo.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String pais;

    @CreationTimestamp
    private Timestamp criadoEm;

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }


    public Timestamp getCriadoEm() {
        return criadoEm;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCriadoEm(Timestamp criadoEm) {
        this.criadoEm = criadoEm;
    }
}
