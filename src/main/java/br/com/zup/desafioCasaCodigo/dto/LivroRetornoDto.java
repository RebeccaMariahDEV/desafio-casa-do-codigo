package br.com.zup.desafioCasaCodigo.dto;

import br.com.zup.desafioCasaCodigo.model.Autor;
import br.com.zup.desafioCasaCodigo.model.Livro;

public interface LivroRetornoDto {

      Long getId();
     String getTitulo();
     String getResumo();
     String getSumario();
     Float getPreco();
     Integer numPags();
     String Isbn();


}
