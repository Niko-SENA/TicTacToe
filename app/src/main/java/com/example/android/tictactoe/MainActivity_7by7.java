package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity_7by7 extends AppCompatActivity {

    static int boardSize = 7;
    static char[][] mainBoard = new char[boardSize][boardSize];
    List<Integer> list = new ArrayList<>(boardSize*boardSize); // need this for the random Android play


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_7by7);

        for (int i = 0; i < boardSize*boardSize; i++) {
            list.add(i);
        }

        for (int i = 0; i < boardSize; i++){
            for (int j = 0; i < boardSize; j++){
                mainBoard[i][j] = '*';
            }
        }

    }

    public void clickedX(View v){

        int iIndex = (v.getId()-R.id.imageViewX00)/boardSize;
        int jIndex = (v.getId()-R.id.imageViewX00)%boardSize;

        mainBoard[iIndex][jIndex] = 'X';

        ImageView xvisibility = (ImageView) findViewById(v.getId());
        xvisibility.setImageResource(R.drawable.ximage);
        xvisibility.setClickable(false);
        list.remove((Object)(v.getId()-R.id.imageViewX00));


        //Toast.makeText(this, Integer.toString(v.getId()), Toast.LENGTH_LONG).show();


        if (checkWin('X')){
            Toast.makeText(this, "**********\n"+"*YOU WIN*\n"+"**********", Toast.LENGTH_LONG).show();
            MainActivity.playerScore ++;

            MainActivity.gameScore.setText(MainActivity.playerScore+" : "+MainActivity.androidScore);
            finish();
            return;
        }
        if (list.isEmpty()){
            Toast.makeText(this, "~~ DRAW ~~", Toast.LENGTH_LONG).show();
            finish();
            return;
        }






        Random rand = new Random();
        int rndIndexInList = rand.nextInt(list.size());
        int temp = list.remove(rndIndexInList);

        mainBoard[temp/boardSize][temp%boardSize] = 'O';

        ImageView ovisibility = (ImageView) findViewById(temp+R.id.imageViewX00);
        ovisibility.setImageResource(R.drawable.oimage);
        ovisibility.setClickable(false);

        if (checkWin('O')){
            Toast.makeText(this, "##########\n"+"# YOU LOSE #\n"+"##########", Toast.LENGTH_LONG).show();
            MainActivity.androidScore ++;
            MainActivity.gameScore.setText(MainActivity.playerScore+" : "+MainActivity.androidScore);
            finish();
            //return;
        }



    }

    public boolean checkWin (char who){
        return true;
        /*
        return (mainBoard[0] == who) && (mainBoard[1] == who) && (mainBoard[2] == who) ||
                (mainBoard[3] == who) && (mainBoard[4] == who) && (mainBoard[5] == who) ||
                (mainBoard[6] == who) && (mainBoard[7] == who) && (mainBoard[8] == who) ||
                (mainBoard[0] == who) && (mainBoard[3] == who) && (mainBoard[6] == who) ||
                (mainBoard[1] == who) && (mainBoard[4] == who) && (mainBoard[7] == who) ||
                (mainBoard[2] == who) && (mainBoard[5] == who) && (mainBoard[8] == who) ||
                (mainBoard[0] == who) && (mainBoard[4] == who) && (mainBoard[8] == who) ||
                (mainBoard[2] == who) && (mainBoard[4] == who) && (mainBoard[6] == who);
        */
    }




}
