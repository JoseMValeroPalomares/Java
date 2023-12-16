package Mastermind.Basicos;

import java.util.Scanner;

public class Ej_9 {
    
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("cls");
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla: " + e.getMessage());
        }
    }

    public static float Questions(String Question) {
        //*Invocamos un scaner para leer la respuesta*
        Scanner sc = new Scanner(System.in);
         //Question
        System.out.println(Question);
        //Answer
        float answer = sc.nextFloat();
        //*Le pasamos el nombre a la funcion triaje *//
        return answer;
    }

        public static String Questionstring(String Question) {
        //*Invocamos un scaner para leer la respuesta*
        Scanner sc = new Scanner(System.in);
         //Question
        System.out.println(Question);
        //Answer
        String answer = sc.nextLine();
        //*Le pasamos el nombre a la funcion triaje *//
        return answer;
    }


     public static int Questionsint(String Question) {
        //*Invocamos un scaner para leer la respuesta*
        Scanner sc = new Scanner(System.in);
         //Question
        System.out.println(Question);
        //Answer
        int answer = sc.nextInt();
        //*Le pasamos el nombre a la funcion triaje *//
        return answer;
    }


    public static int showMenu(boolean error) {
        Scanner sc = new Scanner(System.in);
        if (error) System.out.println("Introduce a valor into [0,1,2,3]");
        System.out.println("------Menu-------");
        System.out.println("[0] End");
        System.out.println("[1] New Date");
        System.out.println("[2] Show Date");
        System.out.println("[3] Delete date ");
        System.out.println("-----------------");
        System.out.println("Your opcion [0,1,2,3] ->");
        int answer = sc.nextInt();
        while (answer < 0 || answer > 3) answer = showMenu(true);
        return answer;
    }

    public static int varEdit(float t[]) {
        int date = Questionsint("Which data do you want to access?");
        while (date <0 || date >= t.length) {
            date = Questionsint("Which data do you want to access?");
            
        }
        return date;
    }

    public static void newDate(float t[], float d[], String l[]) {
        int date = varEdit(t);
        float answer = Questions("Introduce the new time in min.seg");
        t[date] = answer;
        answer = Questions("Introduce the new distances in km.m");
        d[date] = answer;
        String answerString = Questionstring("Introduce the label");
        l[date] = answerString;
    }


    public static void showDates(float t[], float d[], String l[]) {
        System.out.println("------Show dates------");
        for (int i = 0;i < t.length; i++ ) {
            System.out.println("Dato [" + i + "] " + " Time: " + t[i] + " Distance: " + d[i] + " Label: " + l[i] );
        }
    }

    public static void deleteDate(float t[], float d[], String l[]) {
        int date = varEdit(t);
        t[date] = 0;
        d[date] = 0;
        l[date] = "";
    }


    public static void main (String [] args) {
        int Answer = 1;
        float times[] = new float [10];
        float distances[] = new float [10];
        String labels[] = {"", "", "", "", "", "", "", "", "", ""};
        int ultiRegister = 0;
       
        Answer = showMenu(false);

        while(Answer != 0) {
            switch(Answer) {
                case 1:
                    newDate(times, distances, labels);
                    ultiRegister++;
                    break;
                case 2:
                    clearScreen();
                    showDates(times, distances, labels);
                    break;
                case 3:
                    deleteDate(times, distances, labels);
                    ultiRegister --;
                    break;
            }
            Answer = showMenu(false);
        }
    }
}
