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
        if(input.length()!=1 || Utility.isNumeric(input)) {
            System.out.println("Input non valido!");
            return false;
        }
        else return true;
    }

    private static boolean isNumeric(String input) {
        return Pattern.compile("[0-9]").matcher(input).find();
    }

    public static ArrayList posizioniCarattere(char carattere, String parola) {
        ArrayList posizioni = new ArrayList();
        for(int i = 0; i < parola.length(); i++) {
            if(carattere == parola.charAt(i))
                posizioni.add(i);
        }
        return posizioni;
    }

    public static String sostituisci(String parola, String segreta, ArrayList posizioni) {
        char[] temp = segreta.toCharArray();
        for(int i = 0; i < posizioni.size(); i++)
            temp[(int) posizioni.get(i)] = parola.charAt((int) posizioni.get(i));
        String nuova = new String(temp);
        return nuova;
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

}

