package com.example.language;
//demo
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NumbersActivity extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                        focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);//start from starting(0) in refocus on media player
                        // Permanent loss of audio focus
                        // Pause playback immediately
                    //    mediaController.getTransportControls().pause();
                        // Wait 30 seconds before stopping playback
                    //    handler.postDelayed(delayedStopRunnable,
                     //           TimeUnit.SECONDS.toMillis(30));
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Pause playback
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                         mMediaPlayer.start();
                    }
                }
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);


        final ArrayList<Word> words=new ArrayList<Word>();
        //word.add("one");
        //      OR
        //word w=new Words("one","Ek");
        //word.add(w);
        //      OR

        words.add(new Word("zero","sunny",R.drawable.zero_foreground,R.raw.number_zero));
        words.add(new Word("one","ek",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","do",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","teen",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","char",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","panch",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","chay",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","saat",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","aath",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","nav",R.drawable.number_nine,R.raw.number_nine));

        WordAdapter adapter=new WordAdapter(this,words,R.color.category_numbers);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                //Toast.makeText(NumbersActivity.this,"Toast",Toast.LENGTH_SHORT).show();

                //before use of release media player resource
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                  //  mAudioManager.unregisterMediaButtonEventReceiver(mOnAudioFocusChangeListener);
                    // Start playback, audio focus


                    //release the media player resource if user clicked in next media file
                    //it stopped the media player, release resource and start new medial player if clicked
                    releaseMediaPlayer();

                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                    //mMediaPlayer=MediaPlayer.create(NumbersActivity.this,R.raw.number_one);
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }

        });

    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    //clean up the media player by releasing its resource
    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null){ //currently playing
            //than release it
            mMediaPlayer.release();
            mMediaPlayer=null;

            //also abandon media focus here
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

        }
    }

}
