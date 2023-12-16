package Mastermind.YoRobot;

public class Ej_11 {

    public static void main (String [] args) {

        Robot r = new Robot();
        Robot Hector = new Robot();

        //r.Weight = 12.63f;
        r.setWeight(120);
        System.out.println(r.getWeight());
        //Hector.Weight = 2.00f;
        Hector.setWeight(-98);
        System.out.println(Hector.getWeight());
    }
}
