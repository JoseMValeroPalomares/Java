package Mastermind.Basicos;

public class Ej_6 {
    //Function total price
    public static float totalPrice(float priceId, int uds) {
        System.out.println("----- Funtion for calculate the total price of a 1 product -----");
        float priceT;
        priceT = priceId * uds;
        System.out.println("Total price: " + priceT);

        return priceT;
    }


    public static void main (String [] args) {
        float priceofProduct = totalPrice(52.5f, 4);
        System.out.println(priceofProduct);

    }
} 