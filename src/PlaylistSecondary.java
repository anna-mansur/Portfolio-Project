import components.random.Random;
import components.random.Random1L;

/**
 * Layered implementations of secondary methods for {@code Playlist}.
 */
public abstract class PlaylistSecondary implements Playlist {

    /**
     * Reports the current {@code Song} at the front of {@code this}.
     *
     * @return the front {@code Song} of {@code this}
     * @aliases reference returned by {@code currentSong}
     * @requires {@code this /= <>}
     * @ensures {@code <currentSong> is prefix of this}
     */
    public Song currentSong() {
        assert this.totalSongs() > 0 : "Violation of: this /= <>";

        Song current = this.removeCurrentSong();
        this.addSong(current.title(), current.artist());

        for (int i = 1; i < this.totalSongs(); i++) {
            Song temp = this.removeCurrentSong();
            this.addSong(temp.title(), temp.artist());
        }
        return current;
    }

    /**
     * Reports the title of current(front) {@code Song} in {@code this}.
     *
     * @return the title of current {@code Song}
     * @requires {@code this /= <>}
     * @ensures currentTitle = this.currentSong().title()
     */
    public String currentTitle() {
        assert this.totalSongs() > 0 : "Violation of: this /= <>";

        Song current = this.currentSong();
        return current.title();
    }

    /**
     * Reports the artist of current(front) {@code Song} in {@code this}.
     *
     * @return the artist of current {@code Song}
     * @requires {@code this /= <>}
     * @ensures currentTitle = this.currentSong().artist()
     */
    public String currentArtist() {
        assert this.totalSongs() > 0 : "Violation of: this /= <>";

        Song current = this.currentSong();
        return current.artist();

    }

    /**
     * Removes {@code Song} at the front of {@code this} and adds it to the end.
     *
     * @updates this
     * @requires {@code this /= <>}
     * @ensures this = #this with front {@code Song} removed and added to end
     */
    public void skipSong() {
        assert this.totalSongs() > 0 : "Violation of: this /= <>";

        Song current = this.removeCurrentSong();
        this.addSong(current.title(), current.artist());
    }

    /**
     * Returns a list of titles and artists of all {@code Song} in {@code this}
     * with the format of "(title) by (arist)" each on a separate line.
     *
     * @return a {@code String} listing all song titles and their assocaited
     *         artists in {@code this}
     * @ensures list of all titles and associated artist of each {@code Song} in
     *          {@code this}
     */
    public String listAll() {

        return this.toString();
    }

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
    public boolean hasSong(String title, String artist) {
        assert title != null : "Violation of: title is not null";
        assert artist != null : "Violation of: artist is not null";

        boolean found = false;
        int totalSongs = this.totalSongs();

        for (int i = 0; i < totalSongs; i++) {
            Song curr = this.removeCurrentSong();
            if (curr.title().equals(title) && curr.artist().equals(artist)) {
                found = true;
            }
            this.addSong(curr.title(), curr.artist());
        }
        return found;
    }

    @Override
    public void shuffle() {

    }

    @Override
    public String toString() {

        StringBuilder listSongs = new StringBuilder();
        int totalSongs = this.totalSongs();

        for (int i = 0; i < totalSongs; i++) {
            Song curr = this.removeCurrentSong();
            listSongs.append(curr.title());
            listSongs.append(" by ");
            listSongs.append(curr.artist());
            listSongs.append("\n");
            this.addSong(curr.title(), curr.artist());
        }
        return listSongs.toString();
    }

    //add equals() method

}
