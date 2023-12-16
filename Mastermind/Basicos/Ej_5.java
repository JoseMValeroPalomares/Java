package Mastermind.Basicos;

public class Ej_5 {
    public static void main (String [] args) {
        int x = 5;
        int y = 7;

        for (int filas = 1; filas <= y; filas++) {
            System.out.println("Fila: " + filas);
            for (int columna = 1; columna <= x; columna++) {
                if ((columna == 1) && (filas != 7)) {
                    System.out.print("*");
                } else if (filas == 7) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
