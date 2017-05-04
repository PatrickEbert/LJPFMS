/**
 * Created by pe186000 on 04/05/2017.
 */
// I M P O R T S
import java.util.Random;

// C L A S S  D E F I N I T I O N
public class Match
{
    // A T T R I B U T E S
    private Team home;
    private Team away;
    private int minute;
    private int homeGoals;
    private int awayGoals;

    // CONSTRUCTORS
   public Match(Team home, Team away)
   {
       this.home = home;
       this.away = away;
       this.homeGoals = 0;
       this.awayGoals = 0;
       this.minute = 0;
   }

    // SETS AND GETS
    public int getMinute(){return this.minute;}

    // O V E R R I D E S
    @Override
    public String toString()
    {
        return home.getName() + " " + this.homeGoals + " : " + this.awayGoals + " " + this.away.getName();
    }

    // M E T H O D E S
    public void play()
    {
        this.homeGoals = new Random().nextInt(5);
        this.awayGoals = new Random().nextInt(5);
        this.minute = 90;
        if(homeGoals > awayGoals)
        {
            home.win(homeGoals,awayGoals);
            away.loose(awayGoals,homeGoals);
        }else if(homeGoals < awayGoals)
        {
            home.loose(homeGoals,awayGoals);
            away.win(awayGoals,homeGoals);
        }
        else
        {
            home.draw(homeGoals);
            away.draw(awayGoals);
        }
    }
}
