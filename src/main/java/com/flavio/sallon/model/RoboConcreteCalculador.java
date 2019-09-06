package com.flavio.sallon.model;

import com.flavio.sallon.abstracts.AbstractRobo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoboConcreteCalculador extends AbstractRobo {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy 00:00:00");
    @Override
    public String ligar(){
        String linha;
        boolean nomeado=false;
        try {
            FileReader fr = new FileReader(new File(getArquivoBateria()));
            BufferedReader reader = new BufferedReader(fr);
            while (reader.ready()){
                linha = reader.readLine();
                String[] registros = linha.split(";");
                if(registros.length>0 && registros[0].equals(super.getNome())){
                    super.setBateria(Integer.valueOf(registros[1]));
                    super.setDataFabricacao(new Date());
                    nomeado = true;
                }
            }
            if(!nomeado){
                configuracaoDeFabrica();
            }
        } catch (Exception e) {
            e.printStackTrace();
            configuracaoDeFabrica();
        }
        return "Olá, eu sou "+getNome();
    }

    private void configuracaoDeFabrica(){
        super.setNome("XPTO");
        super.setDataFabricacao(new Date());
        super.setBateria(0);
    }
}
