package br.com.southrocklab.resources.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    /**
     * Retorna data no formato yyyy-MM-dd,
     *(Ex: 1 dia)  retorno: 2022-08-24,
     * utilizada para preencher o teste (customer_com_birth_date_maior_que_hoje)
     * de forma automática.
     *
     * @author Roni Miguel
     */
    public String fullDateWithDiffOfDays(int numberOfDays){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now(); // Data atual
        LocalDate days = today.plusDays(numberOfDays); // Dias adicionados
        String date = days.format(dateFormat);
        return date;
    }

    /**
     * Retorna data de nascimento no formato yyyy-MM-dd,
     * Ex: 18 anos (-18) retorno 2004-08-23,
     * utilizada para preencher data de Nascimento.
     *
     * @author Roni Miguel
     */
    public String birthDateWithDiffOfYears(int numberOfYears){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        LocalDate years = today.plusYears(numberOfYears); // Anos adicionados
        String date = years.format(dateFormat);
        return date;
    }

    /**
     * Retorna ano no formato yyyy,
     * (Ex: -1) retorno 2021,
     * utilizada para preencher o teste (salvar_card_com_expiration_year_menor_que_ANO_ATUAL).
     *
     * @author Roni Miguel
     */
    public int yearWithDiffOfYear(int numberOfYears){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy");
        LocalDate today = LocalDate.now();
        LocalDate years = today.plusYears(numberOfYears); // Anos adicionados
        int date = Integer.parseInt(years.format(dateFormat));
        return date;
    }

}
