package com.company;


public class Parola {

    private String parola;
    private String parolaSecretata;

    public Parola(Dizionario wordlist) {
        /*costruttore parola, data una wordlist chiede una parola da estrarre casualmente e la sua versione secretata*/
        this.parola = wordlist.getParolaRandom();
        this.parolaSecretata = Utility.secretaParola(this.parola);
    }

    public String getParola() {
        /*ritorna la parola*/
        return this.parola;
    }

    public String getParolaSecretata() {
        /*ritorna la parola secretata*/
        return this.parolaSecretata;
    }

    public void setParolaSecretata(String segreta) {
        /*permette l'aggiornamento della parola secretata*/
        this.parolaSecretata = segreta;
    }

}
