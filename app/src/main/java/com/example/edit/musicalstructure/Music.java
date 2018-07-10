package com.example.edit.musicalstructure;

/**
 * Created by Edit on 2018. 03. 29..
 */

/**
 * {@link Music} represents a album that the user wants to choose.
 */
public class Music {

    /**
     * Autor for the music
     */
    private String mAutor;

    /**
     * Album for the music
     */
    private String mAlbum;

    /**
     * Icon for the music
     */
    private String mIcon;

    /**
     * Create a new Music object.
     *
     * @param autor    is the music
     * @param album    is the music
     * @param iconName is the music
     */
    public Music(String autor, String album, String iconName) {
        mAutor = autor;
        mAlbum = album;
        mIcon = iconName;
    }

    /**
     * Get the auctor of the music.
     */
    public String getAutor() {
        return mAutor;
    }

    /**
     * Get the album of the music.
     */
    public String getAlbum() {
        return mAlbum;
    }

    /**
     * Get the icon of the music.
     */
    public String getIcon() {
        return mIcon;
    }
}
