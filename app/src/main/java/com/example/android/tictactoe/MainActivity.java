package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView player;
    public static int playerScore = 0;
    public static int androidScore = 0;
    public static TextView gameScore;
    EditText nameListener;
    EditText sizeRowListener;
    EditText sizeColumnListener;
    public static Editable playerName;
    public static Editable sizeRow;
    public static Editable sizeColumn;
    public static int rows;
    public static int columns;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameScore = (TextView) findViewById(R.id.gameScore);
        player = (TextView) findViewById(R.id.playerText);
        nameListener = (EditText) findViewById(R.id.nameField);
        sizeRowListener = (EditText) findViewById(R.id.rowField);
        sizeColumnListener = (EditText) findViewById(R.id.columnField);

        gameScore.setText(playerScore+" : "+androidScore);
        //player.setText(playerName);



        /*      -- this way of changing the size works only with the imageviews already laid out in xml
        Button bttn = (Button) findViewById(R.id.start_button);
        bttn.getLayoutParams().width = 100;
        bttn.getLayoutParams().height = 100;
        bttn.requestLayout();
        */



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

        sizeRow = sizeRowListener.getText();
        sizeColumn = sizeColumnListener.getText();
        try {
            rows = Integer.parseInt(sizeRow.toString());
            columns = Integer.parseInt(sizeColumn.toString());
        }catch (NumberFormatException e){
            Toast.makeText(this, "Please enter a number from 1 - 10", Toast.LENGTH_LONG).show();
        }

        if ((rows > 0)&&(rows < 11)&&(columns > 0)&&(columns < 11)) {
            int winningLength = Math.min(Math.min(rows, columns),5);
            Toast.makeText(this, winningLength+" in a row wins", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, MainActivityVar.class));
        } else {
            Toast.makeText(this, "Please enter a number from 1 - 10", Toast.LENGTH_LONG).show();
        }



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
