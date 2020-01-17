package leagues;

import cards.Card;
import interfaces.Winner;

import java.util.List;

/**
 * Class Match
 * @author Patrick Niewold
 * @version 1.0
 */
public class Match implements Winner {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private List<Card> cards;

    /**
     * Constructor for Match
     * @param homeTeam Home team
     * @param awayTeam Away team
     * @param homeScore Home score
     * @param awayScore Away score
     * @param cards card list
     */
    public Match(Team homeTeam, Team awayTeam, int homeScore, int awayScore, List<Card> cards) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.cards = cards;
    }

    /**
     * Returns home team
     * @return Team
     */
    public Team getHomeTeam() {
        return this.homeTeam;
    }

    /**
     * Returns away team
     * @return Team
     */
    public Team getAwayTeam() {
        return this.awayTeam;
    }

    /**
     * Returns home score
     * @return Integer
     */
    public int getHomeScore() {
        return this.homeScore;
    }

    /**
     * Returns away score
     * @return Integer
     */
    public int getAwayScore() {
        return this.awayScore;
    }

    /**
     * Returns list of cards
     * @return List<Card>
     */
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public Team getWinner() {
        if (getHomeScore() > getAwayScore()) {
            return getHomeTeam();
        } else if (getHomeScore() < getAwayScore()) {
            return getAwayTeam();
        } else {
            return null;
        }
    }
}
