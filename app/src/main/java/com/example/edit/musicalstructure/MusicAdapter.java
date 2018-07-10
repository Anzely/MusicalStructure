package com.example.edit.musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Edit on 2018. 03. 29..
 */

public class MusicAdapter extends ArrayAdapter<Music> {

    public MusicAdapter(Activity context, ArrayList<Music> music) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, music);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link currentMusic} object located at this position in the list
        Music currentMusic= getItem(position);

        // Find the TextView in the list_item.xml layout
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_text_view);
        // Get the Album name
        // set this text on the TextView
        albumTextView.setText(currentMusic.getAlbum());

        // Find the TextView in the list_item.xml layout
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        // Get the Author
        // set this text on the TextView
        defaultTextView.setText(currentMusic.getAutor());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.imageIcon);
        // Get the image resource ID
        // set the image to iconView
        int resID = iconView.getResources().getIdentifier(currentMusic.getIcon(), "drawable", "com.example.edit.musicalstructure");
        iconView.setImageResource(resID);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}