package br.com.zup.desafioCasaCodigo.core.erros.tipo;

import br.com.zup.desafioCasaCodigo.core.erros.BaseErroHandeler;

public class ColunaErro extends RuntimeException{

  private String coluna;

  public ColunaErro(String mensagem, String coluna){
      super(mensagem);
      this.coluna = coluna;
  }

    public String getColuna() {
        return coluna;
    }
}
