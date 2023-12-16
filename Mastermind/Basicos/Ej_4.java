package Mastermind.Basicos;

public class Ej_4 {
    public static void main (String [] args) {
        //Structures control
        for(int i=10;i<30; i=i+2) {
            System.out.print(i+", ");
        }

        System.out.println("");
        //Structures control
        for (int age = 10 ; age <= 20 ; age += 2) {
            if (age > 18) {
                System.out.println("Have more than 18 anos");
            }
            else if (age >= 16) {
                System.out.println("Have more than 16 anos");
            }
            else {
                System.out.println("Have less than 16 anos");
            }
        }
    }
}