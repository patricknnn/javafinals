package schedules;

import interfaces.Schedule;
import leagues.Match;
import java.text.MessageFormat;
import java.util.List;

/**
 * Class SingleSchedule
 * @author Patrick Niewold
 * @version 1.0
 */
public class SingleSchedule implements Schedule {
    private List<Match> matches;

    /**
     * Constructor for Single league
     */
    public SingleSchedule(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public String getSchedule() {
        String schedule = "Match schedule: \n";
        Integer counter = 1;
        for (Match match : matches) {
            String matches = MessageFormat.format("{0}. {1} vs {2}.\n",
                    counter, match.getHomeTeam().getTeamName(), match.getAwayTeam().getTeamName());
            schedule = schedule.concat(matches);
            counter++;
        }
        return schedule;
    }

    @Override
    public Integer getRounds() {
        return matches.size();
    }
}
