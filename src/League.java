/**
 * Created by pebert on 5/2/2017.
 */
// IMPORTS

// CLASS DEFINITION
public class League {
    // ATTRIBUTES
    private String name;

    // CONSTRUCTORS
    public League()
    {
        // Empty
    }
    public League(String name)
    {
        this();
        this.name = name;
    }

    // SETS AND GETS
    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    // OVERRIDES
    @Override
    public String toString()
    {
        return this.name;
    }

    // METHODES
    // TEST METHODS
}
