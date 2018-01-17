package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * Score variables
     */
    int goalsTeamA = 0;
    int goalsTeamB = 0;
    /**
     * Shot variables
     */
    int shotsTeamA = 0;
    int shotsTeamB = 0;
    /**
     * Shots on goal variables
     */
    int shotsOnGoalTeamA = 0;
    int shotsOnGoalTeamB = 0;
    /**
     * Foul variables
     */
    int foulsTeamA = 0;
    int foulsTeamB = 0;
    /**
     * Yellow cards variables
     */
    int yellowCardsTeamA = 0;
    int yellowCardsTeamB = 0;
    /**
     * Red cards variables
     */
    int redCardsTeamA = 0;
    int redCardsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Add points for Team A.
     */
    public void scoreTeamA (View view) {
        goalsTeamA = goalsTeamA + 1;
        displayScoreTeamA(goalsTeamA);
    }
    public void shotTeamA (View view) {
        shotsTeamA = shotsTeamA + 1;
        displayShotsTeamA(shotsTeamA);
    }
    public void shotOnGoalTeamA (View view) {
        shotsOnGoalTeamA = shotsOnGoalTeamA + 1;
        displayShotsOnGoalTeamA(shotsOnGoalTeamA);
    }
    public void foulTeamA (View view) {
        foulsTeamA = foulsTeamA + 1;
        displayFoulsTeamA(foulsTeamA);
    }
    public void yellowCardTeamA (View view) {
        yellowCardsTeamA = yellowCardsTeamA + 1;
        displayYellowCardsTeamA(yellowCardsTeamA);
    }
    public void redCardTeamA (View view) {
        redCardsTeamA = redCardsTeamA + 1;
        displayRedCardsTeamA(redCardsTeamA);
    }
    /**
     * Add points for Team A.
     */
    public void scoreTeamB (View view) {
        goalsTeamB = goalsTeamB + 1;
        displayScoreTeamB(goalsTeamB);
    }
    public void shotTeamB (View view) {
        shotsTeamB = shotsTeamB + 1;
        displayShotsTeamB(shotsTeamB);
    }
    public void shotOnGoalTeamB (View view) {
        shotsOnGoalTeamB = shotsOnGoalTeamB + 1;
        displayShotsOnGoalTeamB(shotsOnGoalTeamB);
    }
    public void foulTeamB (View view) {
        foulsTeamB = foulsTeamB + 1;
        displayFoulsTeamB(foulsTeamB);
    }
    public void yellowCardTeamB (View view) {
        yellowCardsTeamB = yellowCardsTeamB + 1;
        displayYellowCardsTeamB(yellowCardsTeamB);
    }
    public void redCardTeamB (View view) {
        redCardsTeamB = redCardsTeamB + 1;
        displayRedCardsTeamB(redCardsTeamB);
    }
    /**
     * Reset scores.
     */
    public void resetScore(View view) {
        goalsTeamA = 0;
        displayScoreTeamA(goalsTeamA);
        goalsTeamB = 0;
        displayScoreTeamB(goalsTeamB);
        shotsTeamA = 0;
        displayShotsTeamA(shotsTeamA);
        shotsTeamB = 0;
        displayShotsTeamB(shotsTeamB);
        shotsOnGoalTeamA = 0;
        displayShotsOnGoalTeamA(shotsOnGoalTeamA);
        shotsOnGoalTeamB = 0;
        displayShotsOnGoalTeamB(shotsOnGoalTeamB);
        foulsTeamA = 0;
        displayFoulsTeamA(foulsTeamA);
        foulsTeamB = 0;
        displayFoulsTeamB(foulsTeamB);
        yellowCardsTeamA = 0;
        displayYellowCardsTeamA(yellowCardsTeamA);
        yellowCardsTeamB = 0;
        displayYellowCardsTeamB(yellowCardsTeamB);
        redCardsTeamA = 0;
        displayRedCardsTeamA(redCardsTeamA);
        redCardsTeamB = 0;
        displayRedCardsTeamB(redCardsTeamB);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayScoreTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayScoreTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots for Team A.
     */
    public void displayShotsTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_shot);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots for Team B.
     */
    public void displayShotsTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_shot);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots on goal for Team A.
     */
    public void displayShotsOnGoalTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_shot_on_goal);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots on goal for Team B.
     */
    public void displayShotsOnGoalTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_shot_on_goal);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given fouls for Team A.
     */
    public void displayFoulsTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given fouls for Team B.
     */
    public void displayFoulsTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given yellow cards for Team A.
     */
    public void displayYellowCardsTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_yellow_card);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given yellow cards for Team B.
     */
    public void displayYellowCardsTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_yellow_card);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given red cards for Team A.
     */
    public void displayRedCardsTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_red_card);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given red cards for Team B.
     */
    public void displayRedCardsTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_red_card);
        scoreView.setText(String.valueOf(score));
    }
}
