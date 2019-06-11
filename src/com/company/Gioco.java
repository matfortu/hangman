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

        Grafica.disegna(errori);
        System.out.println("\n\nParola da indovinare: \n" + parola.getParolaSecretata());
        while (!fine) {                                                                     //ciclo principale del gioco
            while (!valido) {                                                               //ciclo per l'input e validazione del carattere da testare
                System.out.println("\nInserire una lettera: ");
                input = lettera.nextLine();
                valido = Utility.inputValido(input);
            }
            valido = false;
            carattere = Character.toUpperCase(input.charAt(0));                             //i caratteri vengono tutti convertiti in maiuscolo per facilitare il confronto
            posizioni = Utility.posizioniCarattere(carattere, parola);
            Grafica.pulisciSchermo();
            if (posizioni.size() != 0) {                                                    //se il carattere è stato trovato in almeno una occorrenza viene segnalato al giocatore e viene sostituito nella parola secretata
                if (posizioni.size() == 1)
                    System.out.println("La lettera " + carattere + " e' presente " + posizioni.size() + " volta!");
                else
                    System.out.println("La lettera " + carattere + " e' presente " + posizioni.size() + " volte!");
                Grafica.disegna(errori);
                Utility.stampa(provate);
                Utility.sostituisci(parola, posizioni);
            }
            else {
                if (provate.contains(carattere))                                            //altrimenti si controlla che il carattere inserito dal giocatore non sia già stato provato in precedenza
                    System.out.println("La lettera " + carattere + " e' gia' stata provata.");
                else {                                                                      //oppure che non sia presente nella parola da indovinare
                    System.out.println("La lettera " + carattere + " non e' presente.");
                    errori++;
                }
                Grafica.disegna(errori);
                provate = Utility.lettereProvate(carattere, provate);                       //il carattere viene aggiunto alla lista di quelli provati ma non presenti nella parola
                Utility.stampa(provate);
            }
            System.out.println("\n\nParola da indovinare: \n" + parola.getParolaSecretata());
            if (!Utility.contiene(parola.getParolaSecretata(), '*') || errori == vite) {
                if (errori == vite)                                                         //controllo che il gioco non sia finito per mancanza di vite (sconfitta)
                    System.out.println("Game over! La parola corretta era " + parola.getParola());
                else
                    System.out.println("Complimenti, hai vinto!");                          //oppure perché il giocatore ha indovinato tutte le lettere della parola
                fine = true;
            }
        }
    }
}