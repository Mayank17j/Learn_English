package com.example.language;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Find view that show no. category
        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView Colors = (TextView) findViewById(R.id.colors);
        TextView Family = (TextView) findViewById(R.id.family);
        TextView Phrases = (TextView) findViewById(R.id.phrases);

        //set onclickListeners
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numberIntent);
            }
        });
        Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ColorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(ColorsIntent);
            }
        });
        Family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent FamilyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(FamilyIntent);
            }
        });
        Phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Phrases",Toast.LENGTH_SHORT).show();
                Intent PhrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(PhrasesIntent);
            }
        });
    }

}
