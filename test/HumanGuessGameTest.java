import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HumanGuessGameTest {

    int SECRET_NUMBER = 55;
    int SMALLER_GUESSING_NUMBER = 40;
    int BIGGER_GUESSING_NUMBER = 70;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    HumanGuessGame hgame = new HumanGuessGame();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void checkValidRangeTest(){
        int validNumber = 5;
        boolean result = hgame.checkValidRange(validNumber);
        assertEquals(true, result);
    }

    @Test
    public void checkInvalidRangeTest(){
        int invalidNumber = 120;
        boolean result = hgame.checkValidRange(invalidNumber);
        assertEquals(false, result);
    }

    @Test
    public void validateBiggerNumberTest(){
        String expectedMessage = "My number is bigger\n";
        hgame.validateNumber(SMALLER_GUESSING_NUMBER, SECRET_NUMBER);
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void validateSmallerNumberTest(){
        String expectedMessage = "My number is smaller\n";
        hgame.validateNumber(BIGGER_GUESSING_NUMBER, SECRET_NUMBER);
        assertEquals(expectedMessage, outContent.toString());
    }




}