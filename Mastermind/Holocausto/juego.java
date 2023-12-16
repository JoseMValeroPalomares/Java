package Holocausto;

public class juego {
    public juego() {

    } 

    public static void paintRoom(Room Room) {
        for(int fil = 0;fil < Room.Alto; fil ++) {
            for (int col = 0; col < Room.Ancho; col ++) {
                Position position = new Position(col, fil);

                if (Room.isDoor(position)) System.out.print(" ");
                if (col == 0 || col == Room.Ancho -1) System.out.print("|");
                else if (fil==0 || fil == Room.Alto -1) System.out.print("=");
                else System.out.print(" ");
                
                if (col == Room.Ancho -1) System.out.println();
            } 
        }
    }
}