package bulldogcoders.coachbuddy;

/**
 * Created by Jonathan on 7/5/2016.
 */
public class Workouts {

    private String name, description;
    private int[] time = new int[2];
    private boolean[] dates = new boolean[7];

    public Workouts(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
