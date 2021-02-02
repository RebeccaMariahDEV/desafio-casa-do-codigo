package br.com.zup.desafioCasaCodigo.core.erros;

import br.com.zup.desafioCasaCodigo.core.BaseController.RetornoPadrao;
import br.com.zup.desafioCasaCodigo.core.erros.tipo.ColunaErro;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//roda no sitema inteiro para adivertencias
@RestControllerAdvice
public class BaseErroHandeler {

    public class ErroColuna {

        private String coluna;
        private String mensagem;

        public String getColuna() {
            return coluna;
        }

        public void setColuna(String coluna) {
            this.coluna = coluna;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //criado apenas para tratar os erros do bean validation
    public RetornoPadrao setArgumentsInvalid(MethodArgumentNotValidException e) {

        RetornoPadrao retorno = new RetornoPadrao();
        retorno.setStatus(false);
        retorno.setMensagem("Ops, houve um erro nos dados");

        //Criando listas de erros
        List<ErroColuna> erros = new ArrayList<>();

        //pega os erros, percorre um por um e trata os erros
        e.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErroColuna erroColuna = new ErroColuna();
                    erroColuna.setColuna(error.getField());
                    erroColuna.setMensagem(error.getDefaultMessage());
                    erros.add(erroColuna);
                });
        //setando erros no retorno padrão
        retorno.setResultados(erros);

        return retorno;

    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ColunaErro.class)
    //criado apenas para tratar os erros de dados
    public RetornoPadrao setColunaComErro(ColunaErro e) {

        RetornoPadrao retorno = new RetornoPadrao();
        retorno.setStatus(false);
        retorno.setMensagem("Ops, houve um erro nos dados");

        //Criando listas de erros
        List<ErroColuna> erros = new ArrayList<>();

        //toda vez que chamamos o coluna erro essa func sera chamada
        ErroColuna erroColuna = new ErroColuna();
        erroColuna.setColuna(e.getColuna());
        erroColuna.setMensagem(e.getMessage());
        erros.add(erroColuna);

        //setando erros no retorno padrão
        retorno.setResultados(erros);

        return retorno;
    }

}
