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
        if((t1.getPoints()-t2.getPoints())!=0)
            return t1.getPoints()-t2.getPoints();

        if((t1.getGoalsDiff()-t2.getGoalsDiff())!=0)
            return t1.getGoalsDiff()-t2.getGoalsDiff();

        return t1.getGoalsFor()-t2.getGoalsFor();
    }
}
