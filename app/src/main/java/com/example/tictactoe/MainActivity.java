package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    int i = r.nextInt(2);
    int a[] = {2,2,2,2,2,2,2,2,2};
    int b[][]= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void r1c1(View view) {
        // 0 means superman,1 means batman and 2 means empty.
        ImageView iv1 = (ImageView) view;
        String s= iv1.getTag().toString();
        int j = Integer.parseInt(s);
        iv1.setTranslationY(-1500);
        a[j] = i;
        if(i==0) {
            iv1.setImageResource(R.drawable.superman);
            iv1.animate().translationYBy(1500).setDuration(300);
            i=1;
        }else {
            iv1.setImageResource(R.drawable.batman);
            iv1.animate().translationYBy(1500).setDuration(300);
            i=0;
        }
        for(int c[]:b){
            Button b1 = (Button) findViewById(R.id.button);
            TextView tv = (TextView)findViewById(R.id.textView);
            if(a[c[0]]==a[c[1]]&&a[c[1]]==a[c[2]]&&a[c[0]]==0){
                b1.setVisibility(View.VISIBLE);
                tv.setText("Superman won the game.");
                tv.setVisibility(view.VISIBLE);
            }else if(a[c[0]]==a[c[1]]&&a[c[1]]==a[c[2]]&&a[c[0]]==1 ){

                b1.setVisibility(View.VISIBLE);
                tv.setText("Batman won the game.");
                tv.setVisibility(view.VISIBLE);
            }
        }
    }
    public void play_again (View view) {
            Button b1 = (Button) findViewById(R.id.button);
            TextView tv = (TextView) findViewById(R.id.textView);
            b1.setVisibility(View.INVISIBLE);
            tv.setVisibility(view.INVISIBLE);
            GridLayout gl = (GridLayout) findViewById(R.id.gridLayout);
            for (int j = 0; j < gl.getChildCount(); j++) {
                ImageView iv = (ImageView) gl.getChildAt(j);
                iv.setImageDrawable(null);
            }
            Arrays.fill(a, 2);
            i = r.nextInt(2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
