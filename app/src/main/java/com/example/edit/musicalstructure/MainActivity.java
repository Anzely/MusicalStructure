package com.example.edit.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the HipHop Music
        ImageView hiphop = (ImageView) findViewById(R.id.imageViewHipHop);

        hiphop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link HipHopActivityAlbum}
                Intent hiphopIntent = new Intent(MainActivity.this, HipHopActivityAlbum.class);
                // Start the new activity
                startActivity(hiphopIntent);
            }
        });

        // Find the View that shows the Pop Music
        ImageView pop = (ImageView) findViewById(R.id.imageViewPop);
        pop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link PopActivity}
                Intent popIntent = new Intent(MainActivity.this, PopActivityAlbum.class);
                // Start the new activity
                startActivity(popIntent);
            }
        });

        // Find the View that shows the Film Music
        ImageView film = (ImageView) findViewById(R.id.imageViewFilm);
        film.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link FilmActivityAlbum}
                Intent filmIntent = new Intent(MainActivity.this, FilmActivityAlbum.class);
                // Start the new activity
                startActivity(filmIntent);
            }
        });

        // Find the View that shows the Rock Music
        ImageView rock = (ImageView) findViewById(R.id.imageViewRock);
        rock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create a new intent to open the {@link RockActivityAlbum}
                Intent rockIntent = new Intent(MainActivity.this, RockActivityAlbum.class);
                // Start the new activity
                startActivity(rockIntent);
            }
        });
    }
}


