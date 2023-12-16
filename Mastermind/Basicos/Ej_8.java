package Mastermind.Basicos;

import java.util.Scanner;

public class Ej_8 {
    public static void main(String [] args) {
        //Array definition
        String names[] = {"Paco", "Lucia", "Marcos", "Sandra", "Nate", "Pepe","TuMama",""};
        float califications[] = new float[10];
        String apellidos[] = new String[20];

        califications[0] = 3.45f;

        Scanner sc = new Scanner(System.in);
        System.out.println("Who is the next name?");
        String finalName = sc.nextLine();
        names[names.length -1] = finalName;

        for (int i = 0; i < names.length; i ++ ) {
            System.out.println(names[i]);
        }
    }
}
