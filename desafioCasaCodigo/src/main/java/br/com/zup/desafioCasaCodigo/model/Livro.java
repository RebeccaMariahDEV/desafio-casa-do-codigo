package br.com.zup.desafioCasaCodigo.model;

import br.com.zup.desafioCasaCodigo.repository.LivroRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Float preco = 00.00F;

    @Column(nullable = false)
    private Integer numPags = 100;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String isbn;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorias_id", referencedColumnName = "id")
    private Categorias categorias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Autor autor;

    @CreationTimestamp
    private Timestamp criadoEm;

    @UpdateTimestamp
    private Timestamp atualizadoEm;


    public Long getId() {
        return id;
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

    public Float getPreco() {
        return preco;
    }

    public Integer getNumPags() {
        return numPags;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public Autor getAutor() {
        return autor;
    }

    public Timestamp getCriadoEm() {
        return criadoEm;
    }

    public Timestamp getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setDadosLivro(String titulo, String resumo, String sumario, Float preco,
                              Integer numPags, String isbn, LocalDate dataLancamento,
                              Autor autor, Categorias categorias) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPags = numPags;
        this.isbn = isbn;
        this.categorias = categorias;
        this.autor = autor;
        this.dataLancamento = dataLancamento;
    }

}
