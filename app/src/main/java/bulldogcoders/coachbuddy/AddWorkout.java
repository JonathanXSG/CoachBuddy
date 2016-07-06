package bulldogcoders.coachbuddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddWorkout extends AppCompatActivity {

    List<Workouts> workoutList = new ArrayList<Workouts>();
    ListView workoutListView;

    EditText workoutName, workoutDesc;
    Button addButton;
    TimePicker workoutTimePicker;
    int[] workoutTime= new int[2];
    boolean[] workoutDate= new boolean[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        workoutListView = (ListView) findViewById(R.id.listView);

        workoutName = (EditText) findViewById(R.id.workout_name);
        workoutDesc = (EditText) findViewById(R.id.workout_description);
        workoutTimePicker = (TimePicker) findViewById(R.id.workout_time_picker);
        addButton = (Button) findViewById(R.id.button_add);

        workoutName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                addButton.setEnabled(!workoutName.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void addButtonConfirmation(View view) {
        workoutTime[0] = workoutTimePicker.getCurrentHour();
        workoutTime[1] = workoutTimePicker.getCurrentMinute();
        Toast.makeText(getApplicationContext(),"Workout "+workoutDate[0]+workoutDate[1]+" has been added",Toast.LENGTH_SHORT).show();
        workoutList.add(new Workouts(workoutName.toString(),workoutTime,workoutDate, workoutDesc.toString()));
        //populateList();
        Intent openActivity = new Intent(view.getContext(),MainMenu.class);
        view.getContext().startActivity(openActivity);
    }

    public void buttonClick(View v) {
        switch(v.getId()) {
            case R.id.workout_sun:
                workoutDate[0] = !workoutDate[0];
                break;
            case R.id.workout_mon:
                workoutDate[1] = !workoutDate[1];
                break;
            case R.id.workout_tue:
                workoutDate[2] = !workoutDate[2];
                break;
            case R.id.workout_wed:
                workoutDate[3] = !workoutDate[3];
                break;
            case R.id.workout_thu:
                workoutDate[4] = !workoutDate[4];
                break;
            case R.id.workout_fri:
                workoutDate[5] = !workoutDate[5];
                break;
            case R.id.workout_sat:
                workoutDate[6] = !workoutDate[6];
                break;
        }
    }

    public void populateList() {
        ArrayAdapter<Workouts> adapter = new workoutListAdapter();
        workoutListView.setAdapter(adapter);
    }

    public class workoutListAdapter extends ArrayAdapter<Workouts>{
        public workoutListAdapter(){
            super(getApplicationContext(),R.layout.listview_item,workoutList);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if(view==null){
                view = getLayoutInflater().inflate(R.layout.listview_item, parent,false );
            }

            Workouts currentWorkout = workoutList.get(position);

            TextView name = (TextView) view.findViewById(R.id.view_workout_name);
            name.setText(currentWorkout.getname());

            return view;
        }
    }
}
