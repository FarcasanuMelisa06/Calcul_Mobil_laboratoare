package com.example.tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btn_add, btn_delete;
    EditText textName;

    String[] name = new String[] {
            "Maria Moldovan",
            "Paul Pop",
            "Ioana Zah",
            "Alina Popescu",
            "Ioan Maries",
            "Alex Iuliu",
            "Andreea Pop",
            "Alexia Miruna",
            "Raul Zah",
            "Ioana Popescu"
    };
    int images[] = {R.drawable.baiat};

     ArrayList<String> name_list = new ArrayList<String>(Arrays.asList(name));
          ArrayAdapter arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        textName = findViewById(R.id.textViewName);

         arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, name_list);

        listView.setAdapter(arrayAdapter);

    }

    public void onClickAdd(View view) {

        String nameVal = textName.getText().toString();
        name_list.add(nameVal);
        arrayAdapter.notifyDataSetChanged();
        textName.setText("");
    }

    public void onClickDelete(View view) {
        name_list.remove(name_list.size() - 1);
        arrayAdapter.notifyDataSetChanged();
    }
}