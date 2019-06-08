package com.company;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Utility {

    public static String secretaParola(String parola) {
        String segreta = "";
        for(int i = 0; i < parola.length(); i++)
            segreta = segreta + "*";
        return segreta;
    }

    public static boolean inputValido(String input) {
        if(input.length()!=1 || Utility.isNumeric(input) || input.contains(" ")) {
            System.out.println("Input non valido!");
            return false;
        }
        else return true;
    }

    private static boolean isNumeric(String input) {
        return Pattern.compile("[0-9]").matcher(input).find();
    }

    public static ArrayList posizioniCarattere(char carattere, Parola parola) {
        ArrayList posizioni = new ArrayList();
        for(int i = 0; i < parola.getParola().length(); i++) {
            if(carattere == parola.getParola().charAt(i))
                posizioni.add(i);
        }
        return posizioni;
    }

    public static void sostituisci(Parola parola, ArrayList posizioni) {
        char[] temp = parola.getParolaSecretata().toCharArray();
        for(int i = 0; i < posizioni.size(); i++)
            temp[(int) posizioni.get(i)] = parola.getParola().charAt((int) posizioni.get(i));
        String nuova = new String(temp);
        parola.setParolaSecretata(nuova);
    }

    public static boolean contiene(String segreta, char carattere) {
        if(segreta.contains(Character.toString(carattere))) return true;
        else return false;
    }

    public static ArrayList lettereProvate(char carattere, ArrayList provate) {
        if(provate.contains(carattere)) return provate;
        else {
            provate.add(carattere);
            return provate;
        }
    }

    public static void stampa(ArrayList provate) {
        System.out.println("\nLettere provate: ");
        for(int i = 0; i < provate.size(); i++)
            System.out.print(provate.get(i)+" ");
    }

    public static boolean sceltaValida(String scelta) {
        if(scelta.equals("s") || scelta.equals("S") || scelta.equals("n") || scelta.equals("N"))
            return true;
        else {
            System.out.println("Scelta non valida, riprova.");
            return false;
        }
    }

    public static boolean scelta(String scelta) {
        if(scelta.equals("S") || scelta.equals("s"))
            return true;
        else return false;
    }
}