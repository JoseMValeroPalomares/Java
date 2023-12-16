package Mastermind.Basicos;

import java.util.Scanner;
import java.util.Random;

public class Ej_10 {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla: " + e.getMessage());
        }
    }

    public static int questionsInt(String Question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Question);
        int answer = sc.nextInt();
        return answer;
    }

    public static void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int rand(int x) {
        Random random = new Random();
        int score = random.nextInt(x) + 1;
        return score;
    }


    public static int showMenu() {
        // Lo implementare en un futuro porblamente muy muy lejano xD
        //Easy =
        //Normal = 
        //Impossible =
        System.out.println(" ------Welcome to my Pig Game ------");
        System.out.println("");
        System.out.println("       Choose a level [1,2,3]  ");
        System.out.println("        -1: Easy");
        System.out.println("        -2: Normal");
        System.out.println("        -3: Impossible");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(" ---------------------------------");
        int answer = questionsInt(" ");
        while (answer < 1 || answer > 3) {
            answer = questionsInt("Incorrect level, choose other.");
        }
        System.out.println("");
        System.out.println("You choose lvl " + answer + " Wait ...");
        sleep(2000);
        return answer;
    }


    public static void showStats(int scorePl, int scoreIA) {
        clearScreen();
        System.out.println("               STATS:");
        System.out.println("-Player stats =  "  + "00/100 = " + scorePl);
        System.out.println("-IA stats = " + "00/100 = " + scoreIA);
    }


    public static int turnPl(int scorePl, int scoreIA) {
        clearScreen();
        System.out.println("It's your turn.");
        System.out.println("");
        sleep(500);
        int answer = questionsInt("Do you want to roll? [0] No [1] Yes");
        int random = rand(6);
        while (answer == 1 && scorePl < 100 && random != 1) {
            random = rand(6);
            scorePl += random;
            System.out.println("You gained " + random + " points.");
            answer = questionsInt("Do you want to roll? [0] No [1] Yes");
            showStats(scorePl, scoreIA);
        }

        return scorePl;
    }


    public static int turnIA(int scorePl, int scoreIA) {
        clearScreen();
        System.out.println("It's the IA's turn");
        System.out.println("");
        sleep(1000);
        int random = rand(6);
        scoreIA += random;
        System.out.println("IA gained " + random + " points.");
        showStats(scorePl, scoreIA);
        sleep(1000);

        while (random != 1 && scoreIA < 100) {
            random = rand(6);
            scoreIA += random;
            System.out.println("IA gained " + random + " points.");
            showStats(scorePl, scoreIA);
            sleep(1000);
        }

        return scoreIA;
    }

    
    public static void main(String[] args) {
        int scorePl = 0;
        int scoreIA = 0;
        clearScreen();
        int dif = showMenu();
        int first = rand(2); // Generar un número aleatorio entre 1 y 2

        if (first == 1) {
            scoreIA = turnIA(scorePl, scoreIA);
            scorePl = turnPl(scorePl, scoreIA);
        } else {
            scorePl = turnPl(scorePl, scoreIA);
            scoreIA = turnIA(scorePl, scoreIA);
        }

        while (scoreIA < 100 && scorePl < 100) {
            if (first == 1) {
                scoreIA = turnIA(scorePl, scoreIA);
                scorePl = turnPl(scorePl, scoreIA);
            } else {
                scorePl = turnPl(scorePl, scoreIA);
                scoreIA = turnIA(scorePl, scoreIA);
            }
        }

        if (scoreIA >= 100) {
            System.out.println("The IA wins the game.");
        } else {
            System.out.println("You win the game.");
        }
    }
}
