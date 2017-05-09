/**
 * Created by pebert on 5/2/2017.
 */
// I M P O R T S
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

// M A I N  C L A S S
public class Main {
    // M A I N  M E T H O D E
    public static void main(String [] args)
    {
        ArrayList<Team>teams;
        System.out.println("This is the beginning...");
        teams = loadTeams();
        League l = loadLeague(teams);
        while(true)
        {
            int status = l.proceedWeek();
            l.printTable();
            System.out.println("next week...");
            try {
                System.in.read();
            }catch(Exception ex){}
            if(status == League.END_OF_SEASON)
                teams = l.proceedEndOfSeason(teams);
        }
    }

    // M E T H O D E S

    // T E S T  M E T H O D E S
    public static ArrayList<Team> loadTeams()
    {
        ArrayList<Team> retTeams = new ArrayList<Team>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("data/_Teams.csv"));
            String line = null;
            while((line = br.readLine())!=null) {
                retTeams.add(new Team(line.split(";")[1], Integer.parseInt(line.split(";")[0])));
            }
            br.close();
        }catch(Exception ex)
        {
            Misc.log("Error at Main.loadTeams(): " + ex.getMessage());
        }
        return retTeams;
    }

    public static League loadLeague(ArrayList<Team> teams)
    {
        League retLeague = new League();
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/_Leagues.csv"));
            String line = br.readLine();
            ArrayList<Team>selectedTeams = new ArrayList<Team>();
            String[] teamIds = line.split(";")[2].split("/");
            for(int i = 0; i < teamIds.length; i++)
            {
                for (Team t : teams)
                {
                    if(Integer.parseInt(teamIds[i])==t.getId())
                    {
                        selectedTeams.add(t);
                        teams.remove(t);
                        break;
                    }

                }
            }
            retLeague = new League(line.split(";")[1],Integer.parseInt(line.split(";")[0]),Integer.parseInt(line.split(";")[3]),selectedTeams);
        }catch(Exception ex)
        {
            Misc.log("Error at Main.loadLeague(): " + ex.getMessage());
        }
        return retLeague;
    }
}
