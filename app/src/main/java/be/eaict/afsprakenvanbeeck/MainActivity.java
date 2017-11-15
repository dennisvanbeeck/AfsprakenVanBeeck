package be.eaict.afsprakenvanbeeck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Integer[] arr = new Integer[26];
        for (int i = 0; i < 10; i++) {
            Integer integer = arr[i];
        }


        ListView afspraakListView = (ListView) findViewById(R.id.listview_afspraak);
        afspraakListView.setAdapter(new AppointmentListAdapter(this, arr));
        afspraakListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("afspraak", arr[position]);
                startActivity(i);
            }
        });
    }
}



