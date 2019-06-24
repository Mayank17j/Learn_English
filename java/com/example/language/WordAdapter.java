package com.example.language;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    //for activity background color
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId) {
        super(context,0, words);
        mColorResourceId=colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get object located in this position in the list
        Word currentWord=getItem(position);

        //check if existing view is being reused, otherwise inflate the view
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,null,false);
        }

        //Find TextView in list_item.xml layout with id
        TextView defaultTextView=(TextView)listItemView.findViewById(R.id.default_text_view);
        //get id from current Word obj and set this content
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //Find TextView in list_item.xml layout with id
        TextView hindiTextView=(TextView)listItemView.findViewById(R.id.hindi_text_view);
        //get id from current Word obj and set this content
        hindiTextView.setText(currentWord.getHindiTranslation());


        ImageView imageView=(ImageView)listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            //optional
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            //image gone
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the item list
        View textContainer=listItemView.findViewById(R.id.text_container);
        //find the mapped color resource id
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        //set background color of text container
        textContainer.setBackgroundColor(color);

        //Set the theme color for the item list
//        View buttonContainer=listItemView.findViewById(R.id.imageButtonPlay);
        //find the mapped color resource id
 //       int bcolor= ContextCompat.getColor(getContext(),mColorResourceId);
        //set background color of text container
//        buttonContainer.setBackgroundColor(bcolor);

        //return the whole list item layout
        return listItemView;
    }
}
