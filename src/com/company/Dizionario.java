package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Dizionario {

    ArrayList<String> wordlist = new ArrayList<String>();

    public Dizionario() {

        try {
            File dizionario = new File("./wordlist.txt");
            Scanner parola = new Scanner(dizionario);

            while(parola.hasNextLine())
                this.wordlist.add(parola.nextLine().toUpperCase());

            sanitizeWordlist();
            System.out.println("La wordlist contiene "+ this.wordlist.size() + " parole!\n\n");
            parola.close();
        }

        catch(FileNotFoundException e) {
            System.out.println("Errore! wordlist.txt non trovato!");
        }
    }

    private void sanitizeWordlist() {
        int cont = 0;
        for(int i = 0; i < this.wordlist.size(); i++) {
            if(this.wordlist.get(i).contains("'") || this.wordlist.get(i).contains("À") || this.wordlist.get(i).contains("È") || this.wordlist.get(i).contains("É") || this.wordlist.get(i).contains("Ì") || this.wordlist.get(i).contains("Ò") || this.wordlist.get(i).contains("Ù") || this.wordlist.get(i).contains(" ")) {
                this.wordlist.remove(i);
                cont ++;
            }
        }
        System.out.println("Rimosse dalla wordlist " + cont + " parole non adatte.");
    }

    public String getParolaRandom() {
        Random r = new Random();
        return wordlist.get(r.nextInt(wordlist.size()));
    }
}
