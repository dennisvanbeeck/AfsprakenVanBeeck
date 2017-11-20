package be.eaict.afsprakenvanbeeck;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Integer position2;
        final List<Appointment> appointments = new AppointmentDummyRepository().getAppointments();
        Bundle intentBundle= getIntent().getExtras();
        position2 = intentBundle.getInt("position");


        TextView naamdokter = (TextView)findViewById(R.id.textView_dokter);
        TextView datumentijd = (TextView)findViewById(R.id.textView_datum);
        TextView plaats = (TextView)findViewById(R.id.textView_plaats);
        TextView afspraakreden = (TextView)findViewById(R.id.textView_afspraakReden);


        naamdokter.setText(appointments.get(position2).getContactName());
        datumentijd.setText(String.format("%d/%d/%d %d:%d",
                appointments.get(position2).getDay(),
                appointments.get(position2).getMonth(),
                appointments.get(position2).getYear(),
                appointments.get(position2).getHour(),
                appointments.get(position2).getMinute()));
        plaats.setText(appointments.get(position2).getLocation());
        afspraakreden.setText(appointments.get(position2).getReason());


        Button buttonmap = (Button)findViewById(R.id.button_map);
        buttonmap.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String geoURI = "geo:37.422, -122.084?z=23";
                Uri geo = Uri.parse(geoURI);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, geo);
                if (mapIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(mapIntent);
                }
            }
        });
    }
}
