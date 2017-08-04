package com.multishiv19.higherorlower;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private Random randomGenerator = new Random();
    private int specialNumber;

    public void highLow(View view) {

        EditText userGuess = (EditText) findViewById(R.id.userGuess);
        if(userGuess.getText().length() > 0) {
            Integer guess = Integer.parseInt(userGuess.getText().toString());
            if(guess > specialNumber)
                Toast.makeText(getApplicationContext(), "My number is lower than your guess!", Toast.LENGTH_LONG).show();
            else if(guess < specialNumber)
                Toast.makeText(getApplicationContext(), "My number is greater than your guess!", Toast.LENGTH_LONG).show();
            else {
                Toast.makeText(getApplicationContext(), "You guessed it right! The number was " + specialNumber, Toast.LENGTH_SHORT).show();
                specialNumber = randomGenerator.nextInt(21);
                Toast.makeText(getApplicationContext(), "I selected a new number ;)", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "You have to enter a number inorder to guess!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        specialNumber = randomGenerator.nextInt(21);
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
}
