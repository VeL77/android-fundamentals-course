package org.hackafe.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Text;


public class DayForecast extends ActionBarActivity {

    private TextView displayDate;
    private TextView displayDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_forecast);
        Bundle dayForcastDataInfo = getIntent().getExtras();

        long timestamp = getIntent().getLongExtra("TIMESTAMP", 0);
        String timestampDisplay = SimpleDateFormat.getDateInstance().format(new Date(timestamp*1000));
        String desc = getIntent().getStringExtra("Desc");

        //Bundle dayForcastDataInfo = getIntent().getExtras();



        displayDate = (TextView) findViewById(R.id.textDate);
        displayDesc = (TextView) findViewById(R.id.textDesc);

        if(timestampDisplay==null){
            return;
        }
        else{
            displayDate.setText(timestampDisplay);
        }

        if(desc==null){
            return;
        }
        else{
            displayDesc.setText(desc);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day_forecast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
