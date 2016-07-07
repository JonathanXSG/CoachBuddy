package bulldogcoders.coachbuddy;

import android.content.Context;
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

    private List<Workouts> myWorkouts = new ArrayList<Workouts>(){
        
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);



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

        populateWorkoutList();
        populateListView();
    }

    private void populateWorkoutList() {
        myWorkouts.add(new Workouts("First"));
        myWorkouts.add(new Workouts("Second"));
        myWorkouts.add(new Workouts("Third"));
    }

    private void populateListView() {
        ArrayAdapter<Workouts> adapter = new MyLIstAdapter();
        ListView list = (ListView) findViewById(R.id.listview_mainmenu);
        list.setAdapter(adapter);
    }

    private class MyLIstAdapter extends ArrayAdapter<Workouts>{
        public MyLIstAdapter() {
            super(MainMenu.this, R.layout.listview_item,myWorkouts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if(itemView==null){
                itemView = getLayoutInflater().inflate(R.layout.listview_item, parent,false );
            }

            Workouts currentWorkout = myWorkouts.get(position);

            TextView name = (TextView) itemView.findViewById(R.id.view_workout_name);
            name.setText(""+currentWorkout.getName());

            return itemView;
        }
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

}
