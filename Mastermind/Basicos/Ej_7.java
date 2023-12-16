package Mastermind.Basicos;

import java.util.Scanner;

public class Ej_7 {

    public static String Questions(String Question) {
        //*Invocamos un scaner para leer la respuesta*
        Scanner sc = new Scanner(System.in);
         //Question
        System.out.println(Question);
        //Answer
        String answer = sc.nextLine();
        //*Le pasamos el nombre a la funcion triaje *//
        return answer;
    }

    public static void departTrauma(String name) {
            //More questions 
            System.out.println(name);
    }

    public static void triaje (String name) {
        String answer = Questions(name + " Do you have any fallen? [S,N]");
        while (!answer.equals("S") && !answer.equals("N")) {
            answer = Questions(name + "Do you have any fallen? [S,N]");
        }
        if(answer.equals("S")) {
			//TRAUMATOLOGIA
			System.out.println("Trauma");
			departTrauma(name);
		}else if(answer.equals("N")){
			//Preguntamos si tiene fiebre
			answer=Questions(name + " ¿Has tenido fiebre?[S,N]");
			while(!answer.equals("S") && !answer.equals("N")) {
				answer = Questions( name +" ¿Has tenido fiebre?[S,N]");
			}
		}

    }


    public static void main (String [] args) {
        String name = Questions("Who is your name?");
        triaje(name);
    }

}