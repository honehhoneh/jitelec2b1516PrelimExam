package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioGroup radioChoice;
    private RadioButton radioChosen;
    private Button toggle;
    private TextView time;



    private long timeRemaining = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioChoice = (RadioGroup) findViewById(R.id.rgrp);
        toggle = (Button) findViewById(R.id.toggleBtn);
        time = (TextView) findViewById(R.id.txtTime);

        addListenerOnButton();


    }

    private void addListenerOnToggle() {

    }

    public void addListenerOnButton() {

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioChoice.getCheckedRadioButtonId();
                radioChosen = (RadioButton) findViewById(selectedId);

                String choice = radioChosen.getText().toString();

                if (choice.equals("Increment")) {

                    final Handler handler = new Handler();

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            timeRemaining += 100; //increment to seekbar value
                            time.setText(timeRemaining + "");

                        }
                    };

                    handler.postDelayed(runnable, 100);
                }


            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
