import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ComputerGuessGameTest {
    ComputerGuessGame cGame = new ComputerGuessGame();

    @Test
    public void validateIncorrectUserInputTest(){
        char invalidInput = 's';
        assertEquals(false, cGame.validateUserInput(invalidInput));
    }

    @Test
    public void validateCorrectUserInputTest(){
        char validInput = '+';
        assertEquals(true, cGame.validateUserInput(validInput));
    }
}
