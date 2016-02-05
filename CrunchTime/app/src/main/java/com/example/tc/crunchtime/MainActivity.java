package com.example.tc.crunchtime;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageButton CaloriesButton = (ImageButton) findViewById(R.id.CaloriesButton);
        CaloriesButton.setOnClickListener(this);
        ImageButton PushUpsButton = (ImageButton) findViewById(R.id.PushUpsButton);
        PushUpsButton.setOnClickListener(this);
        ImageButton SitUpsButton = (ImageButton) findViewById(R.id.SitUpsButton);
        SitUpsButton.setOnClickListener(this);
        ImageButton JoggingButton = (ImageButton) findViewById(R.id.JoggingButton);
        JoggingButton.setOnClickListener(this);
        ImageButton JumpingJackButton = (ImageButton) findViewById(R.id.JumpingJacksButton);
        JumpingJackButton.setOnClickListener(this);
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

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.CaloriesButton: {
                EditText caltext = (EditText) findViewById(R.id.Calories);
                int cals = Integer.parseInt(caltext.getText().toString());
                EditText pushtext = (EditText) findViewById(R.id.PushUps);
                pushtext.setText(Integer.toString(Cal2push(cals)));
                EditText sittext = (EditText) findViewById(R.id.SitUps);
                sittext.setText(Integer.toString(Cal2sit(cals)));
                EditText jogtext = (EditText) findViewById(R.id.Jogging);
                jogtext.setText(Integer.toString(Cal2jog(cals)));
                EditText jacktext = (EditText) findViewById(R.id.JumpingJacks);
                jacktext.setText(Integer.toString(Cal2jack(cals)));
                break;
            }

            case R.id.PushUpsButton: {
                EditText pushtext = (EditText) findViewById(R.id.PushUps);
                int reps = Integer.parseInt(pushtext.getText().toString());
                int cals = push2Cal(reps);
                EditText calstext = (EditText) findViewById(R.id.Calories);
                calstext.setText(Integer.toString(cals));
                EditText sittext = (EditText) findViewById(R.id.SitUps);
                sittext.setText(Integer.toString(Cal2sit(cals)));
                EditText jogtext = (EditText) findViewById(R.id.Jogging);
                jogtext.setText(Integer.toString(Cal2jog(cals)));
                EditText jacktext = (EditText) findViewById(R.id.JumpingJacks);
                jacktext.setText(Integer.toString(Cal2jack(cals)));
                break;
            }

            case R.id.SitUpsButton: {
                EditText sittext = (EditText) findViewById(R.id.SitUps);
                int reps = Integer.parseInt(sittext.getText().toString());
                int cals = sit2Cal(reps);
                EditText calstext = (EditText) findViewById(R.id.Calories);
                calstext.setText(Integer.toString(cals));
                EditText pushtext = (EditText) findViewById(R.id.PushUps);
                pushtext.setText(Integer.toString(Cal2push(cals)));;
                EditText jogtext = (EditText) findViewById(R.id.Jogging);
                jogtext.setText(Integer.toString(Cal2jog(cals)));
                EditText jacktext = (EditText) findViewById(R.id.JumpingJacks);
                jacktext.setText(Integer.toString(Cal2jack(cals)));
                break;
            }

            case R.id.JoggingButton: {
                EditText jogtext = (EditText) findViewById(R.id.Jogging);
                int mins = Integer.parseInt(jogtext.getText().toString());
                int cals = jog2Cal(mins);
                EditText calstext = (EditText) findViewById(R.id.Calories);
                calstext.setText(Integer.toString(cals));
                EditText pushtext = (EditText) findViewById(R.id.PushUps);
                pushtext.setText(Integer.toString(Cal2push(cals)));
                EditText sittext = (EditText) findViewById(R.id.SitUps);
                sittext.setText(Integer.toString(Cal2sit(cals)));
                EditText jacktext = (EditText) findViewById(R.id.JumpingJacks);
                jacktext.setText(Integer.toString(Cal2jack(cals)));
                break;
            }

            case R.id.JumpingJacksButton: {
                EditText jacktext = (EditText) findViewById(R.id.JumpingJacks);
                int mins = Integer.parseInt(jacktext.getText().toString());
                int cals = jack2Cal(mins);
                EditText calstext = (EditText) findViewById(R.id.Calories);
                calstext.setText(Integer.toString(cals));
                EditText pushtext = (EditText) findViewById(R.id.PushUps);
                pushtext.setText(Integer.toString(Cal2push(cals)));
                EditText sittext = (EditText) findViewById(R.id.SitUps);
                sittext.setText(Integer.toString(Cal2sit(cals)));
                EditText jogtext = (EditText) findViewById(R.id.Jogging);
                jogtext.setText(Integer.toString(Cal2jog(cals)));
                break;
            }
        }
    }
    private int push2Cal(int reps) {
        return (int) ((float) 100/350 *  reps);
    }

    private int sit2Cal(int reps) {
        return (int) ((float) 100/200 * reps);
    }

    private int jog2Cal(int mins) {
        return (int) ((float) 100/12 * mins);
    }

    private int jack2Cal(int mins) {
        return (int) ((float) 100/10 * mins);
    }

    private int Cal2push(int Cals) {
        return (int) ((float) 350/100 * Cals);
    }

    private int Cal2sit(int Cals) {
        return (int) ((float) 200/100 * Cals);
    }

    private int Cal2jog(int Cals) {
        return (int) ((float) 12/100 * Cals);
    }

    private int Cal2jack(int Cals) {
        return (int) ((float) 10/100 * Cals);
    }
}
