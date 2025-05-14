package br.com.davisoares.services;

import br.com.davisoares.entity.Precip;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrecipitacaoService {

    public Map<Integer, Double> totalPorMes(List<Precip> list) {
        return list
                .stream()
                .collect(Collectors.groupingBy(registro ->
                        registro.getMomento().getMonthValue(),
                        Collectors.summingDouble(Precip::getQuant)));
    }

    public Map<String, LocalDate> maxAndMinDia(List<Precip> list) {
        Precip max = list.stream()
                .max(Comparator.comparingDouble(Precip::getQuant)).orElse(null);

        Precip min = list.stream()
                .min(Comparator.comparingDouble(Precip::getQuant)).orElse(null);

        return new HashMap<>()
        {{
            put("max", max.getMomento());
            put("min", min.getMomento());
        }};
    }

    public Map<String, Integer> maxAndMinMes(List<Precip> list) {
        Map<Integer, Double> totalPerMonth = list
                .stream()
                .collect(Collectors.groupingBy(registro ->
                        registro.getMomento().getMonthValue(),
                        Collectors.summingDouble(Precip::getQuant)));

        Integer max = totalPerMonth
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue)).orElse(null)
                .getKey();

        Integer min = totalPerMonth
                .entrySet()
                .stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue)).orElse(null)
                .getKey();

        return new HashMap<>() {{
            put("max", max);
            put("min", min);
        }};
    }

    public Double mediaPorAno(List<Precip> list) {
        return list
                .stream()
                .collect(Collectors.averagingDouble(Precip::getQuant));
    }

    public Map<Integer, Double> mediaPorMes(List<Precip> list) {
        return list
                .stream()
                .collect(Collectors.groupingBy(registro ->
                        registro.getMomento().getMonthValue(),
                        Collectors.averagingDouble(Precip::getQuant)));
    }

    public List<Precip> top10Dias(List<Precip> list) {
        return list
                .stream()
                .sorted(Comparator.comparingDouble(Precip::getQuant).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
