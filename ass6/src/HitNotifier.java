//215487695 Noam Kaplinski

/**
 * The class defines the function addHitListener and removeHitListener.
 *
 * @author Noam kaplinski
 */
public interface HitNotifier {
    /**
     * The function adds a listener to the list of listeners to hit events.
     *
     * @param hl The HitListener that we add.
     */
    void addHitListener(HitListener hl);

    /**
     * The function removes a listener from the list of listeners to hit events.
     *
     * @param hl The HitListener that we remove.
     */
    void removeHitListener(HitListener hl);
}