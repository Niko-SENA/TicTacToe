package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView player;
    public static int playerScore = 0;
    public static int androidScore = 0;
    public static TextView gameScore;
    EditText nameListener;
    public static Editable playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameScore = (TextView) findViewById(R.id.gameScore);
        player = (TextView) findViewById(R.id.playerText);
        nameListener = (EditText) findViewById(R.id.nameField);
        gameScore.setText(playerScore+" : "+androidScore);
        player.setText(playerName);


        /*
        nameListener.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                player.setText(nameListener.getText());

            }
        });
        */



    }

    public void startButtonClick (View v) {

        //Toast.makeText(this, "You clicked the Button", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, MainActivity_7by7.class));

    }

    public void scoreReset (View v){
        playerScore = 0;
        androidScore = 0;
        gameScore.setText(playerScore+" : "+androidScore);
    }

    public void saveName (View v){
        playerName = nameListener.getText();
        player.setText(playerName);
        nameListener.setText("");
        nameListener.setCursorVisible(false);
    }

}
