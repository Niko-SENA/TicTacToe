package com.example.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main4Activity extends AppCompatActivity {



    static int boardSize = 3;
    static char[] mainBoard = new char[boardSize*boardSize];
    List<Integer> list = new ArrayList<>(9);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        for (int i = 0; i < mainBoard.length; i++) {
            mainBoard[i] = '*';
            list.add(i);
        }



    }

    public void clickedX(View v){

        mainBoard[(v.getId()-R.id.imageViewX00)] = 'X';

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

        mainBoard[temp] = 'O';

        ImageView ovisibility = (ImageView) findViewById(temp+R.id.imageViewX00);
        ovisibility.setImageResource(R.drawable.oimage);
        ovisibility.setClickable(false);

        if (checkWin('O')){
            Toast.makeText(this, "##########\n"+"# YOU LOSE #\n"+"##########", Toast.LENGTH_LONG).show();
            MainActivity.androidScore ++;
            MainActivity.gameScore.setText(MainActivity.playerScore+" : "+MainActivity.androidScore);
            finish();
            return;
        }



    }

    public boolean checkWin (char who){
        if ((mainBoard[0] == who)&&(mainBoard[1] == who)&&(mainBoard[2] == who)||
            (mainBoard[3] == who)&&(mainBoard[4] == who)&&(mainBoard[5] == who)||
            (mainBoard[6] == who)&&(mainBoard[7] == who)&&(mainBoard[8] == who)||
            (mainBoard[0] == who)&&(mainBoard[3] == who)&&(mainBoard[6] == who)||
            (mainBoard[1] == who)&&(mainBoard[4] == who)&&(mainBoard[7] == who)||
            (mainBoard[2] == who)&&(mainBoard[5] == who)&&(mainBoard[8] == who)||
            (mainBoard[0] == who)&&(mainBoard[4] == who)&&(mainBoard[8] == who)||
            (mainBoard[2] == who)&&(mainBoard[4] == who)&&(mainBoard[6] == who)){
            return true;
        }
        return false;
    }


}
