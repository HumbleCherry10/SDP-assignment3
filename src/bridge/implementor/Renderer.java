package bridge.implementor;

/**
 * Implementor interface in the Bridge pattern.
 * Defines the primitive, low-level rendering operations decoupled from
 * high-level shape abstractions.
 */
public interface Renderer {

    /**
     * Renders a circular geometry with a given radius.
     *
     * @param radius Radius of the circle.
     * @return Visually distinctive description of the rendered circle.
     */
    String renderCircle(double radius);

    /**
     * Renders a square geometry with a given side length.
     *
     * @param side Side length of the square.
     * @return Visually distinctive description of the rendered square.
     */
    String renderSquare(double side);
}
