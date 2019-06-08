package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Gioco {

    public static void start(Parola parola) {
        //System.out.println(parola.getParola());
        boolean fine = false;
        boolean valido = false;
        Scanner lettera = new Scanner(System.in);
        ArrayList provate = new ArrayList();
        ArrayList posizioni = new ArrayList();
        String input = "";
        char carattere;
        int errori = 0;
        int vite = 7;

        if(!parola.getParolaSecretata().isEmpty()) {
            Grafica.disegna(errori);
            System.out.println("\n\nParola da indovinare: \n" + parola.getParolaSecretata());
            while (!fine) {
                while (!valido) {
                    System.out.println("\nInserire una lettera: ");
                    input = lettera.nextLine();
                    valido = Utility.inputValido(input);
                }
                valido = false;
                carattere = Character.toUpperCase(input.charAt(0));
                posizioni = Utility.posizioniCarattere(carattere, parola);
                Grafica.pulisciSchermo();
                if (posizioni.size() != 0) {
                    if (posizioni.size() == 1)
                        System.out.println("La lettera " + carattere + " e' presente " + posizioni.size() + " volta!");
                    else
                        System.out.println("La lettera " + carattere + " e' presente " + posizioni.size() + " volte!");
                    Grafica.disegna(errori);
                    Utility.stampa(provate);
                } else {
                    if (provate.contains(carattere))
                        System.out.println("La lettera " + carattere + " e' gia' stata provata.");
                    else {
                        System.out.println("La lettera " + carattere + " non e' presente.");
                        errori++;
                    }
                    Grafica.disegna(errori);
                    provate = Utility.lettereProvate(carattere, provate);
                    Utility.stampa(provate);
                }
                Utility.sostituisci(parola, posizioni);
                System.out.println("\n\nParola da indovinare: \n" + parola.getParolaSecretata());
                if (!Utility.contiene(parola.getParolaSecretata(), '*') || errori == vite) {
                    if (errori == vite)
                        System.out.println("Game over! La parola corretta era " + parola.getParola());
                    else
                        System.out.println("Complimenti, hai vinto!");
                    fine = true;
                }
            }
        }
    }
}