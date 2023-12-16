
import java.util.Random;
import java.util.Scanner;

public class pigGame {

    // function that clears the screen
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("cls");
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla: " + e.getMessage());
        }
    }

    // This function allows you to make an enter
    public static void inputEnter() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        String a = sc.nextLine();
    }

    // This function allows you to make an enter and clear the screen
    public static void enterClear() {
        inputEnter();
        clearScreen();
    }


    // Sum the AI points
    public static int return_aiScoreSum(int aiScore[], int aiRoll, int aiLastPoint) {

        aiScore[aiLastPoint(aiLastPoint)] = aiRoll;

        int aiScoreSum = 0;

        for(int i = 0; i < aiScore.length; i++) {
                aiScoreSum = aiScoreSum + aiScore[i];
            }

        return aiScoreSum;      
    }

    // Sum the user points
    public static int return_userScoreSum(int userScore[], int userRoll, int userLastPoint) {

        userScore[userLastPoint(userLastPoint)] = userRoll;

        int userScoreSum = 0;
        
        for(int i = 0; i < userScore.length; i++) {
                userScoreSum = userScoreSum + userScore[i];
            }

        return userScoreSum;         
    }


    // AI Choice
    public static int aiChoice(int aiChoice) {
        Random random = new Random();
        aiChoice = random.nextInt(2);
        return aiChoice;
    }

    // Indicate the last AI's roll
    public static int aiLastPoint(int aiLastPoint)  {
        aiLastPoint++;
        return aiLastPoint;
    } 

    // Indicate the last user's roll
    public static int userLastPoint(int userLastPoint)  {
        userLastPoint++;
        return userLastPoint;
    }  


    // Make a question to user
    public static String inputString(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        String answer = sc.nextLine();
        return answer;
    }

    // AI's turn
    public static int[] aiTurn(int aiRoll, int aiScoreSum, int aiScore[], int aiLastPoint, int userScoreSum, int aiChoice) {

        Random random = new Random();
        aiRoll = random.nextInt(6);
        System.out.println("The AI's roll has been " + aiRoll);

        if(aiRoll == 1){
            aiScoreSum = aiScoreSum - 10;
        }
        else{
            aiScoreSum = return_aiScoreSum(aiScore, aiRoll, aiLastPoint);
            aiLastPoint = aiLastPoint(aiLastPoint);
        }

        // Tercera opcion de la logica
        if(100 - userScoreSum <= 10) {
            while((aiScoreSum != 100) && aiRoll != 1) {
                random = new Random();
                aiRoll = random.nextInt(6);
                System.out.println("The AI's roll has been " + aiRoll);

                if(aiRoll == 1){
                    aiScoreSum = aiScoreSum - 10;
                }
                else{
                    aiScoreSum = return_aiScoreSum(aiScore, aiRoll, aiLastPoint);
                    aiLastPoint = aiLastPoint(aiLastPoint);
                }
            }
        }
        else {
            aiChoice = aiChoice(aiChoice);

            // Primera opcion de la logica
            if(aiChoice == 1) {

                while(aiChoice == 1) {
                    random = new Random();
                    aiRoll = random.nextInt(6);
                    System.out.println("The AI's roll has been " + aiRoll);

                    if(aiRoll == 1){
                        aiScoreSum = aiScoreSum - 10;
                    }
                    else{
                        aiScoreSum = return_aiScoreSum(aiScore, aiRoll, aiLastPoint);
                        aiLastPoint = aiLastPoint(aiLastPoint);
                    }
                    aiChoice = aiChoice(aiChoice);

                    if(aiScoreSum >= 100) {
                            break;
                    }

                }  

            }   

            // Segunda opcion de la logica
            else if(aiChoice == 2) {
                if(aiScoreSum < userScoreSum) {
                    while((aiScoreSum < userScoreSum) || (aiRoll == 1)) {
                        random = new Random();
                        aiRoll = random.nextInt(6);
                        System.out.println("The AI's roll has been " + aiRoll);

                        if(aiRoll == 1){
                            aiScoreSum = aiScoreSum - 10;
                        }
                        else{
                            aiScoreSum = return_aiScoreSum(aiScore, aiRoll, aiLastPoint);
                            aiLastPoint = aiLastPoint(aiLastPoint);
                        }

                        if(aiScoreSum >= 100) {
                            break;
                        }

                    }

                }
            }
        }

        if(aiScoreSum < 0) {
            aiScoreSum = 0;
        }

        int aiScoreSum_aiLastPoint[] = {aiScoreSum, aiLastPoint};
        return aiScoreSum_aiLastPoint;
    }

    // User's turn
    public static int[] userTurn(int userRoll, int userScoreSum, int userScore[], int userLastPoint, int aiScoreSum) {

        String question = "Would you like to roll? [Y/N]: ";
        String answer = "";

        while((answer != "Y") && (answer != "N")) {
            answer = inputString(question);
            clearScreen();

            if(answer.equals("Y")) {
                Random random = new Random();
                userRoll = random.nextInt(6);
                System.out.println("The user's roll has been " + userRoll);

                if(userRoll == 1) {
                    userScoreSum = userScoreSum -10;
                }
                else {
                    userScoreSum = return_userScoreSum(userScore, userRoll, userLastPoint);
                    userLastPoint = userLastPoint(userLastPoint);
                }
                enterClear();
            }
            else if(answer.equals("N")) {
                break;
            }

            if(userScoreSum >= 100) {
                break;
            }
            
        }

        if(userScoreSum < 0) {
            userScoreSum = 0;
        }
        

        int userScoreSum_userLastPoint[] = {userScoreSum, userLastPoint}; 
        return userScoreSum_userLastPoint;
    }

    // Show's the game stats
    public static void showPuntuations(int aiScoreSum, int userScoreSum, int pointsBarSize, int pointsToWin) {

        int aiPointsBar = (int) (aiScoreSum * pointsBarSize / pointsToWin);
        int userPointsBar = (int) (userScoreSum * pointsBarSize / pointsToWin);
        String fillingPoints = "#";
        String fillingNoPoints = " ";

        System.out.println("------------------GAME STATS------------------");
        System.out.println("This is the ai puntuation: [" + fillingPoints.repeat(aiPointsBar) + fillingNoPoints.repeat(pointsBarSize - aiPointsBar) +  "]" + " ("+ aiScoreSum +"/"+ pointsToWin +")p");
        System.out.println("This is the user puntuation: [" + fillingPoints.repeat(userPointsBar) + fillingNoPoints.repeat(pointsBarSize - userPointsBar) +  "]" +" ("+ userScoreSum +"/"+ pointsToWin +")p");
        System.out.println("----------------------------------------------");
    }

    // Shows the menu
    public static void showMenu() {
        System.out.println("-------------------PIG GAME-------------------");
        System.out.println("- The one who arrives first at 100 points wins");
        System.out.println("- You'll have to roll a dice the times you want");
        System.out.println("- And your points will be the sum of the numbers you get when you roll the dice");
        System.out.println("- But if you get a 1, the pig will stole you 10 points");
        System.out.println("- Enter to start --->");
        System.out.println("----------------------------------------------");
        enterClear();
    }

    // If the user's points are > 100 this puts the points to 100
    public static int userPointsTo100(int userScoreSum, int pointsToWin) {
        if((userScoreSum > pointsToWin)) {
            userScoreSum = pointsToWin;
        }
        return userScoreSum;
    } 

    // If the ai's points are > 100 this puts the points to 100
    public static int aiPointsTo100(int pointsToWin, int aiScoreSum) {
        if((aiScoreSum > pointsToWin)) {
            aiScoreSum = pointsToWin;
        }
        return aiScoreSum;
    }


    public static void main(String[] args) {
        int pointsBarSize = 10;
        int aiScore[] = new int[1000];
        int userScore[] = new int[1000];
        int aiLastPoint = 0;
        int userLastPoint = 0;
        int aiRoll = 0;
        int userRoll = 0;
        int aiChoice = 0;
        int aiScoreSum = 0;
        int userScoreSum = 0;
        int pointsToWin = 100;

        clearScreen();

        // Menu
        showMenu();

        while((aiScoreSum != 100) && (userScoreSum != 100)) {

            // Ai's turn
            System.out.println("AI'S TURN");
            enterClear(); 

            int aiScoreSum_aiLastPoint[] = aiTurn(aiRoll, aiScoreSum, aiScore, aiLastPoint, userScoreSum, aiChoice);
            aiScoreSum = aiScoreSum_aiLastPoint[0];
            aiLastPoint = aiScoreSum_aiLastPoint[1];

            // Puts points to 100 if it's overpass
            aiScoreSum = aiPointsTo100(pointsToWin, aiScoreSum);
            userScoreSum = userPointsTo100(userScoreSum, pointsToWin); 

            // Show game stats
            enterClear();
            showPuntuations(aiScoreSum, userScoreSum, pointsBarSize, pointsToWin);
            enterClear();

            // Check winner. Is the AI arrives to 100 in this case I'll have to possibility to do an other roll
            if(aiScoreSum == 100) {
                break;
            }

            // User's turn
            System.out.println("USER'S TURN");
            enterClear(); 
     
            int userScoreSum_userLastPoint[] = userTurn(userRoll, userScoreSum, userScore, userLastPoint, aiScoreSum);
            userScoreSum = userScoreSum_userLastPoint[0];
            userLastPoint = userScoreSum_userLastPoint[1];

            // Puts points to 100 if it's overpass
            userScoreSum = userPointsTo100(userScoreSum, pointsToWin);
            aiScoreSum = aiPointsTo100(pointsToWin, aiScoreSum);

            // Show game stats
            showPuntuations(aiScoreSum, userScoreSum, pointsBarSize, pointsToWin);
            enterClear();

        }

        // Checks who has win
        if(aiScoreSum == pointsToWin) {
            enterClear();
            System.out.println("The AI has won");
        }
        else {
            enterClear();
            System.out.println("The user has won");
        }
    }
}
