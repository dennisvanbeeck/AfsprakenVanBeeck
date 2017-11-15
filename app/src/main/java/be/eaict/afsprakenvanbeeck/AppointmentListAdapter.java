package be.eaict.afsprakenvanbeeck;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dennisvanbeeck on 15/11/2017.
 */

public class AppointmentListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Appointment> Appointment;


    //Constructor

    public AppointmentListAdapter(Context mContext, List<Appointment> Appointment) {
        this.mContext = mContext;
        this.Appointment = Appointment;
    }

    @Override
    public int getCount() {
        return Appointment.size();
    }

    @Override
    public Object getItem(int position) {
        return Appointment.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.item_product_list, null);
        TextView afspraaktijd = (TextView)v.findViewById(R.id.afspraak_tijd);
        TextView afspraakdokter = (TextView)v.findViewById(R.id.afspraak_dokter);
        TextView afspraakplaats = (TextView)v.findViewById(R.id.afspraak_plaats);

        afspraakdokter.setText(Appointment.get(position).getContactName());
        afspraaktijd.setText((int) Appointment.get(position).getTime());
        afspraakplaats.setText(Appointment.get(position).getLocation());

        v.setTag(Appointment.get(position).getId());

        return v;
    }
}
