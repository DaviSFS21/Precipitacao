package br.com.davisoares.entity;

import java.time.LocalDate;

public class Precip {
    LocalDate momento;
    Double quant;

    public Precip(LocalDate momento, Double quant) {
        this.momento = momento;
        this.quant = quant;
    }

    public LocalDate getMomento() {
        return momento;
    }

    public void setMomento(LocalDate momento) {
        this.momento = momento;
    }

    public Double getQuant() {
        return quant;
    }

    public void setQuant(Double quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return momento + ": " + quant;
    }
}
