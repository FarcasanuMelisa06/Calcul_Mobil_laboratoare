package com.example.lab3_tema;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        details = findViewById(R.id.act2Details);
        int itemId = getIntent().getIntExtra("itemId", 1);

        //in functie de id
        //afisam in activitatea 2, detalii despre fiecare imagine in parte
        switch (itemId) {
            case 1: setText("The cat is a domestic species of small carnivorous mammal." +
                    " It is the only domesticated species in the family Felidae " +
                    "and is commonly referred to as the domestic cat or house cat to distinguish it from the wild members of the family." +
                    " A cat can either be a house cat, a farm cat, or a feral cat; the latter ranges freely and avoids human contact." +
                    "Domestic cats are valued by humans for companionship and their ability to kill rodents. " +
                    "About 60 cat breeds are recognized by various cat registries."); break;

            case 2: setText("The dog is a pet animal. " +
                    "A dog has sharp teeth so that it can eat flesh very easily, it has four legs, two ears, two eyes, a tail, a mouth, and a nose. " +
                    "It is a very clever animal and is very useful in catching thieves. " +
                    "It runs very fast, barks loudly and attacks the strangers."); break;

            case 3: setText("A flower is the reproductive unit of an angiosperm plant. " +
                    "There is an enormous variety of flowers, but all have some characteristics in common. " +
                    "The definitive characteristic of the angiosperms is the enclosed ovary, which contains and protects the developing seeds."); break;

            case 4: setText("Most ants are either red or black in color and length can be anywhere from 1/3 to 1/2." +
                    " Like other insects, they have six legs; each with three joints. " +
                    "Ants have large heads with compound eyes, elbowed antennae, and powerful jaws."); break;

            case 5:  setText("Like all insects, a bee's body is divided into three parts: a head with two antennae, a thorax with six legs, and an abdomen. " +
                    "All bees have branched hairs somewhere on their bodies and two pairs of wings. " +
                    "Only female bees have stingers (which are modified ovipositors, organs originally used to lay eggs)."); break;
        }
    }

    private void setText(String text) {
        details.setText(text);
    }

    public void onClickAct1(View view){
        Intent intent_back = new Intent(this, MainActivity.class);
        startActivity(intent_back);
    }
}