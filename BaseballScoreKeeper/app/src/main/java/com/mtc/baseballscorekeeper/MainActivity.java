package com.mtc.baseballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int homePoint = 0;
    int visitingPoint = 0;
    int ballsCounter = 0;
    int strikeCounter = 0;
    int outsCounter = 0;
    double inningCounter = 1;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This adds one point to the home team

    public void addHomePoint(View view) {
        homePoint = homePoint + 1;
        displayHome(homePoint);
    }

    private void displayHome(int number) {
        TextView homePointTextView = (TextView) findViewById(R.id.home_point_text_view);
        homePointTextView.setText("" + number);
    }

    //This adds one point to the visiting team

    public void addVisitorPoint(View view) {
        visitingPoint = visitingPoint + 1;
        displayVisit(visitingPoint);
    }

    private void displayVisit(int number) {
        TextView visitPointTextView = (TextView) findViewById(R.id.visit_point_text_view);
        visitPointTextView.setText("" + number);
    }

    //This adds one ball to the balls counter. Sets balls and strikes to 0 after 4 balls.

    public void addBall(View view) {

        ballsCounter = ballsCounter + 1;

        if (ballsCounter < 4) {
            displayBalls(ballsCounter);

        } else {
            ballsCounter = 0;
            displayBalls(ballsCounter);
            strikeCounter = 0;
            displayStrikes(strikeCounter);
        }
    }

    private void displayBalls(int number) {
        TextView ballsCounterTextView = (TextView) findViewById(R.id.balls_counter);
        ballsCounterTextView.setText("" + number);

    }

    //This adds one strike to the strikes counter. sets this and balls to 0 after 3 strikes.
    //Also adds one out.

    public void addStrike(View view) {
        strikeCounter = strikeCounter + 1;

        if (strikeCounter < 3) {
            displayStrikes(strikeCounter);
        } else {
            strikeCounter = 0;
            displayStrikes(strikeCounter);
            ballsCounter = 0;
            displayBalls(ballsCounter);
            outsCounter = outsCounter + 1;
            if (outsCounter < 3) {
                displayOuts(outsCounter);
            } else {
                outsCounter = 0;
                displayOuts(outsCounter);
                inningCounter = inningCounter + 0.5;
                displayInning(inningCounter);
            }
        }
    }

    private void displayStrikes(int number) {
        TextView strikesCounterTextView = (TextView) findViewById(R.id.strikes_counter);
        strikesCounterTextView.setText("" + number);
    }


    //Counts the outs up to 3. Checks to see if less than 3.
    //If false, adds half an inning to the inning counter and resets outs to 0.

    public void addOuts(View view) {
        outsCounter = outsCounter + 1;

        if (outsCounter < 3) {
            displayOuts(outsCounter);
        } else {
            outsCounter = 0;
            displayOuts(outsCounter);
            inningCounter = inningCounter + 0.5;
            displayInning(inningCounter);
        }
    }

    private void displayOuts(int number) {
        TextView outsCounterTextView = (TextView) findViewById(R.id.outs_counter);
        outsCounterTextView.setText("" + number);
    }

    //Displays inning count.

    private void displayInning(double number) {
        TextView inningCounterTextView = (TextView) findViewById(R.id.inning_counter);
        inningCounterTextView.setText("" + number);
    }

    // Hit button resets the balls and strikes counters

    public void hitReset (View view){
        strikeCounter = 0;
        displayStrikes(strikeCounter);
        ballsCounter = 0;
        displayBalls(ballsCounter);
    }

    //Resets all game data

    public void endOfGameReset (View view){
        homePoint = 0;
        displayHome(homePoint);

        visitingPoint = 0;
        displayVisit(visitingPoint);

        inningCounter = 1;
        displayInning(inningCounter);

        outsCounter = 0;
        displayOuts(outsCounter);

        ballsCounter = 0;
        displayBalls(ballsCounter);

        strikeCounter = 0;
        displayStrikes(strikeCounter);
    }
}