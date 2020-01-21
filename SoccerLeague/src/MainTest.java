
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for main
 * @author Patrick Niewold
 * @version 1.0
 */
class MainTest {
    private Main m;

    @BeforeEach
    void BeforeAll() {
        this.m = new Main();
        m.initialize();
    }

    @Test
    void showSingleLeagueWinner() {
        assertEquals("Ajax", m.showSingleLeagueWinner());
    }

    @Test
    void getAjaxScore() {
        assertEquals(9, m.getAjaxScore());
    }

    @Test
    void getAdoGoalsPlus() {
        assertEquals(6, m.getAdoGoalsPlus());
    }

    @Test
    void getPsvGoalsMin() {
        assertEquals(7, m.getPsvGoalsMin());
    }

    @Test
    void getVvvDoelsaldo() {
        assertEquals(-5, m.getVvvDoelsaldo());
    }
}