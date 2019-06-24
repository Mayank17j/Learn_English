package com.example.language;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words=new ArrayList<Word>();
        //word.add("zero");
        //      OR
        //word w=new Words("one","Ek");
        //word.add(w);
        //      OR

        words.add(new Word("red","laal",R.drawable.color_red));
        words.add(new Word("black","kaala",R.drawable.color_black));
        words.add(new Word("green","hara",R.drawable.color_green));
        words.add(new Word("brown","bhuura",R.drawable.color_brown));
        words.add(new Word("white","safed",R.drawable.color_white));
//        words.add(new Word("orange","narangi"));
//        words.add(new Word("pink","gulabi"));
//        words.add(new Word("black","kala"));
//        words.add(new Word("blue","neela"));
//        words.add(new Word("safron","geruva"));

        WordAdapter adapter=new WordAdapter(this,words,R.color.category_colors);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ColorsActivity.this,"Clicked",Toast.LENGTH_SHORT).show();

            }

        });



    }
}
