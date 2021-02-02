package br.com.zup.desafioCasaCodigo.dto;

import br.com.zup.desafioCasaCodigo.model.Livro;

import java.time.LocalDate;

public class LivroDetalhado {

    private String titulo;
    private String resumo;
    private String sumario;
    private Integer numPags;
    private  Float preco;
    private String isbn;
    private LocalDate dataLancamento;
    private Long autor_id;
    private Long categorias_id;

    public LivroDetalhado(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numPags = livro.getNumPags();
        this.isbn = livro.getIsbn();
        this.preco = livro.getPreco();
        this.dataLancamento = livro.getDataLancamento();
        this.autor_id = livro.getAutor().getId();
        this.categorias_id = livro.getCategorias().getId();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumPags() {
        return numPags;
    }

    public Float getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getAutor_id() {
        return autor_id;
    }

    public Long getCategorias_id() {
        return categorias_id;
    }
}
