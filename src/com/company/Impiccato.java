package com.company;

import java.util.Scanner;

public class Impiccato {

    public static void main(String[] args) {

        boolean ancora = true;
        Scanner sc = new Scanner(System.in);
        String scelta = "";

        System.out.println("Gioco dell'impiccato - Mattia Fortunato\n");
        System.out.println("Progetto Java per l'esame di Programmazione Prof.Anisetti");
        System.out.println("Funzionamento: il gioco seleziona casualmente una parola da una wordlist in txt,");
        System.out.println("l'utente prova ad indovinarla inserendo dei caratteri finché non viene indovinata");
        System.out.println("o vengono esauriti i 7 tentativi disponibili.\n");
        Grafica.asciiart();

        Dizionario wordlist = new Dizionario();

        while(ancora) {
            Parola parola = new Parola(wordlist);
            if(parola.getParola().length() != 0) {
                Gioco.start(parola);
                do {
                    System.out.println("Vuoi giocare ancora? (s/n): ");
                    scelta = sc.nextLine();
                } while (!Utility.sceltaValida(scelta));
                if (!Utility.scelta(scelta))
                    ancora = false;
            }
            else ancora = false;
        }
        sc.close();
    }
}