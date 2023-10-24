package com.talhakasikci.catchthezoro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   TextView scoreText;
   EditText enterTime;
   TextView timeText;
   Button startButton;
   ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ImageView imagearray[];
    int score=0;
    int aktif = 0;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        scoreText = findViewById(R.id.Scoretext);
        timeText = findViewById(R.id.time);
        image1 = findViewById(R.id.imageView);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView3);
        image4 = findViewById(R.id.imageView4);
        image5 = findViewById(R.id.imageView5);
        image6 = findViewById(R.id.imageView6);
        image7 = findViewById(R.id.imageView7);
        image8 = findViewById(R.id.imageView8);
        image9 = findViewById(R.id.imageView9);
        enterTime = findViewById(R.id.enterTime);

        imagearray = new ImageView[] {image1,image2,image3,image4,image5,image6,image7,image8,image9};
        hideImages();



    }

    private void hideImages() {
        for (ImageView image : imagearray){
            image.setVisibility(View.INVISIBLE);
        }

        Random random = new Random();

        int number = random.nextInt(9);
        imagearray[number].setVisibility(View.VISIBLE);

    }

    public void kac(View view){
        if (aktif == 1) {
            score++;
            scoreText.setText("Score: "+score);
            hideImages();
        }


    }

    public void basla(View view){
        startButton.setEnabled(false);
        score = 0;
        aktif = 1;
        enterTime.setEnabled(false);
        int time = Integer.parseInt(enterTime.getText().toString());


         new CountDownTimer(time*1000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

                timeText.setText("Left: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time has done!");
                startButton.setEnabled(true);
                enterTime.setEnabled(true);
                score = 0;
                aktif = 0;



            }

        }.start();


    }



}


