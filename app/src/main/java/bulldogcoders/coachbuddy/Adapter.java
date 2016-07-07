package bulldogcoders.coachbuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Adapter extends ArrayAdapter{

    String[] name;
    Context c;
    LayoutInflater inflater;

    public Adapter(Context context, String[] name) {
        super(context, R.layout.listview_item);

        this.name=name;
        this.c=context;
    }

    public class viewHolder{
        TextView view_workout_name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.listview_item,null);
        }

        final viewHolder holder = new viewHolder();
        holder.view_workout_name= (TextView) convertView.findViewById(R.id.view_workout_name);
        holder.view_workout_name.setText(name[position]);

        return convertView;
    }
}
