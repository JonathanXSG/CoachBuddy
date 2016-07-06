package bulldogcoders.coachbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainMenu extends AppCompatActivity {

    List<Workouts> workoutsList = new ArrayList<Workouts>();
    ListView workoutListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);
        workoutListView = (ListView) findViewById(R.id.listView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void AddNewWorkout(View view){
        Intent openActivity = new Intent(view.getContext(),AddWorkout.class);
        view.getContext().startActivity(openActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    public void populateList() {
        ArrayAdapter<Workouts> adapter = new workoutListAdapter();
        workoutListView.setAdapter(adapter);
    }

    public class workoutListAdapter extends ArrayAdapter<Workouts>{
        public workoutListAdapter(){
            super(MainMenu.this,R.layout.listview_item,workoutsList);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if(view==null){
                view = getLayoutInflater().inflate(R.layout.listview_item, parent,false );
            }

            Workouts currentWorkout = workoutsList.get(position);

            TextView name = (TextView) view.findViewById(R.id.view_workout_name);
            name.setText(currentWorkout.getname());

            return view;
        }
    }
}
