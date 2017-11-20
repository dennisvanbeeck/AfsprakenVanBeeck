package be.eaict.afsprakenvanbeeck;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView afspraakListView = (ListView) findViewById(R.id.listview_afspraak);
        List<Appointment> appointments = (new AppointmentDummyRepository()).getAppointments();
        afspraakListView.setAdapter(new AppointmentListAdapter(this,appointments));

        afspraakListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Bundle b = new Bundle();
                b.putInt("position", position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}



