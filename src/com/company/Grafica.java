package com.company;


import java.io.*;
import java.util.Scanner;

public class Grafica {

    public static void disegna(int errori) {
        /*disegna l'impiccato a seconda del numero di errori commessi dal giocatore*/
        switch(errori) {
            case 0:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________\u001b[0m");
                break;
            case 1:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("|      \u001b[35m(_)\u001b[0m");
                System.out.println("\u001b[33m|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________\u001b[0m");
                break;
            case 2:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("|      \u001b[35m(_)\u001b[0m");
                System.out.println("\u001b[33m|       \u001b[35m|\u001b[0m ");
                System.out.println("\u001b[33m|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________\u001b[0m");
                break;
            case 3:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("|      \u001b[35m(_)\u001b[0m");
                System.out.println("\u001b[33m|      \u001b[35m/|\u001b[0m");
                System.out.println("\u001b[33m|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________\u001b[0m");
                break;
            case 4:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("|      \u001b[35m(_)\u001b[0m");
                System.out.println("\u001b[33m|      \u001b[35m/|\\ \u001b[0m");
                System.out.println("\u001b[33m|        ");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|________\u001b[0m");
                break;
            case 5:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("|      \u001b[35m(_)\u001b[0m");
                System.out.println("\u001b[33m|      \u001b[35m/|\\ \u001b[0m");
                System.out.println("\u001b[33m|       \u001b[35m|\u001b[0m");
                System.out.println("\u001b[33m|        ");
                System.out.println("|        ");
                System.out.println("|________\u001b[0m");
                break;
            case 6:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("|      \u001b[35m(_)\u001b[0m");
                System.out.println("\u001b[33m|      \u001b[35m/|\\ \u001b[0m");
                System.out.println("\u001b[33m|       \u001b[35m|\u001b[0m");
                System.out.println("\u001b[33m|      \u001b[35m/\u001b[0m ");
                System.out.println("\u001b[33m|        ");
                System.out.println("|________\u001b[0m");
                break;
            case 7:
                System.out.println("\u001b[33m_________");
                System.out.println("|/      |");
                System.out.println("\u001b[33m|      \u001b[35m(_)\u001b[0m");
                System.out.println("\u001b[33m|      \u001b[35m/|\\ \u001b[0m");
                System.out.println("\u001b[33m|       \u001b[35m|\u001b[0m");
                System.out.println("\u001b[33m|     \u001b[35m / \\ \u001b[0m");
                System.out.println("\u001b[33m|        ");
                System.out.println("|________\u001b[0m");
                break;
        }
    }

    public static void asciiart(){
        /*stampa l'ascii art con il logo del gioco leggendo dal file ascii.txt*/
        try {
            File file = new File("ascii.txt");
            Scanner sc = new Scanner(file);

            System.out.println("\u001b[31m");
            while(sc.hasNextLine())
                System.out.println(sc.nextLine());
            System.out.println("\u001b[0m");
            sc.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("\u001b[31mErrore! ascii.txt non trovato! \u001b[0m");
            System.out.println("\u001b[31mControllare che ascii.txt si trovi nella stessa directory del file jar! \u001b[0m");
        }
    }

    public static void pulisciSchermo() {
        /*controlla il sistema operativo in uso e pulisce la console chiamando la funzione di sistema corretta*/
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
