
/**
 * {@code PlaylistKernel} enhanced with secondary methods.
 */
public interface Playlist extends PlaylistKernel {

    /**
     * Reports the current {@code Song} at the front of {@code this}.
     *
     * @return the front {@code Song} of {@code this}
     * @aliases reference returned by {@code currentSong}
     * @requires {@code this /= <>}
     * @ensures {@code <currentSong> is prefix of this}
     */
    Song currentSong();

    /**
     * Reports the title of current(front) {@code Song} in {@code this}.
     *
     * @return the title of current {@code Song}
     * @requires {@code this /= <>}
     * @ensures currentTitle = this.currentSong().title()
     */
    String currentTitle();

    /**
     * Reports the artist of current(front) {@code Song} in {@code this}.
     *
     * @return the artist of current {@code Song}
     * @requires {@code this /= <>}
     * @ensures currentTitle = this.currentSong().artist()
     */
    String currentArtist();

    /**
     * Removes {@code Song} at the front of {@code this} and adds it to the end.
     *
     * @updates this
     * @requires {@code this /= <>}
     * @ensures this = #this with front {@code Song} removed and added to end
     */
    void skipSong();

    /**
     * Returns a list of titles and artists of all {@code Song} in {@code this}
     * with the format of "(title) by (arist)" each on a separate line.
     *
     * @return a {@code String} listing all song titles and their assocaited
     *         artists in {@code this}
     * @ensures list of all titles and associated artist of each {@code Song} in
     *          {@code this}
     */
    String listAll();

    /**
     * Reports whether {@code Song} with given artist and title is in
     * {@code this}.
     *
     * @param title
     *            {@code String} title of song
     * @param artist
     *            {@code String} artist of song
     * @return true iff {@code this} contains {@code Song} with given
     *         {@code title} and {@code artist}
     * @requires {@code title} and {@code artist} are not null
     * @ensures hasSong = true if a {@code Song} with given {@code title} and
     *          {@code artist} exists in {@code this}, false otherwise
     */
    boolean hasSong(String title, String artist);

    /**
     * Reorders all of the {@code Song} in {@code this}.
     *
     * @updates this
     * @ensures |this| = |#this| and this is a permutation of #this
     */
    void shuffle();

}
