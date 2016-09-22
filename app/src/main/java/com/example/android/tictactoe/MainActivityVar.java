package com.example.android.tictactoe;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityVar extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_activity_var);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setOrientation(GridLayout.HORIZONTAL);
        gridLayout.setBackgroundColor(0xffd0fff1);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(3);
        //gridLayout.setAlignmentMode();

        for (int i = 0; i < 9; i++){
            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.emptyimage);
            image.setPadding(4,4,4,4);
            gridLayout.addView(image);
        }


        Toast.makeText(this,Integer.toString(gridLayout.getWidth()), Toast.LENGTH_LONG).show();

        //gridLayout.setLayoutParams(GridLayout.LayoutParams.MATCH_PARENT));

        //ImageView image = new ImageView(this);
        //image.setImageResource(R.drawable.ximage);
        //GridLayout.Spec row = GridLayout.spec(0, 1);		// rowIndex is the Start, 1 is the size
        //GridLayout.Spec colspan = GridLayout.spec(0, 1);	// same
        //image.setLayoutParams(new GridLayout.LayoutParams(row, colspan));
        /*GridLayout.Spec row = GridLayout.spec(0, 1);		// rowIndex is the Start, 1 is the size
        GridLayout.Spec colspan = GridLayout.spec(0, 1);	// same
        GridLayout.LayoutParams gridLayoutParam = new GridLayout.LayoutParams(row, colspan);
        gridLayout.addView(image, gridLayoutParam);
        */
        //gridLayout.addView(image);



        //ImageView image1 = new ImageView(this);
        //image1.setImageResource(R.drawable.oimage);
        //GridLayout.Spec row1 = GridLayout.spec(0, 1);		// rowIndex is the Start, 1 is the size
        //GridLayout.Spec colspan1 = GridLayout.spec(0, 1);	// same
        //image.setLayoutParams(new GridLayout.LayoutParams(row1, colspan1));
        //GridLayout.LayoutParams gridLayoutParam1 = new GridLayout.LayoutParams(row1, colspan1);
        //gridLayout.addView(image1);




        setContentView(gridLayout);





    }
}
