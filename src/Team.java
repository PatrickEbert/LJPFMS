/**
 * Created by pebert on 5/2/2017.
 */
// I M P O R T S

// C L A S S  D E F I N I T I O N
public class Team {
    // A T T R I B U T E S
    private String name;
    private int id;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private boolean champion;
    private boolean newby;

    // C O N S T R U C T O R S
    public Team()
    {
        this.name = "Unknown";
        this.id = -1;
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.champion = false;
        this.newby = false;
    }

    public Team(String name, int id)
    {
        this();
        this.name = name;
        this.id = id;
    }

    // S E T S  A N D  G E T S
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}
    public void setId(int id){this.id = id;}
    public int getId(){return this.id;}

    public int getPoints(){return this.points;}
    public int getGoalsFor(){return this.goalsFor;}
    public int getGoalsAgainst(){return this.goalsAgainst;}
    public int getGoalsDiff(){return this.getGoalsFor() - this.getGoalsAgainst();}
    public void setChampion(boolean champion){this.champion = champion;}
    public boolean getChampion(){return this.champion;}
    public void setNewby(boolean newby){this.newby = newby;}
    public boolean getNewby(){return this.newby;}

    // O V E R R I D E S
    @Override
    public String toString()
    {
        String retString = this.name;
        if(champion)
            retString += "(C)";
        if(newby)
            retString += "(N)";
        retString += "|" + this.points + "|" + this.goalsFor + "|" + this.goalsAgainst + "|" + this.getGoalsDiff();
        return retString;
    }

    // M E T H O D S
    public void win(int goalsFor, int goalsAgainst)
    {
        this.points += 3;
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }

    public void draw(int goals)
    {
        this.points++;
        this.goalsFor += goals;
        this.goalsAgainst += goals;
    }

    public void loose(int goalsFor, int goalsAgainst)
    {
        this.goalsFor += goalsFor;
        this.goalsAgainst += goalsAgainst;
    }

    public void clearSeason()
    {
        this.setChampion(false);
        this.setNewby(false);
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }

    // T E S T  M E T H O D S
}
