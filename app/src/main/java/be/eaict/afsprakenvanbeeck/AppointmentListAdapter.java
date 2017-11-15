package be.eaict.afsprakenvanbeeck;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dennisvanbeeck on 15/11/2017.
 */

public class AppointmentListAdapter extends ArrayAdapter<Appointment> {


    //Constructor

    public AppointmentListAdapter(Context context, List<Appointment> appointments) {
        super(context, -1, appointments);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_product_list, null);
        TextView afspraaktijd = (TextView)v.findViewById(R.id.afspraak_tijd);
        TextView afspraakdokter = (TextView)v.findViewById(R.id.afspraak_dokter);
        TextView afspraakplaats = (TextView)v.findViewById(R.id.afspraak_plaats);

        afspraakdokter.setText(getItem(position).getContactName());
        afspraaktijd.setText(Integer.toString(getItem(position).getHour()));
        afspraakplaats.setText(getItem(position).getLocation());



        return v;
    }
}
