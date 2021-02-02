package br.com.zup.desafioCasaCodigo.dto;

import br.com.zup.desafioCasaCodigo.model.Estados;
import br.com.zup.desafioCasaCodigo.model.Pais;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class FluxoPagamentoDto {

    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private  String complementar;

    @NotBlank
    private String cidade;

    private Long pais_id;

    private Long estado_id;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplementar() {
        return complementar;
    }

    public void setComplementar(String complementar) {
        this.complementar = complementar;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getPais_id() {
        return pais_id;
    }

    public void setPais_id(Long pais_id) {
        this.pais_id = pais_id;
    }

    public Long getEstados_id() {
        return estado_id;
    }

    public void setEstado_id(Long estados_id) {
        this.estado_id = estados_id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
