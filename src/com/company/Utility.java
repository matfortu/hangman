package com.company;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Utility {

    public static String secretaParola(String parola) {
        /*restituisce una stringa della stessa lunghezza della parola da indovinare ma con asterischi invece delle lettere*/
        String segreta = "";
        for(int i = 0; i < parola.length(); i++)
            segreta = segreta + "*";
        return segreta;
    }

    public static boolean inputValido(String input) {
        /*controlla se la stringa data in input sia valida, contenga un solo carattere e non sia un numero*/
        if(input.length()!=1 || Utility.isNumeric(input) || input.contains(" ")) {
            System.out.println("\u001b[31mInput non valido! \u001b[0m");
            return false;
        }
        else return true;
    }

    private static boolean isNumeric(String input) {
        /*controlla che la stringa in ingresso non contenga numeri*/
        return Pattern.compile("[0-9]").matcher(input).find();
    }

    public static ArrayList posizioniCarattere(char carattere, Parola parola) {
        /*restituisce un ArrayList contenente le posizioni in cui si trova il carattere da cercare nella parola da indovinare*/
        ArrayList posizioni = new ArrayList();
        for(int i = 0; i < parola.getParola().length(); i++) {
            if(carattere == parola.getParola().charAt(i))
                posizioni.add(i);
        }
        return posizioni;
    }

    public static void sostituisci(Parola parola, ArrayList posizioni) {
        /*sostituisce il*/
        char[] temp = parola.getParolaSecretata().toCharArray();    //converto l'ArrayList in un array per poi creare una stringa alla fine
        for(int i = 0; i < posizioni.size(); i++)
            temp[(int) posizioni.get(i)] = parola.getParola().charAt((int) posizioni.get(i));
        String nuova = new String(temp);
        parola.setParolaSecretata(nuova);
    }

    public static boolean contiene(String segreta, char carattere) {
        /*controlla se la stringa contiene un dato carattere*/
        if(segreta.contains(Character.toString(carattere))) return true;
        else return false;
    }

    public static ArrayList lettereProvate(char carattere, ArrayList provate) {
        /*controlla se l'ArrayList contiene già un determinato carattere*/
        if(provate.contains(carattere)) return provate;
        else {
            provate.add(carattere);
            return provate;
        }
    }

    public static void stampa(ArrayList provate) {
        /*funzione di stampa di ArrayList*/
        System.out.println("\nLettere provate: ");
        for(int i = 0; i < provate.size(); i++)
            System.out.print(provate.get(i)+" ");
    }

    public static boolean sceltaValida(String scelta) {
        /*controlla se il carattere di scelta tra 's' e 'n' quando viene richiesto se iniziare una nuova partita sia valida*/
        if(scelta.equals("s") || scelta.equals("S") || scelta.equals("n") || scelta.equals("N"))
            return true;
        else {
            System.out.println("\u001b[31mScelta non valida, riprova. \u001b[0m");
            return false;
        }
    }

    public static boolean scelta(String scelta) {
        /*valuta la scelta affermativa o negativa*/
        if(scelta.equals("S") || scelta.equals("s"))
            return true;
        else return false;
    }
}