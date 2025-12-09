package components.playlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Playlist}'s secondary methods.
 *
 * @author Anna Mansur
 *
 */
public class PlaylistTest {

    /**
     * Useful constant, not a magic number: 3.
     */
    private static final int THREE = 3;

    /**
     * Test currentSong with two songs.
     */
    @Test
    public void testCurrentSong() {

        Playlist x = new PlaylistOnQueue();
        Playlist y = new PlaylistOnQueue();
        x.addSong("Impossible", "Travis Scott");
        x.addSong("Tried Our Best", "Drake");
        y.addSong("Impossible", "Travis Scott");
        y.addSong("Tried Our Best", "Drake");
        Playlist.Song current = x.currentSong();

        assertEquals("Impossible", current.title());
        assertEquals("Travis Scott", current.artist());
        assertEquals(x, y);
    }

    /**
     * Test currentTitle with two songs.
     */
    @Test
    public void testCurrentTitle() {

        Playlist x = new PlaylistOnQueue();
        Playlist expected = new PlaylistOnQueue();
        x.addSong("Impossible", "Travis Scott");
        x.addSong("Tried Our Best", "Drake");
        expected.addSong("Impossible", "Travis Scott");
        expected.addSong("Tried Our Best", "Drake");

        assertEquals("Impossible", x.currentTitle());
        assertEquals(x, expected);
    }

    /**
     * Test currentArtist with two songs.
     */
    @Test
    public void testCurrentArtist() {

        Playlist x = new PlaylistOnQueue();
        Playlist expected = new PlaylistOnQueue();
        x.addSong("Impossible", "Travis Scott");
        x.addSong("Tried Our Best", "Drake");
        expected.addSong("Impossible", "Travis Scott");
        expected.addSong("Tried Our Best", "Drake");

        assertEquals("Travis Scott", x.currentArtist());
        assertEquals(x, expected);
    }

    /**
     * Test skipSong with three songs.
     */
    @Test
    public void testSkipSong() {

        Playlist x = new PlaylistOnQueue();
        Playlist expected = new PlaylistOnQueue();
        x.addSong("Ghosting", "Mother Mother");
        x.addSong("Skyline To", "Frank Ocean");
        x.addSong("holyland", "wave to earth");
        expected.addSong("Skyline To", "Frank Ocean");
        expected.addSong("holyland", "wave to earth");
        expected.addSong("Ghosting", "Mother Mother");
        x.skipSong();

        assertEquals(x, expected);
    }

    /**
     * Test listAll method with three songs.
     */
    @Test
    public void testListAll() {

        Playlist x = new PlaylistOnQueue();
        Playlist expected = new PlaylistOnQueue();
        x.addSong("Ghosting", "Mother Mother");
        x.addSong("Skyline To", "Frank Ocean");
        x.addSong("holyland", "wave to earth");
        expected.addSong("Ghosting", "Mother Mother");
        expected.addSong("Skyline To", "Frank Ocean");
        expected.addSong("holyland", "wave to earth");
        String expectedX = "Ghosting by Mother Mother\n"
                + "Skyline To by Frank Ocean\n" + "holyland by wave to earth\n";

        assertEquals(expectedX, x.listAll());
        assertEquals(x, expected);
    }

    /**
     * Test hasSong with two songs.
     */
    @Test
    public void testHasSongTrue() {

        Playlist x = new PlaylistOnQueue();
        Playlist expected = new PlaylistOnQueue();
        x.addSong("Skyline To", "Frank Ocean");
        x.addSong("holyland", "wave to earth");
        expected.addSong("Skyline To", "Frank Ocean");
        expected.addSong("holyland", "wave to earth");

        assertTrue(x.hasSong("holyland", "wave to earth"));
        assertEquals(x, expected);
    }

    /**
     * Test hasSong with two songs.
     */
    @Test
    public void testHasSongFalse() {

        Playlist x = new PlaylistOnQueue();
        Playlist expected = new PlaylistOnQueue();
        x.addSong("Skyline To", "Frank Ocean");
        x.addSong("holyland", "wave to earth");
        expected.addSong("Skyline To", "Frank Ocean");
        expected.addSong("holyland", "wave to earth");

        assertFalse(x.hasSong("Ghosting", "Mother Mother"));
        assertEquals(x, expected);
    }

    /**
     * Test shuffle method with three songs.
     */
    @Test
    public void testShuffle() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Ghosting", "Mother Mother");
        x.addSong("Skyline To", "Frank Ocean");
        x.addSong("holyland", "wave to earth");
        x.shuffle();

        assertEquals(THREE, x.totalSongs());

        assertTrue(x.hasSong("Ghosting", "Mother Mother"));
        assertTrue(x.hasSong("Skyline To", "Frank Ocean"));
        assertTrue(x.hasSong("holyland", "wave to earth"));
    }

    /**
     * Test toString method with three songs.
     */
    @Test
    public void testToString() {

        Playlist x = new PlaylistOnQueue();
        Playlist expected = new PlaylistOnQueue();
        x.addSong("Ghosting", "Mother Mother");
        x.addSong("Skyline To", "Frank Ocean");
        x.addSong("holyland", "wave to earth");
        expected.addSong("Ghosting", "Mother Mother");
        expected.addSong("Skyline To", "Frank Ocean");
        expected.addSong("holyland", "wave to earth");
        String expectedX = "Ghosting by Mother Mother\n"
                + "Skyline To by Frank Ocean\n" + "holyland by wave to earth\n";

        assertEquals(expectedX, x.toString());
        assertEquals(x, expected);
    }

    /**
     * Test equals method when it is true.
     */
    @Test
    public void testEqualsTrue() {
        Playlist x = new PlaylistOnQueue();
        Playlist y = new PlaylistOnQueue();
        x.addSong("Impossible", "Travis Scott");
        x.addSong("Tried Our Best", "Drake");
        x.addSong("Grey", "Travis Scott");
        y.addSong("Impossible", "Travis Scott");
        y.addSong("Tried Our Best", "Drake");
        y.addSong("Grey", "Travis Scott");

        assertTrue(x.equals(y));

    }

    /**
     * Test equals method when it is False.
     */
    @Test
    public void testEqualsFalse() {
        Playlist x = new PlaylistOnQueue();
        Playlist y = new PlaylistOnQueue();
        x.addSong("Impossible", "Travis Scott");
        x.addSong("Tried Our Best", "Drake");
        x.addSong("Grey", "Travis Scott");
        y.addSong("Impossible", "Travis Scott");
        y.addSong("Tried Our Best", "Drake");

        assertFalse(x.equals(y));
    }

    /**
     * Test hashCode method with equal playlists.
     */
    @Test
    public void testHashCode() {
        Playlist x = new PlaylistOnQueue();
        Playlist y = new PlaylistOnQueue();
        x.addSong("Impossible", "Travis Scott");
        x.addSong("Tried Our Best", "Drake");
        x.addSong("Grey", "Travis Scott");
        y.addSong("Impossible", "Travis Scott");
        y.addSong("Tried Our Best", "Drake");
        y.addSong("Grey", "Travis Scott");

        assertEquals(x.hashCode(), y.hashCode());

    }
}
