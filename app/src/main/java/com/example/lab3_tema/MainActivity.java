package com.example.lab3_tema;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    int itemId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);
    }

    public void onClickNext(View view) {
        //daca ajunge la maxim
        if (itemId >= 5) {
            //id-ul devine minim
            itemId = 1;
            //altfel creste
        } else {
            itemId += 1;
        }
        setImage();
    }

    public void onClickBack(View view) {
        //daca ajungem la minim
        if (itemId <= 1) {
            //id-ul devine maxim
            itemId = 5;
            //altfel scade
        } else {
            itemId -= 1;
        }
        setImage();
    }

    //functia pentru cele 4 imagini
    //fiecare imagine are un id
    //in functie de id se vor afisa pe rand imaginile
    private void setImage() {
        if (itemId == 1) {
            image.setImageResource(R.drawable.cat);
        } else if (itemId == 4) {
            image.setImageResource(R.drawable.ant);
        } else if (itemId == 3) {
            image.setImageResource(R.drawable.flower);
        } else if (itemId == 2) {
            image.setImageResource(R.drawable.dog);
        } else if (itemId == 5) {
            image.setImageResource(R.drawable.bee);
        }
    }


    public void onClickDetails(View view) {
        Intent intent_details = new Intent(this, MainActivity2.class);
        intent_details.putExtra("itemId", itemId);
        startActivity(intent_details);
    }
}
