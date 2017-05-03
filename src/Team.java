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

    // C O N S T R U C T O R S
    public Team()
    {
        this.name = "Unknown";
        this.id = -1;
        this.points = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
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

    // O V E R R I D E S
    @Override
    public String toString()
    {
        return this.name + "|" + this.points + "|" + this.goalsFor + "|" + this.goalsAgainst + "|" + this.getGoalsDiff();
    }

    // M E T H O D S
    // T E S T  M E T H O D S
}
