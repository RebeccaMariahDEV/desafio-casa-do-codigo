package br.com.zup.desafioCasaCodigo.dto;

import br.com.zup.desafioCasaCodigo.model.Autor;
import br.com.zup.desafioCasaCodigo.model.Categorias;
import br.com.zup.desafioCasaCodigo.model.Livro;
import br.com.zup.desafioCasaCodigo.repository.LivroRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

public class LivroDto {

    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String titulo;

    @NotBlank
    @Lob
    @Column(length = 500)
    private String resumo;

    @Lob
    @Column(name = "sumario", columnDefinition = "BLOB")
    private String sumario;

    @Column(nullable = false)
    private Float preco = 20.00F;

    @Column(nullable = false)
    private Integer numPags = 100;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String isbn;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
//    @JsonSerialize(converter)
    @Future
    private LocalDate dataLancamento;

    private Long categorias_id;

    private Long autor_id;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        if(preco < 20.0F){
            float valorMinimo = 20.0F;
            this.preco = valorMinimo;
        }else{
            this.preco = preco;
        }
    }

    public Integer getNumPags() {
        return numPags;
    }

    public void setNumPags(Integer numPags) {
        if(numPags < 100){
            Integer pagsMinimo = 100;
            this.numPags = numPags;
        }else{
            this.numPags = numPags;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Long getCategorias_id() {
        return categorias_id;
    }

    public void setCategorias_id(Long categorias_id) {
        this.categorias_id = categorias_id;
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
    }
    public LivroDto(String titulo, String resumo, String sumario, Float preco, Integer numPags, String isbn, Long categorias_id, Long autor_id) {
    }

    public LivroDto converter(LivroRepository livroRepository){
        Optional<LivroDto> livro = livroRepository.findById(titulo);
        return new LivroDto(titulo, resumo, sumario, preco, numPags, isbn, categorias_id,
                autor_id);
    }

}
