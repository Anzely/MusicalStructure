package com.example.edit.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Edit on 2018. 04. 03..
 */

class FilmActivityAlbum  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the music_list.xml layout file
        setContentView(R.layout.music_list);

        //new ArrayList
        ArrayList<Music> music = new ArrayList<Music>();
        //add value in ArrayList
        for (int index = 1; index < 11; index++) {
            music.add(new Music("Film Author", "Sound" + index, "icon"));
        }
        final MusicAdapter adapter = new MusicAdapter(this, music);
        // Find the View that shows the pop music albums
        final ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        //default Author and Album display
        DisplayMusik(listView, 0);

        //Set a click listener on that View
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //selected Author and Album display
                DisplayMusik(listView, position);
            }
        });

        //Back MainActivity
        //Find back_button
        Button Back = (Button) findViewById(R.id.back_button);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link MainActivity}
                Intent back = new Intent(FilmActivityAlbum.this, MainActivity.class);
                // Start the activity
                startActivity(back);
            }
        });
        //play, stop, next, previous  Buttons call
        playButton();
        stopButton();
        next();
        previous();

        // Find the View that shows actual SeekBar value
        final TextView actualSeekBar = findViewById(R.id.seekbar_actual_value);
        SeekBar soundSeekBar = (SeekBar) findViewById(R.id.SeekBar_sound);
        // seek bar change listener event used for getting the progress value
        soundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public int progressChanged = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), " touch!!", Toast.LENGTH_SHORT).show();
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                //writing progresChange in textView
                actualSeekBar.setText(Integer.toString(progressChanged));
            }
        });
    }

    //previous button onclick event to write message
    private void previous() {
        ImageButton previousButton = (ImageButton) findViewById(R.id.previousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Previous", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //next button onclick event to write message
    private void next() {
        ImageButton nextButton = (ImageButton) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Next", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //play button onclick event to write message
    private void playButton() {
        ImageButton Play = (ImageButton) findViewById(R.id.playButton);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //stop button onclick event to write message
    private void stopButton() {
        ImageButton Stop = (ImageButton) findViewById(R.id.stopButton);
        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * @param listView //listView
     * @param position // position of listView
     */
    private void DisplayMusik(ListView listView, int position) {
        //listView item according to the position
        Music selectedMusic = (Music) listView.getAdapter().getItem(position);
        //Find the TextView that shows the Actuel Author
        TextView Author = (TextView) findViewById(R.id.Author_play);
        //write actual Author and Album
        Author.setText(selectedMusic.getAutor() + ": " + selectedMusic.getAlbum());
    }
}
