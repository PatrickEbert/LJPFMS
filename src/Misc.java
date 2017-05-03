import java.sql.Timestamp;

/**
 * Created by pe186000 on 03/05/2017.
 *
 * combines a number of helper functions like logging...
 */
// I M P O R T S

// C L A S S  D E F I N I T I O N
public class Misc {
    public static void log(String logText)
    {
        System.out.println(new Timestamp(System.currentTimeMillis()) + ">>" + logText);
    }
}
