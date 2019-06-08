package com.company;


import java.io.*;
import java.util.Scanner;

public class Grafica {


    public static void disegna(int errori) {
        switch(errori) {
            case 0:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________");
                break;
            case 1:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|      (_)");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________");
                break;
            case 2:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|      (_)");
                System.out.println("|       | ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________");
                break;
            case 3:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|      (_)");
                System.out.println("|      /|");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________");
                break;
            case 4:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|      (_)");
                System.out.println("|      /|\\");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________");
                break;
            case 5:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|      (_)");
                System.out.println("|      /|\\");
                System.out.println("|       |");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________");
                break;
            case 6:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|      (_)");
                System.out.println("|      /|\\");
                System.out.println("|       |");
                System.out.println("|      / ");
                System.out.println("|        ");
                System.out.println("|________");
                break;
            case 7:
                System.out.println("_________");
                System.out.println("|/      |");
                System.out.println("|      (_)");
                System.out.println("|      /|\\");
                System.out.println("|       |");
                System.out.println("|      / \\");
                System.out.println("|        ");
                System.out.println("|________");
                break;
        }
    }

    public static void asciiart(){
        try {
            File file = new File("ascii.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine())
                System.out.println(sc.nextLine());
            sc.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Errore! ascii.txt non trovato!");
            System.out.println("Controllare che ascii.txt si trovi nella stessa directory del file jar!");
        }
    }

    public static void pulisciSchermo() {
        try {
            if( System.getProperty( "os.name" ).startsWith( "Windows" ) ) {
                Runtime.getRuntime().exec("cls");
            }
            else {
               Runtime.getRuntime().exec("clear");
            }
        }
        catch (IOException e) {
            for(int i = 0; i < 1000; i++) {
                System.out.println();
            }
        }
    }
}
