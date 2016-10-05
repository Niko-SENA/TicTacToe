package com.example.android.tictactoe;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivityVar extends AppCompatActivity {

    // declaring/initializing variables necessary to draw the board and for implementation
    // of logical part of the program
    private int sizeRow = MainActivity.rows;
    private int sizeColumn = MainActivity.columns;
    private int winningLength = Math.min(Math.min(sizeRow, sizeColumn),5);
    private char[] mainBoard = new char[sizeRow*sizeColumn]; // logical board
    List<Integer> list = new ArrayList<>(sizeRow*sizeColumn); // need this for the random Android play

    private View.OnClickListener clickedX = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageView clickedSquare = (ImageView) findViewById(v.getId());
            //ImageView clickedSquare = new ImageView(v.getContext());
            clickedSquare.setImageResource(R.drawable.ximage);
            clickedSquare.setClickable(false);
            list.remove((Object) v.getId());
            mainBoard[v.getId()] = 'X';

            if (checkWin('X', v)){
                winningToast();
                MainActivity.playerScore ++;
                MainActivity.gameScore.setText(MainActivity.playerScore+" : "+MainActivity.androidScore);
                finish();
                return;
            }
            if (list.isEmpty()){
                drawToast();
                finish();
                return;
            }


            Random rand = new Random();
            int rndIndexInList = rand.nextInt(list.size());
            int temp = list.remove(rndIndexInList);

            mainBoard[temp] = 'O';

            ImageView ovisibility = (ImageView) findViewById(temp);
            ovisibility.setImageResource(R.drawable.oimage);
            ovisibility.setClickable(false);

            if (checkWin('O', ovisibility)){
                losingToast();
                MainActivity.androidScore ++;
                MainActivity.gameScore.setText(MainActivity.playerScore+" : "+MainActivity.androidScore);
                finish();
                return;
            }

        }
    };


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_var);

        //adjusting the Image size according to device screen size and board size
        Point size = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(size);
        int viewWidth = size.x;
        int viewHeight = size.y;
        int imageSize = Math.min((viewWidth/(sizeColumn+2)), (viewHeight/(sizeRow+3)));
        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(imageSize, imageSize);

        //drawing the board according to user specified size
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridID);
        gridLayout.setColumnCount(sizeColumn);
        gridLayout.setRowCount(sizeRow);
        for (int i = 0; i < sizeColumn*sizeRow; i++){
            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.emptyimage);
            image.setPadding(4,4,4,4);
            image.setClickable(true);
            image.setLayoutParams(relativeParams);
            image.setId(i);
            gridLayout.addView(image);
            list.add(i);
            mainBoard[i] = '*';         //implementing logical board
            image.setOnClickListener(clickedX);
        }

        //setContentView(gridLayout);
    }


    private void winningToast() {
        Toast.makeText(this, "**********\n"+"*YOU WIN*\n"+"**********", Toast.LENGTH_LONG).show();
    }
    private void drawToast() {
        Toast.makeText(this, "~~ DRAW ~~", Toast.LENGTH_LONG).show();
    }
    private void losingToast() {
        Toast.makeText(this, "##########\n"+"# YOU LOSE #\n"+"##########", Toast.LENGTH_LONG).show();
    }


    private boolean checkWin (char who, View view){

        return checkSN(who, view)||checkEW(who, view)||checkSWNE(who, view)||checkSENW(who, view);
    }


    
    private boolean checkSN (char who, View view){
        int clickedCellID = view.getId();
        int winSN = 1;
        int counter = 1;

        int index;
        do {
            index = clickedCellID - sizeColumn*counter;
            if (index >= 0){
                if (mainBoard[index] == who){
                    winSN++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);


        do {
            index = clickedCellID + sizeColumn*counter;
            if (index < sizeColumn*sizeRow){
                if (mainBoard[index] == who){
                    winSN++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);

        return winSN >= winningLength;
    }

    private boolean checkEW (char who, View view){
        int clickedCellID = view.getId();
        int winEW = 1;
        int counter = 1;

        int index;
        do {
            index = clickedCellID - counter;
            if (index%sizeColumn != sizeColumn-1 && index >= 0){///////////////////////////////////////////
                if (mainBoard[index] == who){
                    winEW++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);


        do {
            index = clickedCellID + counter;
            if (index%sizeColumn != 0){
                if (mainBoard[index] == who){
                    winEW++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);

        return winEW >= winningLength;
    }

    private boolean checkSWNE (char who, View view){
        int clickedCellID = view.getId();
        int winSWNE = 1;
        int counter = 1;

        int index;
        do {
            index = clickedCellID - (sizeColumn-1)*counter;
            if (index%sizeColumn != 0 && index > 0){
                if (mainBoard[index] == who){
                    winSWNE++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);


        do {
            index = clickedCellID + (sizeColumn-1)*counter;
            if (index%sizeColumn != sizeColumn-1 && index < sizeColumn*sizeRow){
                if (mainBoard[index] == who){
                    winSWNE++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);

        return winSWNE >= winningLength;
    }

    private boolean checkSENW (char who, View view){
        int clickedCellID = view.getId();
        int winSENW = 1;
        int counter = 1;

        int index;
        do {
            index = clickedCellID - (sizeColumn+1)*counter;
            if (index%sizeColumn != sizeColumn-1 && index >= 0){
                if (mainBoard[index] == who){
                    winSENW++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);


        do {
            index = clickedCellID + (sizeColumn+1)*counter;
            if (index%sizeColumn != 0 && index < sizeColumn*sizeRow){
                if (mainBoard[index] == who){
                    winSENW++;
                    counter++;
                } else {
                    counter = 1;
                    break;
                }
            } else {
                counter = 1;
                break;
            }
        } while (true);

        return winSENW >= winningLength;
    }

}
