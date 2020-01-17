package cards;

import leagues.Team;

/**
 * Yellow card
 * @author Patrick Niewold
 * @version 1.0
 */
public class YellowCard extends Card {
    /**
     * Constructor for YellowCard
     * @param team Team card belongs to
     */
    public YellowCard(Team team) {
        super(team);
    }

    @Override
    public String getType() {
        return "Yellow";
    }
}
