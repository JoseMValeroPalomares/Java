package Holocausto;

public class Position {
    private int posX;
    private int posY;

    public Position() {
        this.posX = 0;
        this.posY = 0;
    }

    public Position(int posX, int posY) {
        this.posX = posX; // Corrección aquí
        this.posY = posY; // Corrección aquí
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isSame(Position pos) {
        if (pos == null) return false; // Verificar si pos es nulo y devolver false
        return (pos.posX == this.posX && pos.posY == this.posY);
    }
}
