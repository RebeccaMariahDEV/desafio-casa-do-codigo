package br.com.zup.desafioCasaCodigo.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
public class Estados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = true)
    private String estado;

    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Pais pais;

    @CreationTimestamp
    private Timestamp criadoEm;

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public Pais getPais() {
        return pais;
    }

    public Timestamp getCriadoEm() {
        return criadoEm;
    }

    public  void setEstadoPais(String estado, Pais pais){
        this.estado = estado;
        this.pais = pais;
    }

}
