import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Implementing playlist methods to show proof of concept.
 *
 * @author Anna Mansur
 */
public class Playlist {

    /**
     * Queue of songs representing {@code Playlist}.
     */
    private Queue<Playlist.Pair<String, String>> songs;

    /**
     * No-Argument Constructor.
     */
    public Playlist() {
        this.songs = new Queue1L<Playlist.Pair<String, String>>();
    }

    /**
     * Added this for now because I could not get SimplePair to work since I'm
     * not using Map.
     *
     * @param <K>
     *            name of song
     * @param <V>
     *            artist of song
     */
    private static class Pair<K, V> {
        private final K name;
        private final V artist;

        Pair(K name, V artist) {
            this.name = name;
            this.artist = artist;
        }

        public K name() {
            return this.name;
        }

        public V artist() {
            return this.artist;
        }

        @Override
        public String toString() {
            return "\"" + this.name + "\" by " + this.artist;
        }
    }

    /**
     * Adds input title and artist as pair in playlist.
     */
    public final void addSong(String title, String artist) {

        this.songs.enqueue(new Pair<String, String>(title, artist));
    }

    /**
     * Removes and returns song at front of playlist.
     *
     * @return pair of song/artist at front
     */
    public final Playlist.Pair<String, String> removeSong() {
        return this.songs.dequeue();
    }

    /**
     * Reports if playlist is empty.
     *
     * @return true/false
     */
    public final boolean isEmpty() {
        return this.songs.length() == 0;
    }

    /**
     * Reports total number of songs.
     *
     * @return total number of songs
     */
    public final int playlistSize() {
        return this.songs.length();
    }

    /**
     * Reports current song.
     *
     * @return current song/artist pair
     */
    public Playlist.Pair<String, String> currentSong() {
        return this.songs.front();
    }

    /**
     * Skips current song.
     */
    public void skip() {
        if (!this.isEmpty()) {
            Pair<String, String> current = this.removeSong();
            this.addSong(current.name(), current.artist());
        }
    }

    /**
     * Clears playlist.
     */
    public void clear() {
        while (!this.isEmpty()) {
            this.removeSong();
        }
    }

    /**
     * Lists songs in playlist.
     */
    public void listAll() {
        if (this.isEmpty()) {
            System.out.println("No songs to play.");
        } else {
            int size = this.playlistSize();
            for (int i = 0; i < size; i++) {
                Pair<String, String> song = this.removeSong();
                System.out.println(song);
                this.addSong(song.name(), song.artist());
            }
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Playlist newPlaylist = new Playlist();

        newPlaylist.addSong("Skyline To", "Frank Ocean");
        newPlaylist.addSong("Not PLaying", "Playboi Carti");
        newPlaylist.addSong("Image", "Magdalena Bay");

        System.out.println("Total songs: " + newPlaylist.playlistSize());
        System.out.println("Now playing: " + newPlaylist.currentSong());
        newPlaylist.skip();
        System.out.println("Now playing: " + newPlaylist.currentSong());

        System.out.println("Removed: " + newPlaylist.removeSong());
        System.out.println("Song list:");
        newPlaylist.listAll();
        newPlaylist.clear();
        System.out.println("Song list:");
        newPlaylist.listAll();
    }

}
