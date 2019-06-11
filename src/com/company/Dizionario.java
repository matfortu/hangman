package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Dizionario {

    ArrayList<String> wordlist = new ArrayList<String>();       //ArrayList perché la lunghezza del dizionario deve essere variabile a seconda del wordlist.txt utilizzato

    public Dizionario() {
        /*COSTRUTTORE DEL DIZIONARIO*/
        try {
            File dizionario = new File("wordlist.txt");
            Scanner parola = new Scanner(dizionario);

            while(parola.hasNextLine())
                this.wordlist.add(parola.nextLine().toUpperCase());

            sanitizeWordlist();
            System.out.println("\u001b[32mLa wordlist contiene "+ this.wordlist.size() + " parole!\u001b[0m\n\n");
            parola.close();
        }

        catch(FileNotFoundException e) {
            System.out.println("\u001b[31mErrore! wordlist.txt non trovato! \u001b[0m");
        }
    }

    private void sanitizeWordlist() {
        /*Elimina dal dizionario le parole della wordlist che contengono vocali con accenti o apostrofi*/
        int cont = 0;
        for(int i = 0; i < this.wordlist.size(); i++) {
            if(this.wordlist.get(i).contains("'") || this.wordlist.get(i).contains("À") || this.wordlist.get(i).contains("È") || this.wordlist.get(i).contains("É") || this.wordlist.get(i).contains("Ì") || this.wordlist.get(i).contains("Ò") || this.wordlist.get(i).contains("Ù") || this.wordlist.get(i).contains(" ")) {
                this.wordlist.remove(i);
                cont ++;
            }
        }
        System.out.println("\u001b[33mRimosse dalla wordlist " + cont + " parole non adatte.\u001b[0m");
    }

    public String getParolaRandom() {
        Random r = new Random();
        try{
            return wordlist.get(r.nextInt(wordlist.size()));    //ritorna una parola estratta a caso dalla wordlist caricata
        }
        catch(IllegalArgumentException e) {
            System.out.println("\u001b[31mControllare che wordlist.txt si trovi nella stessa directory del file jar! \u001b[0m");
            return "";
        }
    }
}
