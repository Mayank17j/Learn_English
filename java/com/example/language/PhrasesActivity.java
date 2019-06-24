package com.example.language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words=new ArrayList<Word>();

        words.add(new Word("Where are you going","kaha ja rahe ho"));
        words.add(new Word("What is your name","tumhara kya name hai"));
        words.add(new Word("Come in","andar aoo"));
        words.add(new Word("How are you feeling","tum kaisa mahasus karte ho"));
        words.add(new Word("Are you coming?","kya tum a rehe ho"));
        words.add(new Word("Yes! I am coming","ha mai a raha hu"));
        words.add(new Word("Let's go","chalte hai"));
        words.add(new Word("Come here","yaha aoo"));

        WordAdapter adapter=new WordAdapter(this,words,R.color.category_phrases);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(PhrasesActivity.this,"Clicked",Toast.LENGTH_SHORT).show();

            }

        });


    }
}
