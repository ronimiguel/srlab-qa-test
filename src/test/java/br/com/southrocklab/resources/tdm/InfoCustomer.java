package br.com.southrocklab.resources.tdm;

import br.com.southrocklab.resources.utils.DateUtils;

public class InfoCustomer {
    DateUtils dateUtils = new DateUtils();

    private final String name = "Maria";
    private final String lastName = "Delegado";
    private final String lastNameAlterado = "Delgado";
    private final String nameELastNameInexistente = "/Maria/Degado";
    private final String idInexistente = "/0";
    private final String birthDate = dateUtils.birthDateWithDiffOfYears(-18);
    private final String birthDateMaiorQueHoje = dateUtils.fullDateWithDiffOfDays(1);
    private final String pesquisa = "/" + name + "/" + lastName;


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastNameAlterado() {
        return lastNameAlterado;
    }

    public String getNameELastNameInexistente() {
        return nameELastNameInexistente;
    }

    public String getIdInexistente() {
        return idInexistente;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthDateMaiorQueHoje() {
        return birthDateMaiorQueHoje;
    }

    public String getPesquisa() {
        return pesquisa;
    }

}
