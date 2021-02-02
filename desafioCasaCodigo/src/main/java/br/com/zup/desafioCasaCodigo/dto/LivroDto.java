package br.com.zup.desafioCasaCodigo.dto;


import br.com.zup.desafioCasaCodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


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

    private Float preco = 20.00F;

    private Integer numPags = 100;

    @NotBlank
    private String isbn;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
//    @JsonSerialize(converter)
    @Future
    private LocalDate dataLancamento;

    private Long categorias_id;

    private Long autor_id;

    //get and set
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

//    public LivroDto converter(Livro livro){
//       this.titulo = livro.getTitulo();
//       this.resumo = livro.getResumo();
//       this.sumario = livro.getSumario();
//       this.numPags = livro.getNumPags();
//       this.isbn = livro.getIsbn();
//       this.preco = livro.getPreco();
//       this.dataLancamento = livro.getDataLancamento();
//       this.autor_id = livro.getAutor().getId();
//       this.categorias_id = livro.getCategorias().getId();
//
//       return this;
//    }

}
