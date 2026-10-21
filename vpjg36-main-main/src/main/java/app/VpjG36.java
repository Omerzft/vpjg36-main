/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

import java.util.Scanner;


public class VpjG36 {
    
   static Scanner reader = new Scanner(System.in);
    
    
    static void zad_2(){
        
        try {
            System.out.println("Въведете число");
        int a = Integer.parseInt(reader.nextLine());
                System.out.println("Въведете 2nd число");
        int b = Integer.parseInt(reader.nextLine());
        System.out.println(a+b);
        double c = Math.pow(a, b);
        System.out.println(c);
        } catch (Exception e) {System.out.println("Въведете число");
        }
    }
    

    public static void main(String[] args) {
        zad_2();
      
    }
}
