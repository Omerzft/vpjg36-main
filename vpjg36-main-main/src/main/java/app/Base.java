package app;

import java.util.Scanner;

public class Base {

    static Scanner reader = new Scanner(System.in);
    
    static void zad_2(){
        try {
            System.out.println("Въведете число:");
            int a = Integer.parseInt(reader.nextLine());
            System.out.println("Въведете число:");
            int b = Integer.parseInt(reader.nextLine());
            System.out.println(a+b);
            double c = Math.pow(a, b);
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("Въведете число!");
        }
    }
        
    static void zad_1(){
        System.out.printf("Аз съм %s, фн %s, уча %s", "Georgi", "115757", 
                "програмиране");
    }
    
    public static void main(String[] args) {
        zad_2();
    }
}
