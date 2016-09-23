package sample;

/**
 * Created by Deviltech on 23.09.2016.
 */
public class Faction {

    private int teamID;
    private String name;

    public Faction(int teamID){
        // check for overflow
        this.teamID = teamID % MyValues.NUMBER_OF_FACTIONS;
        this.name = MyValues.FACTION_NAMES[this.teamID];
    }

    public int getTeamID(){
        return teamID;
    }

    public String getName(){
        return name;
    }
}
