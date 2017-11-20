package be.eaict.afsprakenvanbeeck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        TextView afspraakreden = (TextView)findViewById(R.id.textView_afspraakReden);

        afspraakreden.setText(appointments.get(position2).getReason());
    }
}
