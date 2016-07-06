package bulldogcoders.coachbuddy;

/**
 * Created by Jonathan on 7/5/2016.
 */
public class Workouts {

    private String _name, _description;
    private int[] _time= new int[2];
    private boolean[] _dates= new boolean[7];

    public Workouts(String name, int[] time, boolean[] dates, String description){
        _name=name;
        _description=description;
        _time=time;
        _dates=dates.clone();
    }

    public String getname(){
        return _name;
    }
    public String getdescription(){
        return _description;
    }
    public int[] gettime(){
        return _time;
    }
    public boolean[] getdates(){
        return _dates;
    }
}
