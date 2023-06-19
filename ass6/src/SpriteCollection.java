//215487695 Noam Kaplinski

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * The class can build a sprite collection and add a sprite to a sprite collection and notify all the sprites
 * and the class can draw every sprite on the drawing surface.
 *
 * @author Noam kaplinski
 */
public class SpriteCollection {
    private java.util.List<Sprite> sprites;

    /**
     * The function creates a sprite list.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * The function gets a sprite and adds him to the sprite list.
     *
     * @param s The sprite which we add to the sprite list.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * The function return the list of the sprites.
     *
     * @return java.util.List of Sprites which contains all the sprites.
     */
    public java.util.List<Sprite> getSprites() {
        return this.sprites;
    }

    /**
     * The function notify all the sprites in the list that time has passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }

    /**
     * The function draws all the sprites in the sprite list on a drawing surface.
     *
     * @param d The drawing surface which we draw the sprites on.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).drawOn(d);
        }
    }

    /**
     * The function removes the sprite from the sprites list.
     *
     * @param sprite The sprite we delete.
     */
    public void removeSprite(Sprite sprite) {
        this.sprites.remove(sprite);
    }
}