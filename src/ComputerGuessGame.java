import java.util.Scanner;

public class ComputerGuessGame extends GuessGame{

    @Override
    public void startGame(){
        Scanner size = new Scanner(System.in);
        char sz = '\0';
        int min = MIN_NUMBER;
        int max = MAX_NUMBER;
        int average;
        while(sz != '=') {
            average = (min + max) / 2;
            System.out.println("Is your number " + average + "?");
            sz = size.next().charAt(0);
            if (!validateUserInput(sz))
                continue;
            if (sz == '+') {
                min = average + 1;
            } else {
                max = average - 1;
            }
        }
        System.out.println("I win!");

    }

    public boolean validateUserInput(char input){
       if (input != '+' && input != '-' && input != '='){
           System.out.println("You should type either: '+', '-' or '='");
           return false;
       }
       return true;


    }
}
