import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the guessing number game!");
        do {
            Scanner player = new Scanner(System.in);
            System.out.println("Type 'me', if you want to guess a number. Otherwise, I will guess a number. Enter exit to quit. ");
            String user = player.nextLine();
            if ("exit".equals(user)){
                exit(0);
            }
            while(!validateUser(user)) {
                System.out.println("Please insert 'me' or enter key. Exit to quit: ");
                user = player.nextLine();
                if ("exit".equals(user)){
                    exit(0);
                }
            }
            GuessGame guessGame = ("me".equals(user)) ? new HumanGuessGame() : new ComputerGuessGame();
            guessGame.startGame();
        } while (true);

    }


    public static boolean validateUser(String user){
        if ("me".equals(user) || user.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}

