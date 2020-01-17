package leagues;

import java.util.Comparator;
import java.util.List;

/**
 * Class ResultTable
 * @author Patrick Niewold
 * @version 1.0
 */
public class ResultTable {
    private List<Team> teams;
    // Create comparator to compare by points
    Comparator<Team> compareByPoints = new Comparator<Team>() {
        @Override
        public int compare(Team t1, Team t2) {
            return t2.getPoints().compareTo(t1.getPoints());
        }
    };
    // Create comparator to compare by goals
    Comparator<Team> compareByGoals = new Comparator<Team>() {
        @Override
        public int compare(Team t1, Team t2) {
            Integer d1 = t1.getPlusGoals() - t1.getMinGoals();
            Integer d2 = t2.getPlusGoals() - t2.getMinGoals();
            return d2.compareTo(d1);
        }
    };

    /**
     * Constructor for resultTable
     * @param teams team list
     */
    public ResultTable(List<Team> teams) {
        this.teams = teams;
    }

    /**
     * Returns results in formatted string
     * @return String
     */
    public String getResults() {
        teams.sort(compareByPoints.thenComparing(compareByGoals));

        String result = "Team | Punten | DoelSaldo | Gele kaarten | Rode kaarten\n";
        for (Team t : teams) {
            int doelsaldo = (t.getPlusGoals() - t.getMinGoals());
            String row = String.format(
                    "%s  %8d  %15d  %20d  %20d\n",
                    t.getTeamName(),
                    t.getPoints(),
                    doelsaldo,
                    t.getYellowCards(),
                    t.getRedCards()
            );
            result = result.concat(row);
        }
        return result;
    }
}
