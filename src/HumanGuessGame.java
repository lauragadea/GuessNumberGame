import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class HumanGuessGame extends GuessGame{
    @Override
    public void startGame(){
        int secretNumber = generateRandomNumber();
        Scanner number = new Scanner(System.in);
        // check this
        int nbr = 0;

        do{


            System.out.println("Choose a number from " + MIN_NUMBER + " to " + MAX_NUMBER + ":");
            try {
                nbr = number.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You cannot insert strings or negative or float numbers, please follow the rules.");
                // consumes the invalid input
                number.next();
                continue;
            }
            while(!checkValidRange(nbr)) {
                System.out.println("You can only insert a number from " + MIN_NUMBER + " to " + MAX_NUMBER);
                System.out.println("Choose a number from " + MIN_NUMBER + " to " + MAX_NUMBER + ":");
                nbr = number.nextInt();
            }
            validateNumber(nbr, secretNumber);


        }while (nbr != secretNumber);
        System.out.println("You've guessed the number!");

        }



    public boolean checkValidRange(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER){
            return true;
        } else {
            return false;
        }
    }

    public int generateRandomNumber(){
        Random rand = new Random();
        /*generate random number from 1 to 100*/
        int secretNumber = rand.nextInt(MAX_NUMBER) + 1;
        return secretNumber;
    }

    public void validateNumber(int nbr, int secretNumber){

        if (nbr < secretNumber) {
            System.out.println("My number is bigger");
        } else if (nbr > secretNumber){
            System.out.println("My number is smaller");
        }
    }



}
