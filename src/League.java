/**
 * Created by pebert on 5/2/2017.
 */

// I M P O R T S
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

// C L A S S  D E F I N I T I O N
public class League {
    // A T T R I B U T E S
    private String name;
    private int id;
    private int week;
    private int numOfTeams;
    private ArrayList<Team> teams;
    private Match[][]schedule;

    // C O N S T R U C T O R S
    public League()
    {
        // Empty
        this.name = "Unknown";
        this.id = -1;
        this.week = 0;
        this.numOfTeams = 18;
        teams = new ArrayList<Team>();
    }
    public League(String name, int id, int numOfTeams, ArrayList<Team>teams)
    {
        this();
        this.name = name;
        this.id = id;
        this.numOfTeams = numOfTeams;
        this.teams = teams;
        createSchedule();
    }

    // S E T S  A N D  G E T S  A N D  A D D S
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}
    public void setId(int id){this.id = id;}
    public int getId(){return id;}
    public void addTeam(Team team){teams.add(team);}
    public ArrayList<Team> getTeams(){return teams;}
    public Team getTeam(int id){for(Team t : teams){if(t.getId()==id){return t;}}return null;}

    // O V E R R I D E S
    @Override
    public String toString()
    {
        return this.name;
    }

    // M E T H O D E S
    public String toJSON()
    {
        return new GsonBuilder().create().toJson(this);
    }

    public void createSchedule()
    {
        // if it is not week zero, don't create a schedule
        if(this.week !=0)
            return;

        // LoadLines
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("data/_Schedule" + this.numOfTeams + ".csv"));
            String line = "";
            boolean firstLine = true;
            while((line=br.readLine())!=null)
            {
                if(firstLine)
                {
                    this.schedule = new Match[Integer.parseInt(line.split(";")[3])][Integer.parseInt(line.split(";")[4])];
                    firstLine = false;
                }
                schedule[Integer.parseInt(line.split(";")[0])-1][Integer.parseInt(line.split(";")[1])-1] = new Match(getTeam(Integer.parseInt(line.split(";")[2].split("-")[0])),getTeam(Integer.parseInt(line.split(";")[2].split("-")[1])));
            }
        }catch(Exception ex)
        {
            Misc.log("Error in League.createSchedule(): " + ex.getLocalizedMessage());
        }
    }

    public void proceedWeek()
    {
        if(week >= schedule.length)
            return;

        for(int i = 0; i < schedule[week].length;i++)
            schedule[week][i].play();

        week++;
        teams.sort(new TeamTableComparator());
    }

    public void printTable()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-------------------------------------------------------");
        System.out.println(this.name);
        System.out.println(this.week + ". Matchday");
        int p = 0;
        for(Team t : teams)
        {
            p++;
            System.out.println(p + " " + t);
        }
        System.out.println("-------------------------------------------------------");
    }
    // T E S T  M E T H O D S
}
