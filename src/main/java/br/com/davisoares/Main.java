package br.com.davisoares;

import br.com.davisoares.entity.Precip;
import br.com.davisoares.services.PrecipitacaoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Precip> precipitacoes = new ArrayList<>();
        PrecipitacaoService precipitacaoService = new PrecipitacaoService();

        for (int month = 1; month <= 4; month++) {
            for (int i = 1; i <= 3; i++) {
                precipitacoes.add(new Precip(
                        LocalDate.of(2015, month, i),
                        Math.random() * 10));
            }
        }

        precipitacoes.forEach(p -> System.out.println(p.toString()));

        System.out.println(precipitacaoService.totalPorMes(precipitacoes));
        System.out.println(precipitacaoService.maxAndMinDia(precipitacoes));
        System.out.println(precipitacaoService.maxAndMinMes(precipitacoes));
        System.out.println(precipitacaoService.mediaPorAno(precipitacoes));
        System.out.println(precipitacaoService.mediaPorMes(precipitacoes));
        System.out.println(precipitacaoService.top10Dias(precipitacoes));
    }
}