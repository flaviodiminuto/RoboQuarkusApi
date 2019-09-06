package com.flavio.sallon.model.operacao;

import com.flavio.sallon.abstracts.AbstractOperacao;

public class Soma extends AbstractOperacao {
    @Override
    public double execute(double a, double b) {
        return a+b;
    }
}
