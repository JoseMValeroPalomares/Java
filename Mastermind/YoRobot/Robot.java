package Mastermind.YoRobot;

public class Robot {

    private float Weight;

    public Robot(){

    }

    public void setWeight(float w){
        if (w < 0) this.Weight = 0;
        else this.Weight = w;
    }

    public float getWeight() {
        return Weight;
    }
}
