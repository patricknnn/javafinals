
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for main
 * @author Patrick Niewold
 * @version 1.0
 */
class MainTest {
    Main m = new Main();

    @org.junit.jupiter.api.Test
    void showSingleLeagueWinner() {
        m.initialize();
        assertEquals("Ajax", m.showSingleLeagueWinner());
    }

    @org.junit.jupiter.api.Test
    void getAjaxScore() {
        m.initialize();
        assertEquals(9, m.getAjaxScore());
    }

    @org.junit.jupiter.api.Test
    void getAdoGoalsPlus() {
        m.initialize();
        assertEquals(6, m.getAdoGoalsPlus());
    }

    @org.junit.jupiter.api.Test
    void getPsvGoalsMin() {
        m.initialize();
        assertEquals(7, m.getPsvGoalsMin());
    }

    @org.junit.jupiter.api.Test
    void getVvvDoelsaldo() {
        m.initialize();
        assertEquals(-5, m.getVvvDoelsaldo());
    }
}