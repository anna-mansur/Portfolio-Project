package components.playlist;

import components.queue.Queue;
import components.queue.Queue1L;

/**
 * {@code Playlist} represented as {@code Queue} of {@code Song} with
 * implementations of primary methods.
 *
 * @convention $this.rep /= null
 * @correspondence this = entries($this.rep)
 */
public class PlaylistOnQueue extends PlaylistSecondary {

    /**
     * Songs included in {@code this}.
     */
    private Queue<Playlist.Song> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Queue1L<Playlist.Song>();
    }

    /**
     * No-argument constructor.
     */
    public PlaylistOnQueue() {
        this.createNewRep();
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final Playlist newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void transferFrom(Playlist source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof PlaylistOnQueue : ""
                + "Violation of: source is of dynamic type PlaylistOnQueue<?>";

        PlaylistOnQueue localSource = (PlaylistOnQueue) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    @Override
    public final void addSong(String title, String artist) {

        Playlist.Song x = new Playlist.Song(title, artist);
        this.rep.enqueue(x);
    }

    @Override
    public final Playlist.Song removeCurrentSong() {
        assert this.rep.length() > 0 : "Violation of: this /= <>";

        return this.rep.dequeue();
    }

    @Override
    public final int totalSongs() {
        return this.rep.length();
    }

    @Override
    public final boolean isEmpty() {
        return this.rep.length() == 0;
    }

}
