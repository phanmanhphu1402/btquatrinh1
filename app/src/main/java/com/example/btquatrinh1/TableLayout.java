package com.example.btquatrinh1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TableLayout extends Activity {
    SeekBar sbThree = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        sbThree = findViewById(R.id.seekBarThree);
        sbThree.setMax(100);

        final TextView TextTB1 = (TextView) findViewById(R.id.TextTB1);
        final TextView TextTB2 = (TextView) findViewById(R.id.TextTB2);
        final TextView TextTB3 = (TextView) findViewById(R.id.TextTB3);
        final TextView TextTB4 = (TextView) findViewById(R.id.TextTB4);
        final TextView TextTB5 = (TextView) findViewById(R.id.TextTB5);


        sbThree.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progChange = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int[] redArray = {255, 0, 0};
                int[] blueArray = {0, 0, 255};
                int[] yellowArray = {255, 255, 0};

                progChange = i;

                //Make incremental color value changes

                redArray[0] = redArray[0] - (255/100)*progChange;
                blueArray[0] = blueArray[0] + (255/100)*progChange;
                blueArray[2] = blueArray[2] - (255/100)*progChange;
                yellowArray[0] = yellowArray[0] - (125/100)*progChange;
                yellowArray[2] = yellowArray[2] + (130/100)*progChange;

                //Set the boxes to new colors

                TextTB1.setBackgroundColor(Color.rgb(redArray[0],yellowArray[2],redArray[2]));
                TextTB2.setBackgroundColor(Color.rgb(redArray[0],blueArray[2],redArray[2]));
                TextTB3.setBackgroundColor(Color.rgb(redArray[0],redArray[1],blueArray[2]));
                TextTB4.setBackgroundColor(Color.rgb(blueArray[0],yellowArray[2],blueArray[2]));
                TextTB5.setBackgroundColor(Color.rgb(redArray[0],blueArray[1],blueArray[2]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
