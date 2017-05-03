/**
 * Created by pebert on 5/2/2017.
 */

// I M P O R T S
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

// C L A S S  D E F I N I T I O N
public class League {
    // A T T R I B U T E S
    private String name;
    private int id;
    private int week;
    private ArrayList<Team> teams;

    // C O N S T R U C T O R S
    public League()
    {
        // Empty
        this.name = "Unknown";
        this.id = -1;
        this.week = 0;
        teams = new ArrayList<Team>();
    }
    public League(String name, int id)
    {
        this();
        this.name = name;
        this.id = id;
    }

    // S E T S  A N D  G E T S
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}
    public void setId(int id){this.id = id;}
    public int getId(){return id;}

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

    // T E S T  M E T H O D S
}
