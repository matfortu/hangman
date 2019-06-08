package com.company;


public class Parola {

    private String parola;
    private String parolaSecretata;

    public Parola(Dizionario wordlist) {
        this.parola = wordlist.getParolaRandom();
        this.parolaSecretata = Utility.secretaParola(this.parola);
    }

    public String getParola() {
        return this.parola;
    }

    public String getParolaSecretata() {
        return this.parolaSecretata;
    }

    public void setParolaSecretata(String segreta) {
        this.parolaSecretata = segreta;
    }

}
