package bridge.abstraction;

import bridge.implementor.Renderer;

/**
 * Refined Abstraction A2: Square.
 * Maintains domain-specific geometric data (side length) and delegates
 * concrete rendering to the bridge implementor.
 */
public class Square extends Shape {
    private final double side;

    /**
     * Constructs a Square abstraction.
     *
     * @param id       Unique domain identifier.
     * @param side     Side length of the square (must be positive).
     * @param renderer Implementor instance for rendering.
     * @throws IllegalArgumentException if side length is non-positive.
     */
    public Square(String id, double side, Renderer renderer) {
        super(id, renderer);
        if (side <= 0) {
            throw new IllegalArgumentException("Square side length must be strictly positive: " + side);
        }
        this.side = side;
    }

    /**
     * Executes square rendering by delegating to the implementor interface.
     *
     * @return Resulting rendering description string.
     */
    @Override
    public String execute() {
        return renderer.renderSquare(side);
    }

    /**
     * Returns the side length of the square.
     *
     * @return Side length.
     */
    public double getSide() {
        return side;
    }
}
