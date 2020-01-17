package cards;

import leagues.Team;

/**
 * Class Card
 * @author Patrick Niewold
 * @version 1.0
 */
public abstract class Card {
    private Team team;

    /**
     * Constructor for Card
     * @param team Team card belongs to
     */
    Card(Team team) {
        this.team = team;
    }

    /**
     * Returns the team the card belongs to
     * @return
     */
    public Team getTeam() {
        return this.team;
    }

    /**
     * Returns the card type
     * @return String
     */
    public abstract String getType();
}
