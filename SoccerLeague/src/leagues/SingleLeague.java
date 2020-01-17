package leagues;

import interfaces.Schedule;
import schedules.SingleSchedule;

/**
 * Single league
 * @author Patrick Niewold
 * @version 1.0
 */
public class SingleLeague extends League {
    private SingleSchedule singleSchedule;

    /**
     * Constructor for SingleLeague
     * @param name League name
     */
    public SingleLeague(String name) {
        super(name);
    }

    @Override
    public void generateSchedule() {
        this.singleSchedule = new SingleSchedule(this.matches);
    }

    @Override
    public Schedule getSchedule() {
        return this.singleSchedule;
    }

    @Override
    public Integer getAmountOfMatches() {
        return this.matches.size();
    }

    @Override
    public Team getWinner() {
        // determine winner
        Integer highest = 0;
        Team winner = null;
        for (Team t : getTeams()) {
            if (t.getPoints() > highest) {
                highest = t.getPoints();
                winner = t;
            } else if (t.getPoints().equals(highest)) {
                try {
                    assert winner != null;
                    int ds_t = t.getPlusGoals() - t.getMinGoals();
                    int ds_w = winner.getPlusGoals() - winner.getMinGoals();
                    if (ds_t > ds_w) {
                        highest = t.getPoints();
                        winner = t;
                    }
                } catch (NullPointerException e) {
                    System.err.println("Caught NullPointerException: " + e.getMessage());
                }
            }
        }
        return winner;
    }
}
