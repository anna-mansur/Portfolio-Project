import components.playlist.Playlist;
import components.playlist.PlaylistOnQueue;

/**
 * Main method that demonstrates how to create and use {@code Playlist}
 * component.
 */
public final class PlaylistDemo {

    /**
     * Private constructor to prevent instantiation.
     */
    private PlaylistDemo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        /*
         * Adds songs to playlist
         */
        Playlist x = new PlaylistOnQueue();
        x.addSong("first take", "Travis Scott");
        x.addSong("RUNITUP", "Tyler, The Creator");
        x.addSong("You're Lost", "Lil Uzi Vert");

        /*
         * Lists songs in playlist
         */
        System.out.println("Playlist contents: ");
        System.out.println(x.listAll());

        /*
         * Reports the current song
         */
        System.out.println("Current song: " + x.currentTitle() + " by "
                + x.currentArtist());

        /*
         * Skips the current song
         */
        x.skipSong();
        System.out.println("Skip current song.");
        System.out.println("Now playing: " + x.currentSong());

        /*
         * Checks if playlist contains a certain song
         */
        System.out.println("\nContains 'first take' by Travis Scott?");
        System.out.println(x.hasSong("first take", "Travis Scott"));

        /*
         * Shuffles playlist
         */
        x.shuffle();
        System.out.println("\nShuffled playlist: ");
        System.out.println(x.toString());

        /*
         * Lists total number of songs
         */
        System.out.println("Song count: " + x.totalSongs());

        /*
         * Removes current song from playlist
         */
        x.removeCurrentSong();
        System.out.println("Removed current song.");
        System.out.println("New song count: " + x.totalSongs());

    }

}
