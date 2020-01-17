package leagues;

/**
 * Class Team
 * @author Patrick Niewold
 * @version 1.0
 */
public class Team {
    private String teamName;
    private Integer points = 0;
    private Integer plusGoals = 0;
    private Integer minGoals = 0;
    private Integer yellowCards = 0;
    private Integer redCards = 0;

    /**
     * Constructor for Team
     * @param teamName Name of team
     */
    public Team(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Returns team name
     * @return String
     */
    public String getTeamName() {
        return this.teamName;
    }

    /**
     * Returns points
     * @return
     */
    public Integer getPoints() {
        return points;
    }

    public void addPoints(Integer points) {
        this.points += points;
    }

    /**
     * Returns amount of goals made
     * @return int
     */
    public Integer getPlusGoals() {
        return this.plusGoals;
    }

    /**
     * Returns amount of goals taken
     * @return int
     */
    public Integer getMinGoals() {
        return this.minGoals;
    }

    /**
     * Returns amount of yellow cards
     * @return int
     */
    public Integer getYellowCards() {
        return this.yellowCards;
    }

    /**
     * Returns amount of red cards
     * @return int
     */
    public Integer getRedCards() {
        return this.redCards;
    }

    /**
     * Adds goals made
     * @param amount amount to add
     */
    public void addPlusGoals(Integer amount) {
        this.plusGoals += amount;
    }

    /**
     * Adds goals taken
     * @param amount amount to add
     */
    public void addMinGoals(Integer amount) {
        this.minGoals += amount;
    }

    /**
     * Adds yellow cards
     * @param amount amount to add
     */
    public void addYellowCards(Integer amount) {
        this.yellowCards += amount;
    }

    /**
     * Adds red cards
     * @param amount amount to add
     */
    public void addRedCards(Integer amount) {
        this.redCards += amount;
    }
}
