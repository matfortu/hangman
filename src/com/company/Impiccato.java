package com.company;

public class Impiccato {

    public static void main(String[] args) {

        System.out.println("Gioco dell'impiccato - Mattia Fortunato\n");
        System.out.println("Progetto Java per l'esame di Programmazione Prof.Anisetti");
        System.out.println("Funzionamento: il gioco seleziona casualmente una parola da una wordlist in txt,");
        System.out.println("l'utente prova ad indovinarla inserendo dei caratteri finché non viene indovinata");
        System.out.println("o vengono esauriti i 6 tentativi disponibili.\n");
        Grafica.asciiart();

        Gioco.start(Dizionario.parolaSegreta());

    }
}
