package com.example.language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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

        words.add(new Word("father","pita",R.drawable.family_father));
        words.add(new Word("mother","mata",R.drawable.family_mother));
        words.add(new Word("son","beta",R.drawable.family_son));
        words.add(new Word("daughter","beti",R.drawable.family_daughter));
        words.add(new Word("younger sister","chhoti bhai",R.drawable.family_younger_sister));
        words.add(new Word("younger brother","chota bhai",R.drawable.family_younger_brother));
        words.add(new Word("old brother","bada bhai",R.drawable.family_older_brother));
        words.add(new Word("old sister","badi bahen",R.drawable.family_older_sister));

        WordAdapter adapter=new WordAdapter(this,words,R.color.category_family);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(FamilyActivity.this,"Clicked",Toast.LENGTH_SHORT).show();

            }

        });



    }
}
