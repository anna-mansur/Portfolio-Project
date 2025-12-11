import components.playlist.Playlist;
import components.playlist.PlaylistOnQueue;

/**
 * Demonstrates how Playlist component could be used within another component
 * like a music library.
 */
public class MusicLibrary {

    /**
     * Example Playlist.
     */
    private Playlist roadtrip;
    /**
     * Example Playlist.
     */
    private Playlist study;

    /**
     * Constructs a MusicLibrary with two example playlists.
     */
    public MusicLibrary() {

        this.roadtrip = new PlaylistOnQueue();
        this.study = new PlaylistOnQueue();

        this.roadtrip.addSong("White Iverson", "Post Malone");
        this.roadtrip.addSong("Paper Planes", "M.I.A.");

        this.study.addSong("Moonlight on the River", "Mac DeMarco");
        this.study.addSong("Nangs", "Tame Impala");
    }

    /**
     * Prints all playlists in the library.
     */
    public void listLibrary() {

        System.out.println("Roadtrip Playlist: ");
        System.out.println(this.roadtrip.listAll());

        System.out.println("Study Playlist: ");
        System.out.println(this.study.listAll());
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        MusicLibrary name = new MusicLibrary();
        name.listLibrary();
    }

}
