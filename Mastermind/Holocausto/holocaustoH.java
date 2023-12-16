package Holocausto;

public class holocaustoH {

    public static void  main (String [] args) {
        //Position posInicial = new Position();
        //posInicial.setPosX(3);
        //posInicial.setPosY(0);

        Position posInicial = new Position(3 , 0);

        Room rom1 = new Room();

        Character player = new Character();
        player.setPos(posInicial);

        
        juego.paintRoom(rom1);
    }
} 