package components.playlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Playlist}'s constructors and kernel methods.
 *
 * @author Anna Mansur
 *
 */
public class PlaylistOnQueueTest {

    /**
     * Test constructor with no arguments.
     */
    @Test
    public void testNoArgumentConstructor() {

        Playlist x = new PlaylistOnQueue();

        assertTrue(x.isEmpty());
        assertEquals(0, x.totalSongs());
    }

    /**
     * Test clear method with two songs.
     */
    @Test
    public void testClear() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Not You Too", "Drake");
        x.addSong("Backyard", "Travis Scott");
        x.clear();

        assertTrue(x.isEmpty());
        assertEquals(0, x.totalSongs());
    }

    /**
     * Test clear method with empty playlist.
     */
    @Test
    public void testClearEmpty() {

        Playlist x = new PlaylistOnQueue();
        x.clear();

        assertTrue(x.isEmpty());
        assertEquals(0, x.totalSongs());
    }

    /**
     * Test transferFrom with one song.
     */
    @Test
    public void testTransferFrom1() {

        Playlist x = new PlaylistOnQueue();
        Playlist y = new PlaylistOnQueue();
        x.addSong("Right Now", "Playboi Carti");
        y.transferFrom(x);

        assertEquals(1, y.totalSongs());
        assertEquals(0, x.totalSongs());
    }

    /**
     * Test transferFrom with two songs.
     */
    @Test
    public void testTransferFrom2() {

        Playlist x = new PlaylistOnQueue();
        Playlist y = new PlaylistOnQueue();
        x.addSong("Strings", "Young the Giant");
        x.addSong("Sandman", "A$AP Rocky");
        y.transferFrom(x);

        assertEquals(2, y.totalSongs());
        assertEquals(0, x.totalSongs());
    }

    /**
     * Test of newInstance.
     */
    @Test
    public void testNewInstance() {

        Playlist x = new PlaylistOnQueue();
        Playlist y = x.newInstance();

        assertTrue(y instanceof PlaylistOnQueue);
        assertEquals(0, y.totalSongs());
    }

    /**
     * Test of addSong with one song.
     */
    @Test
    public void testAddSong1() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Surf", "Young Thug");

        assertEquals(1, x.totalSongs());
    }

    /**
     * Test of addSong with two songs.
     */
    @Test
    public void testAddSong2() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Magic I Want U", "Jane Remover");
        x.addSong("How To Teleport", "Jane Remover");

        assertEquals(2, x.totalSongs());
    }

    /**
     * Test of addSong with duplicate song.
     */
    @Test
    public void testAddSongSame() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Love/Paranoia", "Tame Impala");
        x.addSong("Love/Paranoia", "Tame Impala");

        assertEquals(2, x.totalSongs());
    }

    /**
     * Test of removeCurrentSong with one song.
     */
    @Test
    public void testRemoveCurrentSong1() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Killing Time", "Magdalena Bay");
        Playlist.Song removed = x.removeCurrentSong();

        assertEquals("Killing Time", removed.title());
        assertEquals("Magdalena Bay", removed.artist());
        assertTrue(x.isEmpty());
    }

    /**
     * Test of removeCurrentSong with two songs.
     */
    @Test
    public void testRemoveCurrentSong2() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Moment", "Not for Radio");
        x.addSong("My Turn", "Not for Radio");
        Playlist.Song removed = x.removeCurrentSong();

        assertEquals("Moment", removed.title());
        assertEquals("Not for Radio", removed.artist());
        assertEquals(1, x.totalSongs());
    }

    /**
     * Test of removeCurrentSong with two songs and checks order of removal.
     */
    @Test
    public void testRemoveCurrentSongsInOrder() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Moment", "Not for Radio");
        x.addSong("My Turn", "Not for Radio");
        Playlist.Song removed1 = x.removeCurrentSong();
        Playlist.Song removed2 = x.removeCurrentSong();

        assertEquals("Moment", removed1.title());
        assertEquals("My Turn", removed2.title());
        assertTrue(x.isEmpty());
    }

    /**
     * Test of totalSongs with empty playlist.
     */
    @Test
    public void testTotalSongs() {

        Playlist x = new PlaylistOnQueue();

        assertEquals(0, x.totalSongs());
        assertTrue(x.isEmpty());
    }

    /**
     * Test of totalSongs with two songs.
     */
    @Test
    public void testTotalSongs2() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("Wishes", "Beach House");
        x.addSong("Myth", "Beach House");

        assertEquals(2, x.totalSongs());
    }

    /**
     * Test of isEmpty with empty playlist.
     */
    @Test
    public void testIsEmptyTrue() {

        Playlist x = new PlaylistOnQueue();

        assertEquals(0, x.totalSongs());
        assertTrue(x.isEmpty());
    }

    /**
     * Test of isEmpty with non-empty playlist.
     */
    @Test
    public void testIsEmptyFalse() {

        Playlist x = new PlaylistOnQueue();
        x.addSong("lie", "2hollis");

        assertEquals(1, x.totalSongs());
        assertFalse(x.isEmpty());
    }

}
