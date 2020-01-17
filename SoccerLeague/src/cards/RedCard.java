package cards;

import leagues.Team;

/**
 * Red Card
 * @author Patrick Niewold
 * @version 1.0
 */
public class RedCard extends Card {
    /**
     * Constructor for Red Card
     * @param team Team card belongs to
     */
    public RedCard(Team team) {
        super(team);
    }

    @Override
    public String getType() {
        return "Red";
    }
}
