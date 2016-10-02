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

    /**
     * get relative path based on teamID
     * @return
     */
    public String getPath(){
        String factionNumber = Integer.toString(teamID);
        String imagePath = MyValues.PATH_FACTION + factionNumber + "/";
        return imagePath;
    }

    public boolean isSameFaction(Faction f2){
        return teamID == f2.getTeamID();
    }
}
