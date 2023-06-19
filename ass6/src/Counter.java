//215487695 Noam Kaplinski

/**
 * The class can create counter, increase him, decrease him and return his value.
 *
 * @author Noam kaplinski
 */
public class Counter {
    private int count;

    /**
     * The function increase a certain number from the counter.
     *
     * @param number The number we increase the counter with.
     */
    void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * The function decrease a certain number from the counter.
     *
     * @param number The number we decrease the counter with.
     */
    void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * The function return the current count.
     *
     * @return int which represent the current count.
     */
    int getValue() {
        return this.count;
    }
}