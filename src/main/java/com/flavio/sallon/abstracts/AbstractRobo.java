package com.flavio.sallon.abstracts;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractRobo {
    private String nome="";
    private Date dataFabricacao;
    private Integer bateria ;
    private AbstractOperacao operacao;
    private static final String arquivoBateria = "/robo/bateria.txt";
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public abstract String ligar();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Integer getBateria() {
        return bateria;
    }

    public void setBateria(Integer bateria) {
        this.bateria = bateria;
    }

    public AbstractOperacao getOperacao() {
        return operacao;
    }

    public void setOperacao(AbstractOperacao operacao) {
        this.operacao = operacao;
    }

    public static String getArquivoBateria() {
        return arquivoBateria;
    }

    @Override
    public String toString() {
        return "AbstractRobo{" +
                "nome='" + nome + '\'' +
                ", dataFabricacao=" + sdf.format(dataFabricacao) +
                ", bateria=" + bateria +
                '}';
    }
}
