package br.com.zup.desafioCasaCodigo.model;

import br.com.zup.desafioCasaCodigo.repository.CnpjGoup;
import br.com.zup.desafioCasaCodigo.repository.CpfGoup;

public enum TipoDocumento {

    FISICA("Física", "CPF", "000.000.000-00", CpfGoup.class),
    JURIDICA("jurídica", "CNPJ", "00.000.000/0000-00", CnpjGoup.class);

    private final String descricao;
    private final String documento;
    private final String mascara;
    private  final Class<?> group;

    private TipoDocumento(String descricao, String documento, String mascara, Class<?> group){
        this.descricao = descricao;
        this.documento = documento;
        this.mascara = mascara;
        this.group = group;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDocumento() {
        return documento;
    }

    public String getMascara() {
        return mascara;
    }

    public Class<?> getGroup() {
        return group;
    }
}
