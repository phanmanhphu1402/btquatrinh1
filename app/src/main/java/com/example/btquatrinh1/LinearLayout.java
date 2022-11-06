package com.example.btquatrinh1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LinearLayout extends Activity {
    SeekBar sbOne = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        sbOne = findViewById(R.id.seekbarOne);
        sbOne.setMax(100);

        final TextView text1 = (TextView) findViewById(R.id.text1);
        final TextView text2 = (TextView) findViewById(R.id.text2);
        final TextView text3 = (TextView) findViewById(R.id.text3);
        final TextView text4 = (TextView) findViewById(R.id.text4);
        final TextView text5 = (TextView) findViewById(R.id.text5);


        sbOne.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progChange = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int[] redArray = {255, 0, 0};
                int[] blueArray = {0, 0, 255};
                int[] yellowArray = {255, 255, 0};

                progChange = i;

                //Make incremental color value changes

                redArray[0] = redArray[0] - (255/100)*progChange;
                redArray[1] = redArray[1] + (229/100)*progChange;
                redArray[2] = redArray[2] + (238/100)*progChange;
                blueArray[0] = blueArray[0] + (255/100)*progChange;
                blueArray[1] = blueArray[1] + (202/100)*progChange;
                blueArray[2] = blueArray[2] - (255/100)*progChange;
                yellowArray[0] = yellowArray[0] - (225/100)*progChange;
                yellowArray[1] = yellowArray[1] - (255/100)*progChange;
                yellowArray[2] = yellowArray[2] + (230/100)*progChange;

                //Set the boxes to new colors

                text1.setBackgroundColor(Color.rgb(redArray[0],redArray[1],redArray[2]));
                text2.setBackgroundColor(Color.rgb(yellowArray[0],yellowArray[1],yellowArray[2]));
                text3.setBackgroundColor(Color.rgb(redArray[0],redArray[1],blueArray[2]));
                text4.setBackgroundColor(Color.rgb(blueArray[0],yellowArray[2],blueArray[2]));
                text5.setBackgroundColor(Color.rgb(redArray[0],blueArray[1],blueArray[2]));
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
