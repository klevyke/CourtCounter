package com.example.android.courtcounter;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    static final String STATE_SCORETEAMA = "goalsTeamA";
    static final String STATE_SCORETEAMB = "goalsTeamB";
    static final String STATE_SHOTSTEAMA = "shotsTeamA";
    static final String STATE_SHOTSTEAMB = "shotsTeamB";
    static final String STATE_SHOTSONGOALTEAMA = "shotsOnGoalTeamA";
    static final String STATE_SHOTSONGOALTEAMB = "shotsOnGoalTeamB";
    static final String STATE_FOULSTEAMA = "foulsTeamA";
    static final String STATE_FOULSTEAMB = "foulsTeamB";
    static final String STATE_YELLOWCARDSTEAMA = "yellowCardsTeamA";
    static final String STATE_YELLOWCARDSTEAMB = "yellowCardsTeamB";
    static final String STATE_REDCARDSTEAMA = "redCardsTeamA";
    static final String STATE_REDCARDSTEAMB = "redCardsTeamB";
    static final String STATE_LIVETEXT = "liveText";
    static final String STATE_TIME = "time";
    static final String STATE_INPROGRESS = "inProgress";

    /**
     * Resource variable for strings
     */
    android.content.res.Resources res;

    /**
     * Default team names
     */
    String teamA;
    String teamB;

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
    /**
     * LiveText variable
     */
    CharSequence liveText = "";
    /**
     * Chronometer variable
     */
    Chronometer time;
    Boolean inProgress = Boolean.FALSE;
    /**
     * TextView variables
     */
    TextView scoreViewTeamA;
    TextView scoreViewTeamB;
    TextView shotsViewTeamA;
    TextView shotsViewTeamB;
    TextView shotsOnGoalViewTeamA;
    TextView shotsOnGoalViewTeamB;
    TextView foulsViewTeamA;
    TextView foulsViewTeamB;
    TextView yellowCardsViewTeamA;
    TextView yellowCardsViewTeamB;
    TextView redCardsViewTeamA;
    TextView redCardsViewTeamB;
    TextView liveTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the resource variable
        res = getResources();

        // Set default team names
        teamA = res.getString(R.string.team_a);
        teamB = res.getString(R.string.team_b);

        // Set the TexView variables
        scoreViewTeamA = (TextView) findViewById(R.id.team_a_score);
        scoreViewTeamB = (TextView) findViewById(R.id.team_b_score);
        shotsViewTeamA = (TextView) findViewById(R.id.team_a_shot);
        shotsViewTeamB = (TextView) findViewById(R.id.team_b_shot);
        shotsOnGoalViewTeamA = (TextView) findViewById(R.id.team_a_shot_on_goal);
        shotsOnGoalViewTeamB = (TextView) findViewById(R.id.team_b_shot_on_goal);
        foulsViewTeamA = (TextView) findViewById(R.id.team_a_foul);
        foulsViewTeamB = (TextView) findViewById(R.id.team_b_foul);
        yellowCardsViewTeamA = (TextView) findViewById(R.id.team_a_yellow_card);
        yellowCardsViewTeamB = (TextView) findViewById(R.id.team_b_yellow_card);
        redCardsViewTeamA = (TextView) findViewById(R.id.team_a_red_card);
        redCardsViewTeamB = (TextView) findViewById(R.id.team_b_red_card);
        liveTextView = (TextView) findViewById(R.id.live_text);
        time = findViewById(R.id.timer);
        disableButtons();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

        // Save the user's current score state
        savedInstanceState.putInt(STATE_SCORETEAMA, goalsTeamA);
        savedInstanceState.putInt(STATE_SCORETEAMB, goalsTeamB);
        savedInstanceState.putInt(STATE_SHOTSTEAMA, shotsTeamA);
        savedInstanceState.putInt(STATE_SHOTSTEAMB, shotsTeamB);
        savedInstanceState.putInt(STATE_SHOTSONGOALTEAMA, shotsOnGoalTeamA);
        savedInstanceState.putInt(STATE_SHOTSONGOALTEAMB, shotsOnGoalTeamB);
        savedInstanceState.putInt(STATE_FOULSTEAMA, foulsTeamA);
        savedInstanceState.putInt(STATE_FOULSTEAMB, foulsTeamB);
        savedInstanceState.putInt(STATE_YELLOWCARDSTEAMA, yellowCardsTeamA);
        savedInstanceState.putInt(STATE_YELLOWCARDSTEAMB, yellowCardsTeamB);
        savedInstanceState.putInt(STATE_REDCARDSTEAMA, redCardsTeamA);
        savedInstanceState.putInt(STATE_REDCARDSTEAMB, redCardsTeamB);
        savedInstanceState.putCharSequence(STATE_LIVETEXT, liveText);
        savedInstanceState.putLong(STATE_TIME, time.getBase());
        savedInstanceState.putBoolean(STATE_INPROGRESS, inProgress);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        goalsTeamA = savedInstanceState.getInt(STATE_SCORETEAMA);
        goalsTeamB = savedInstanceState.getInt(STATE_SCORETEAMB);
        shotsTeamA = savedInstanceState.getInt(STATE_SHOTSTEAMA);
        shotsTeamB = savedInstanceState.getInt(STATE_SHOTSTEAMB);
        shotsOnGoalTeamA = savedInstanceState.getInt(STATE_SHOTSONGOALTEAMA);
        shotsOnGoalTeamB = savedInstanceState.getInt(STATE_SHOTSONGOALTEAMB);
        foulsTeamA = savedInstanceState.getInt(STATE_FOULSTEAMA);
        foulsTeamB = savedInstanceState.getInt(STATE_FOULSTEAMB);
        yellowCardsTeamA = savedInstanceState.getInt(STATE_YELLOWCARDSTEAMA);
        yellowCardsTeamB = savedInstanceState.getInt(STATE_YELLOWCARDSTEAMB);
        redCardsTeamA = savedInstanceState.getInt(STATE_REDCARDSTEAMA);
        redCardsTeamB = savedInstanceState.getInt(STATE_REDCARDSTEAMB);
        liveText = savedInstanceState.getCharSequence(STATE_LIVETEXT);

        displayScoreTeamA(goalsTeamA);
        displayScoreTeamB(goalsTeamB);
        displayShotsTeamA(shotsTeamA);
        displayShotsTeamB(shotsTeamB);
        displayShotsOnGoalTeamA(shotsOnGoalTeamA);
        displayShotsOnGoalTeamB(shotsOnGoalTeamB);
        displayFoulsTeamA(foulsTeamA);
        displayFoulsTeamB(foulsTeamB);
        displayYellowCardsTeamA(yellowCardsTeamA);
        displayYellowCardsTeamB(yellowCardsTeamB);
        displayRedCardsTeamA(redCardsTeamA);
        displayRedCardsTeamB(redCardsTeamB);
        updateLiveText(liveText);
        if (savedInstanceState.getBoolean(STATE_INPROGRESS)) {
            time.setBase(savedInstanceState.getLong(STATE_TIME));
            time.start();
        }
    }
    /**
     * Add points for Team A.
     */
    public void scoreTeamA (View view) {
        goalsTeamA = goalsTeamA + 1;
        shotsOnGoalTeamA = shotsOnGoalTeamA + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.scored, currentTime, teamA));
        displayScoreTeamA(goalsTeamA);
        displayShotsOnGoalTeamA(shotsOnGoalTeamA);
    }
    public void shotTeamA (View view) {
        shotsTeamA = shotsTeamA + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.shoots, currentTime, teamA));
        displayShotsTeamA(shotsTeamA);
    }
    public void shotOnGoalTeamA (View view) {
        shotsOnGoalTeamA = shotsOnGoalTeamA + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.shoots_on_goal, currentTime, teamA));
        displayShotsOnGoalTeamA(shotsOnGoalTeamA);
    }
    public void foulTeamA (View view) {
        foulsTeamA = foulsTeamA + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.foul_commited, currentTime, teamA));
        displayFoulsTeamA(foulsTeamA);
    }
    public void yellowCardTeamA (View view) {
        yellowCardsTeamA = yellowCardsTeamA + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.yellow_card_shown, currentTime, teamA));
        displayYellowCardsTeamA(yellowCardsTeamA);
    }
    public void redCardTeamA (View view) {
        redCardsTeamA = redCardsTeamA + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.red_card_shown, currentTime, teamA));
        displayRedCardsTeamA(redCardsTeamA);
    }
    /**
     * Add points for Team B.
     */
    public void scoreTeamB (View view) {
        goalsTeamB = goalsTeamB + 1;
        shotsOnGoalTeamB = shotsOnGoalTeamB + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.scored, currentTime, teamB));
        displayScoreTeamB(goalsTeamB);
        displayShotsOnGoalTeamB(shotsOnGoalTeamB);
    }
    public void shotTeamB (View view) {
        shotsTeamB = shotsTeamB + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.shoots, currentTime, teamB));
        displayShotsTeamB(shotsTeamB);
    }
    public void shotOnGoalTeamB (View view) {
        shotsOnGoalTeamB = shotsOnGoalTeamB + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.shoots_on_goal, currentTime, teamB));
        displayShotsOnGoalTeamB(shotsOnGoalTeamB);
    }
    public void foulTeamB (View view) {
        foulsTeamB = foulsTeamB + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.foul_commited, currentTime, teamB));
        displayFoulsTeamB(foulsTeamB);
    }
    public void yellowCardTeamB (View view) {
        yellowCardsTeamB = yellowCardsTeamB + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.yellow_card_shown, currentTime, teamB));
        displayYellowCardsTeamB(yellowCardsTeamB);
    }
    public void redCardTeamB (View view) {
        redCardsTeamB = redCardsTeamB + 1;
        String currentTime = getTime(view);
        updateLiveText(res.getString(R.string.red_card_shown, currentTime, teamB));
        displayRedCardsTeamB(redCardsTeamB);
    }
    /**
     * Start match.
     */
    public void startMatch(View view) {
        // Check if team A is set
        if (getTeamA(view).length()>0) {
            teamA = getTeamA(view);
        }
        // Check if team B is set
        if (getTeamB(view).length()>0) {
            teamB = getTeamB(view);
        }

        // Update LiveText
        updateLiveText(res.getString(R.string.match_begins, teamA, teamB));

        //Start the time
        Chronometer time = findViewById(R.id.timer);
        time.setBase(SystemClock.elapsedRealtime());
        time.start();
        inProgress = Boolean.TRUE;

        // Enable the Buttons
        enableButtons();
    }
    /**
     * Reset scores.
     */
    public void resetScore(View view) {
        // Enable the Buttons
        disableButtons();
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
        /**
         * Stop the timer and set to 0;
         */
        Chronometer time = findViewById(R.id.timer);
        time.setBase(SystemClock.elapsedRealtime());
        time.stop();
        inProgress = Boolean.FALSE;
        /**
         * Reset Livetext
         */
        TextView scoreView = (TextView) findViewById(R.id.live_text);
        scoreView.setText("");
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayScoreTeamA(int score) {
        scoreViewTeamA.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayScoreTeamB(int score) {
        scoreViewTeamB.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots for Team A.
     */
    public void displayShotsTeamA(int score) {
        shotsViewTeamA.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots for Team B.
     */
    public void displayShotsTeamB(int score) {
        shotsViewTeamB.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots on goal for Team A.
     */
    public void displayShotsOnGoalTeamA(int score) {
        shotsOnGoalViewTeamA.setText(String.valueOf(score));
    }
    /**
     * Displays the given shots on goal for Team B.
     */
    public void displayShotsOnGoalTeamB(int score) {
        shotsOnGoalViewTeamB.setText(String.valueOf(score));
    }
    /**
     * Displays the given fouls for Team A.
     */
    public void displayFoulsTeamA(int score) {
        foulsViewTeamA.setText(String.valueOf(score));
    }
    /**
     * Displays the given fouls for Team B.
     */
    public void displayFoulsTeamB(int score) {
        foulsViewTeamB.setText(String.valueOf(score));
    }
    /**
     * Displays the given yellow cards for Team A.
     */
    public void displayYellowCardsTeamA(int score) {
        yellowCardsViewTeamA.setText(String.valueOf(score));
    }
    /**
     * Displays the given yellow cards for Team B.
     */
    public void displayYellowCardsTeamB(int score) {
        yellowCardsViewTeamB.setText(String.valueOf(score));
    }
    /**
     * Displays the given red cards for Team A.
     */
    public void displayRedCardsTeamA(int score) {
        redCardsViewTeamA.setText(String.valueOf(score));
    }
    /**
     * Displays the given red cards for Team B.
     */
    public void displayRedCardsTeamB(int score) {
        redCardsViewTeamB.setText(String.valueOf(score));
    }

    /**
     * Get the name of the first team
     */
    public String getTeamA (View view) {
        EditText teamA = (EditText) findViewById(R.id.team_a);
        return teamA.getText().toString();
    }
    /**
     * Get the name of the second team
     */
    public String getTeamB (View view) {
        EditText teamB = (EditText) findViewById(R.id.team_b);
        return teamB.getText().toString();
    }
    /**
     * Get the current time
     */
    public String getTime (View view) {
        return (String) time.getText();
    }
    /**
     * Update Livetext
     */
    public void updateLiveText (CharSequence text) {
        liveText = text + "\n" + liveTextView.getText();
        liveTextView.setText(liveText);
    }

    /**
     * Disable the buttons until the Start button hit or an reset
     */
    public void disableButtons() {
        int disabledColor = res.getColor(R.color.disabled_button_text_color);
        // Disable the Goal Buttons
        Button goalTeamAButton = (Button) findViewById(R.id.team_a_goal_button);
        goalTeamAButton.setEnabled(Boolean.FALSE);
        goalTeamAButton.setTextColor(disabledColor);
        Button goalTeamBButton = (Button) findViewById(R.id.team_b_goal_button);
        goalTeamBButton.setEnabled(Boolean.FALSE);
        goalTeamBButton.setTextColor(disabledColor);

        // Disable the Shot Buttons
        Button shotTeamAButton = (Button) findViewById(R.id.team_a_shot_button);
        shotTeamAButton.setEnabled(Boolean.FALSE);
        shotTeamAButton.setTextColor(disabledColor);
        Button shotTeamBButton = (Button) findViewById(R.id.team_b_shot_button);
        shotTeamBButton.setEnabled(Boolean.FALSE);
        shotTeamBButton.setTextColor(disabledColor);

        // Disable the Shot on goal Buttons
        Button shotOnGoalTeamAButton = (Button) findViewById(R.id.team_a_shot_on_goal_button);
        shotOnGoalTeamAButton.setEnabled(Boolean.FALSE);
        shotOnGoalTeamAButton.setTextColor(disabledColor);
        Button shotOnGoalTeamBButton = (Button) findViewById(R.id.team_b_shot_on_goal_button);
        shotOnGoalTeamBButton.setEnabled(Boolean.FALSE);
        shotOnGoalTeamBButton.setTextColor(disabledColor);

        // Disable the Foul Buttons
        Button foulTeamAButton = (Button) findViewById(R.id.team_a_foul_button);
        foulTeamAButton.setEnabled(Boolean.FALSE);
        foulTeamAButton.setTextColor(disabledColor);
        Button foulTeamBButton = (Button) findViewById(R.id.team_b_foul_button);
        foulTeamBButton.setEnabled(Boolean.FALSE);
        foulTeamBButton.setTextColor(disabledColor);

        // Disable the Yellow Card Buttons
        Button yellowCardTeamAButton = (Button) findViewById(R.id.team_a_yellow_card_button);
        yellowCardTeamAButton.setEnabled(Boolean.FALSE);
        yellowCardTeamAButton.setTextColor(disabledColor);
        Button yellowCardTeamBButton = (Button) findViewById(R.id.team_b_yellow_card_button);
        yellowCardTeamBButton.setEnabled(Boolean.FALSE);
        yellowCardTeamBButton.setTextColor(disabledColor);

        // Disable the Yellow Card Buttons
        Button redCardTeamAButton = (Button) findViewById(R.id.team_a_red_card_button);
        redCardTeamAButton.setEnabled(Boolean.FALSE);
        redCardTeamAButton.setTextColor(disabledColor);
        Button redCardTeamBButton = (Button) findViewById(R.id.team_b_red_card_button);
        redCardTeamBButton.setEnabled(Boolean.FALSE);
        redCardTeamBButton.setTextColor(disabledColor);
    }

    /**
     * Disable the buttons until the Start button hit or an reset
     */
    public void enableButtons() {
        int enabledColor = res.getColor(R.color.text);
        // Enable the Goal Buttons
        Button goalTeamAButton = (Button) findViewById(R.id.team_a_goal_button);
        goalTeamAButton.setEnabled(Boolean.TRUE);
        goalTeamAButton.setTextColor(enabledColor);
        Button goalTeamBButton = (Button) findViewById(R.id.team_b_goal_button);
        goalTeamBButton.setEnabled(Boolean.TRUE);
        goalTeamBButton.setTextColor(enabledColor);

        // Enable the Shot Buttons
        Button shotTeamAButton = (Button) findViewById(R.id.team_a_shot_button);
        shotTeamAButton.setEnabled(Boolean.TRUE);
        shotTeamAButton.setTextColor(enabledColor);
        Button shotTeamBButton = (Button) findViewById(R.id.team_b_shot_button);
        shotTeamBButton.setEnabled(Boolean.TRUE);
        shotTeamBButton.setTextColor(enabledColor);

        // Enable the Shot on goal Buttons
        Button shotOnGoalTeamAButton = (Button) findViewById(R.id.team_a_shot_on_goal_button);
        shotOnGoalTeamAButton.setEnabled(Boolean.TRUE);
        shotOnGoalTeamAButton.setTextColor(enabledColor);
        Button shotOnGoalTeamBButton = (Button) findViewById(R.id.team_b_shot_on_goal_button);
        shotOnGoalTeamBButton.setEnabled(Boolean.TRUE);
        shotOnGoalTeamBButton.setTextColor(enabledColor);

        // Enable the Foul Buttons
        Button foulTeamAButton = (Button) findViewById(R.id.team_a_foul_button);
        foulTeamAButton.setEnabled(Boolean.TRUE);
        foulTeamAButton.setTextColor(enabledColor);
        Button foulTeamBButton = (Button) findViewById(R.id.team_b_foul_button);
        foulTeamBButton.setEnabled(Boolean.TRUE);
        foulTeamBButton.setTextColor(enabledColor);

        // Enable the Yellow Card Buttons
        Button yellowCardTeamAButton = (Button) findViewById(R.id.team_a_yellow_card_button);
        yellowCardTeamAButton.setEnabled(Boolean.TRUE);
        yellowCardTeamAButton.setTextColor(enabledColor);
        Button yellowCardTeamBButton = (Button) findViewById(R.id.team_b_yellow_card_button);
        yellowCardTeamBButton.setEnabled(Boolean.TRUE);
        yellowCardTeamBButton.setTextColor(enabledColor);

        // Enable the Yellow Card Buttons
        Button redCardTeamAButton = (Button) findViewById(R.id.team_a_red_card_button);
        redCardTeamAButton.setEnabled(Boolean.TRUE);
        redCardTeamAButton.setTextColor(enabledColor);
        Button redCardTeamBButton = (Button) findViewById(R.id.team_b_red_card_button);
        redCardTeamBButton.setEnabled(Boolean.TRUE);
        redCardTeamBButton.setTextColor(enabledColor);
    }
}
