package leagues;

import cards.Card;
import interfaces.Schedule;
import interfaces.Winner;

import java.util.LinkedList;
import java.util.List;

/**
 * Class League
 * @author Patrick Niewold
 * @version 1.0
 */
public abstract class League implements Winner {
    /**
     * Static points declarations
     */
    private static final int winPoints = 3;
    private static final int drawPoints = 1;
    private static final int lossPoints = 0;

    private String name;
    public List<Team> teams;
    public ResultTable results;
    public List<Match> matches;

    /**
     * Constructor for League
     * @param name League name
     */
    League(String name) {
        this.name = name;
        this.teams = new LinkedList<>();
        this.matches = new LinkedList<>();
    }

    /**
     * Returns points for a win
     * @return int
     */
    public static int getWinPoints() {
        return winPoints;
    }

    /**
     * Returns points for a draw
     * @return int
     */
    public static int getDrawPoints() {
        return drawPoints;
    }

    /**
     * Returns points for loss
     * @return int
     */
    public static int getLossPoints() {
        return lossPoints;
    }

    /**
     * Returns the name of the league
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a list of teams
     * @return List<Team>
     */
    public List<Team> getTeams() {
        return this.teams;
    }

    /**
     * Returns table of results
     * @return ResultTable
     */
    public ResultTable getResultTable() {
        results = new ResultTable(teams);
        return this.results;
    }

    /**
     * Add team to list
     * @param team Team to add
     */
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    /**
     * Add match to list
     * @param match Team to add
     */
    public void addMatch(Match match) {
        this.matches.add(match);
    }

    /**
     * Returns a list of matches
     * @return List<Match>
     */
    public List<Match> getMatches() {
        return this.matches;
    }

    /**
     * Processes matches in list and adds points to teams
     */
    public void processMatches() {
        // Loop over matches
        for (Match m : this.matches) {
            // Process points
            if (m.getWinner() == null) {
                m.getHomeTeam().addPoints(getDrawPoints());
                m.getAwayTeam().addPoints(getDrawPoints());
            } else {
                m.getWinner().addPoints(getWinPoints());
            }
            // Process goals
            m.getHomeTeam().addPlusGoals(m.getHomeScore());
            m.getHomeTeam().addMinGoals(m.getAwayScore());
            m.getAwayTeam().addPlusGoals(m.getAwayScore());
            m.getAwayTeam().addMinGoals(m.getHomeScore());

            // Process cards
            for (Card c : m.getCards()) {
                switch (c.getType()) {
                    case "Red":
                        c.getTeam().addRedCards(1);
                    case "Yellow":
                        c.getTeam().addYellowCards(1);
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Generates a schedule
     */
    public abstract void generateSchedule();

    /**
     * Returns the generated schedule
     */
    public abstract Schedule getSchedule();

    /**
     * Returns amount of rounds to be played
     * @return Integer
     */
    public abstract Integer getAmountOfMatches();
}
