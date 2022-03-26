package models;

import java.util.HashMap;
import java.util.Random;

public class Game {

    private HashMap<Team, Integer> scoreboard;
    private static int gameCount;
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;

    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<Team, Integer>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public static int getQuafflePoints() {
        return QUAFFLE_POINTS;
    }

    public static int getSnitchPoints() {
        return SNITCH_POINTS;
    }

    public Integer getScore(Team team) {
        return this.scoreboard.get(team);
    }

    public void setScore(Team team, Integer score) {
        scoreboard.put(team, score);
    }

    public Team getTeam(String name) {
      return this.scoreboard.keySet().stream()
        .filter((key) -> key.getHouse().equals(name))
        .findFirst()
        .orElse(null);
    }

    public static int getGameCount() {
        return gameCount;
    }

    /**
     * Function name: getPlaceholder
     * @param play (String)
     * @return (String)
     * 
     * Inside the function:
     *  1. Returns a substring between two < > characters.
     */
    public String getPlaceholder(String play) {
        return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
    }

     /** 
     * Function name: replacePlaceholder
     * @param play
     * @param placeholder
     * @param value
     * @return (String)
     * 
     * Inside the function:
     *  1. Replaces the placeholder in a play with a value
     */
    public String replacePlaceholder(String play, String placeholder, String value) {
        return play.replace("<" + placeholder + ">", value);
    }

     /**
     * Function name: quaffleScore
     * @param team
     * 
     * Inside the function:
     *  1. Update the team's points by `QUAFFLE_POINTS`. <---
     */
    public void quaffleScore(Team team) {
        this.setScore(team, this.getScore(team) + QUAFFLE_POINTS);
    }

     /**
     * Function name: catchSnitch
     * @param team
     * 
     * Inside the function:
     *  1. Update the team's points by `SNITCH_POINTS`. <---
     */
    public void catchSnitch(Team team) {
        this.setScore(team, this.getScore(team) + SNITCH_POINTS);
    }

    /**
     * Function name: random
     * @param range
     * @return int
     * 
     * Inside the function:
     *  1. Returns a number between 0 and one less the range
    */
    public int random(int range) {
        return new Random().nextInt(range);
    }

    /**
     * Function name: getRandomTeam()
     * @return (Team)
     * 
     *  1. converts scoreBoard to keySet.
     *  2. converts keyset to array (easier to index).
     *  3. returns a random team from the array of teams. 
     */
    public Team getRandomTeam() {
        return (Team) scoreboard.keySet().toArray()[random(scoreboard.size())];
    }

    public String simulate(String play) {
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();
        String value = "";

        if (Team.getPositionChaser().equals(placeholder)) {
            quaffleScore(team);
            value = team.getChasers()[random(team.getChasers().length)];
        } else if (Team.getPositionSeeker().equals(placeholder)) {
            catchSnitch(team);
            value = team.getSeeker();
        } else if (Team.getPositionKeeper().equals(placeholder)) {
            value = team.getKeeper();
        }

        return replacePlaceholder(play, placeholder, value);
    }
}
