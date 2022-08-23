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
    public String fullDateWithDiffDays(int numberOfDays){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now(); // Data atual
        LocalDate days = today.plusDays(numberOfDays); // Dias adicionados
        String date = days.format(dateFormat);
        return date;
    }


}
