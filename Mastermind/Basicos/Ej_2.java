package Mastermind.Basicos;

public class Ej_2{
    public static void main(String[] args) {
        //Perosnal dates
        String name = "Ricky";
        String subname = "Rubio";
        int height = 188;
        int age = 31;

        //Team dates
        int dorsal = 13;
        String team = "Cavaliers";

        //Season 21-22
        float pointsMatch = 13.1f;
        float rebMatch = 4.1f;
        float asisMatch = 6.6f;
        boolean lesionado = true;

        //Dates for screen 
        System.out.println("-------Personal dates-------");
        System.out.println("Name : " + name + " f" + subname);
        System.out.println("Heigth : " + height);
        System.out.println("Age : " + age);
        System.out.println("-------Team dates-------");
        System.out.println("Dorsal : " + dorsal);
        System.out.println("Team : " + team);
        System.out.println("Age : " + age);
        System.out.println("-------Season dates-------");
        System.out.println("PP : " + pointsMatch);
        System.out.println("RP : " + rebMatch);
        System.out.println("AP : " + asisMatch);
        System.out.println("Lesionado? : " + lesionado);

    }

}