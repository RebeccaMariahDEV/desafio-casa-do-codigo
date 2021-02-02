package br.com.zup.desafioCasaCodigo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
public class FluxoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CPF
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private  String complementar;

    @NotBlank
    private String cidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estados_id", referencedColumnName = "id")
    private Estados estados;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @CreationTimestamp
    private Timestamp criadoEm;

    @UpdateTimestamp
    private Timestamp atualizadoEm;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplementar() {
        return complementar;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estados getEstados() {
        return estados;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Timestamp getCriadoEm() {
        return criadoEm;
    }

    public Timestamp getAtualizadoEm() {
        return atualizadoEm;
    }


    public void setDadosPessoais(String nome, String sobrenome, String email, String documento,
                                 String endereco, String complementar, String cidade, Pais pais,
                                 Estados estados, String telefone, String cep){

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complementar = complementar;
        this.cidade = cidade;
        this.pais = pais;
        this.estados = estados;
        this.telefone = telefone;
        this.cep = cep;

    }
}
