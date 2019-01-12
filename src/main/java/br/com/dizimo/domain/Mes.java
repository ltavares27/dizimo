package br.com.dizimo.domain;


public enum Mes {

    JANEIRO("Janeiro"),
    FEVEREIRO("Fevereiro"),
    MARCO("Marco"),
    ABRIL("Abril"),
    MAIO("Maio"),
    JUNHO("Junho"),
    JULHO("Julho"),
    AGOSTO("Agosto"),
    SETEMBRO("Setembro"),
    OUTUBRO("Outubro"),
    NOVEMBRO("Novembro"),
    DEZEMBRO("Dezembro");

    private String name;

    Mes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
