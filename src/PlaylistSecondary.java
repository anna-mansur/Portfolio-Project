import components.random.Random;
import components.random.Random1L;

/**
 * Layered implementations of secondary methods for {@code Playlist}.
 */
public abstract class PlaylistSecondary implements Playlist {

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
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

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String currentTitle() {
        assert this.totalSongs() > 0 : "Violation of: this /= <>";

        Song current = this.currentSong();
        return current.title();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String currentArtist() {
        assert this.totalSongs() > 0 : "Violation of: this /= <>";

        Song current = this.currentSong();
        return current.artist();

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void skipSong() {
        assert this.totalSongs() > 0 : "Violation of: this /= <>";

        Song current = this.removeCurrentSong();
        this.addSong(current.title(), current.artist());
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String listAll() {

        return this.toString();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
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

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void shuffle() {

        int total = this.totalSongs();
        Song[] songs = new Song[total];
        Random shuffle = new Random1L();

        for (int i = 0; i < total; i++) {
            songs[i] = this.removeCurrentSong();
        }

        for (int i = 0; i < total; i++) {
            int random = Math.abs(shuffle.nextInt()) % total;
            Song temp = songs[i];
            songs[i] = songs[random];
            songs[random] = temp;
        }

        for (int i = 0; i < total; i++) {
            this.addSong(songs[i].title(), songs[i].artist());
        }

    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
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

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object playlist) {

        if (playlist == this) {
            return true;
        }
        if (playlist == null) {
            return false;
        }
        boolean result = false;
        if (playlist instanceof Playlist test) {
            if (this.totalSongs() == test.totalSongs()) {
                result = true;
                int total = this.totalSongs();

                for (int i = 0; i < total; i++) {
                    Song one = this.removeCurrentSong();
                    Song two = test.removeCurrentSong();

                    if (!one.equals(two)) {
                        result = false;
                    }
                    this.addSong(one.title(), one.artist());
                    test.addSong(two.title(), two.artist());
                }
            }
        }
        return result;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {

        int total = this.totalSongs();
        int hash = 0;

        for (int i = 0; i < total; i++) {
            Song curr = this.removeCurrentSong();
            hash = 31 * hash + curr.hashCode();
            this.addSong(curr.title(), curr.artist());
        }
        return hash;
    }

}
