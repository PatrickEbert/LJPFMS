/**
 * Created by pe186000 on 03/05/2017.
 */
// I M P O R T S
import java.util.Comparator;

// C L A S S  D E F I N I T I O N
public class TeamTableComparator implements Comparator<Team>
{
    @Override
    public int compare(Team t1, Team t2)
    {
        if((t2.getPoints()-t1.getPoints())!=0)
            return t2.getPoints()-t1.getPoints();

        if((t2.getGoalsDiff()-t1.getGoalsDiff())!=0)
            return t2.getGoalsDiff()-t1.getGoalsDiff();

        return t2.getGoalsFor()-t1.getGoalsFor();
    }
}
