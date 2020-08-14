import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {


    @Test
    void checkStatus() {
        char[][] motions = new char[3][3];
        Assertions.assertFalse(Game.checkStatus(motions));

    }

    @Test
    void stepAndCheckWin_Success(){
        char[][] motions = new char[3][3];
            motions[0][0] = 1;
            motions[0][1] = motions[0][0];
            motions[0][2] = motions[0][1];
            Assertions.assertTrue(Game.stepAndCheckWin(motions, 1, 1, 'x'));
    }

    @Test
    void stepAndCheckWin_Unsuccessful(){
        char[][] motions = new char[3][3];
        Assertions.assertFalse(Game.stepAndCheckWin(motions, 1, 1, 'x'));
    }

    @Test
    void checkStatusError(){
        char[][] motions = new char[0][0];
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> Game.checkStatus(motions));
    }
}