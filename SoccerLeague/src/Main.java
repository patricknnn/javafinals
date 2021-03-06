import cards.*;
import leagues.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Main application class
 * @author Patrick Niewold
 * @version 1.0
 */
public class Main {
    private League singleLeague;
    //private League doubleLeague;

    /**
     * Constructor
     */
    public Main() {
        createTestData();
    }

    public void createTestData() {
        // Create leagues
        this.singleLeague = new SingleLeague("Europa League");
        //this.doubleLeague = new DoubleLeague("Champions League");

        // Create teams
        Team ajax = new Team("Ajax");
        Team ado = new Team("ADO");
        Team psv = new Team("PSV");
        Team vvv = new Team("VVV");

        // Add teams to league
        try {
            singleLeague.addTeam(ajax);
            singleLeague.addTeam(ado);
            singleLeague.addTeam(psv);
            singleLeague.addTeam(vvv);
        } catch (NullPointerException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }

        // Create cards for teams
        YellowCard yc_ajax = new YellowCard(ajax);
        RedCard rc_ajax = new RedCard(ajax);
        YellowCard yc_ado = new YellowCard(ado);
        RedCard rc_ado = new RedCard(ado);
        YellowCard yc_psv = new YellowCard(psv);
        RedCard rc_psv = new RedCard(psv);
        YellowCard yc_vvv = new YellowCard(vvv);
        RedCard rc_vvv = new RedCard(vvv);

        // Create card lists
        List<Card> ajax_ado = new LinkedList<>();
        List<Card> ajax_psv = new LinkedList<>();
        List<Card> ajax_vvv = new LinkedList<>();
        List<Card> ado_psv = new LinkedList<>();
        List<Card> ado_vvv = new LinkedList<>();
        List<Card> psv_vvv = new LinkedList<>();

        // Add cards to correct list, then add matches to leagues
        try {
            ajax_ado.add(yc_ajax);
            ajax_ado.add(yc_ado);
            singleLeague.addMatch(new Match(ajax, ado, 2, 1, ajax_ado));
            ajax_psv.add(yc_ajax);
            ajax_psv.add(yc_psv);
            ajax_psv.add(rc_psv);
            singleLeague.addMatch(new Match(ajax, psv, 3, 2, ajax_psv));
            ajax_vvv.add(yc_vvv);
            ajax_vvv.add(yc_vvv);
            singleLeague.addMatch(new Match(ajax, vvv, 2, 0, ajax_vvv));
            ado_psv.add(rc_ado);
            ado_psv.add(yc_psv);
            ado_psv.add(yc_psv);
            singleLeague.addMatch(new Match(ado, psv, 2, 2, ado_psv));
            ado_vvv.add(rc_ado);
            ado_vvv.add(rc_ado);
            ado_vvv.add(yc_vvv);
            ado_vvv.add(yc_vvv);
            singleLeague.addMatch(new Match(ado, vvv, 3, 1, ado_vvv));
            psv_vvv.add(yc_psv);
            psv_vvv.add(yc_psv);
            singleLeague.addMatch(new Match(psv, vvv, 3, 2, psv_vvv));
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }

    /**
     * Initializes the test data
     */
    public void initialize() {
        try {
            singleLeague.generateSchedule();
            singleLeague.processMatches();
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }

    /**
     * Returns the league winner
     * @return String
     */
    public String showSingleLeagueWinner() {
        return singleLeague.getWinner().getTeamName();
    }

    /**
     * Returns the league results
     * @return String
     */
    public String showSingleLeagueResults() {
        return singleLeague.getResultTable().getResults();
    }

    /**
     * Returns Ajax's score
     * @return Integer
     */
    public Integer getAjaxScore() {
        Integer points = 0;
        try {
            for (Team t : singleLeague.getTeams()) {
                if (t.getTeamName().equals("Ajax")){
                    points = t.getPoints();
                }
            }
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
        return points;
    }

    /**
     * Returns Ado's plus goals
     * @return Integer
     */
    public Integer getAdoGoalsPlus() {
        Integer goals = 0;
        try {
            for (Team t : singleLeague.getTeams()) {
                if (t.getTeamName().equals("ADO")){
                    goals = t.getPlusGoals();
                }
            }
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
        return goals;
    }

    /**
     * Returns PSV's min goals
     * @return Integer
     */
    public Integer getPsvGoalsMin() {
        Integer goals = 0;
        try {
            for (Team t : singleLeague.getTeams()) {
                if (t.getTeamName().equals("PSV")){
                    goals = t.getMinGoals();
                }
            }
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
        return goals;
    }

    /**
     * Returns VVV's doelsaldo
     * @return Integer
     */
    public Integer getVvvDoelsaldo() {
        Integer saldo = 0;
        try {
            for (Team t : singleLeague.getTeams()) {
                if (t.getTeamName().equals("VVV")){
                    saldo = t.getPlusGoals() - t.getMinGoals();
                }
            }
        } catch (Exception e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
        return saldo;
    }
}
