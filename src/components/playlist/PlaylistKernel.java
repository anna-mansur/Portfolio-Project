package components.playlist;

import components.standard.Standard;

/**
 * Playlist kernel component with primary methods.
 */
public interface PlaylistKernel extends Standard<Playlist> {

    /**
     * Song object representing a single song with title and artist.
     *
     * @param title
     *            {@code String} title of song to be added
     * @param artist
     *            {@code String} artist of song to be added
     */
    public static record Song(String title, String artist) {
    }

    /**
     * Adds {@code Song} object consisting of given {@code title} and
     * {@code artist} to the end of {@code this}.
     *
     * @param title
     *            {@code String} title of song to be added
     *
     * @param artist
     *            {@code String} artist of song to be added
     * @updates this
     * @requires {@code title} and {@code artist} are not null
     * @ensures {@code this = #this * <Song(title, artist)>}
     */
    void addSong(String title, String artist);

    /**
     * Removes and returns {@code Song} at front of {@code this}.
     *
     * @return the removed {@code Song}
     * @updates this
     * @requires {@code this /= <>}
     * @ensures {@code #this = <removeCurrentSong> * this}
     */
    Playlist.Song removeCurrentSong();

    /**
     * Counts the total number of {@code Song} in {@code this}.
     *
     * @return total number of songs
     * @ensures totalSongs = |this|
     */
    int totalSongs();

    /**
     * Reports whether {@code this} is empty.
     *
     * @return true iff {@code this} is empty
     * @ensures isEmpty = (|this| = 0)
     */
    boolean isEmpty();

}
