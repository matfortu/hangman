package com.company;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Dizionario {

    public static String parolaSegreta() {

        try {
            File dizionario = new File("C:\\wordlist.txt");
            Scanner parola = new Scanner(dizionario);
            ArrayList<String> wordlist = new ArrayList<String>();
            Random r = new Random();

            while(parola.hasNextLine())
                wordlist.add(parola.nextLine().toUpperCase());

            System.out.println("\nLa wordlist contiene "+ wordlist.size() + " parole!\n\n");
            parola.close();
            return wordlist.get(r.nextInt(wordlist.size()));
        }

        catch(FileNotFoundException e) {
            System.out.println("Errore! wordlist.txt non trovato!");
            return "";
        }
    }

}
