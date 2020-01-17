package leagues;

import interfaces.Schedule;
import schedules.DoubleSchedule;

import java.util.List;

/**
 * Double league
 * @author Patrick Niewold
 * @version 1.0
 */
public class DoubleLeague extends League {
    private DoubleSchedule doubleSchedule;
    private List<Match> matches;

    /**
     * Constructor for DoubleLeague
     * @param name League name
     */
    public DoubleLeague(String name) {
        super(name);
    }

    @Override
    public void generateSchedule() {
        this.doubleSchedule = new DoubleSchedule();
    }

    @Override
    public Schedule getSchedule() {
        return this.doubleSchedule;
    }

    @Override
    public Integer getAmountOfMatches() {
        return this.matches.size();
    }

    @Override
    public Team getWinner() {
        return null;
    }
}
