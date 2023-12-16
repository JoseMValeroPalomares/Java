package Holocausto;

public class Room {
    public static final int Ancho = 6;
    public static final int Alto = 6;

    private Position doorEntry;
    private Position doorExit;

    private Character player;

    public Position getDoorExit() {
        return doorExit;
    }


    public void setDoorExit(Position doorExit) {
        this.doorExit = doorExit;
    }


    public Position getDoorEntry() {
        return doorEntry;
    }


    public void setDoorEntry(Position doorEntry) {
        this.doorEntry = doorEntry;
    }


    public Room() {
        System.out.println("Making a room");
    }

    public void setPlayer(Character player) {
        this.player = player;
    }

    public boolean isDoor(Position door) {
        if (doorEntry == null || doorExit == null) return false; // Verificar que doorEntry y doorExit no sean nulos
        return (door.isSame(doorEntry) || door.isSame(doorExit));
    }

}

