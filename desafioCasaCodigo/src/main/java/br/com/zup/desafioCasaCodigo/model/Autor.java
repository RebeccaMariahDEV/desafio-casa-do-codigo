package br.com.zup.desafioCasaCodigo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Lob
    @Column(length = 400)
    private String descricao;

    @CreationTimestamp
    private Timestamp criadoEm;

    @UpdateTimestamp
    private Timestamp atualizadoEm;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Timestamp getCriadoEm() {
        return criadoEm;
    }

    public Timestamp getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAutorDados (String name, String email, String descricao){
        this.name = name;
        this.email = email;
        this.descricao = descricao;
    }
}
