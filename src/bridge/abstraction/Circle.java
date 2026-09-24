package bridge.abstraction;

import bridge.implementor.Renderer;

/**
 * Refined Abstraction A1: Circle.
 * Maintains domain-specific geometric data (radius) and delegates
 * concrete rendering to the bridge implementor.
 */
public class Circle extends Shape {
    private final double radius;

    /**
     * Constructs a Circle abstraction.
     *
     * @param id       Unique domain identifier.
     * @param radius   Radius of the circle (must be positive).
     * @param renderer Implementor instance for rendering.
     * @throws IllegalArgumentException if radius is non-positive.
     */
    public Circle(String id, double radius, Renderer renderer) {
        super(id, renderer);
        if (radius <= 0) {
            throw new IllegalArgumentException("Circle radius must be strictly positive: " + radius);
        }
        this.radius = radius;
    }

    /**
     * Executes circle rendering by delegating to the implementor interface.
     *
     * @return Resulting rendering description string.
     */
    @Override
    public String execute() {
        return renderer.renderCircle(radius);
    }

    /**
     * Returns the circle radius.
     *
     * @return Radius value.
     */
    public double getRadius() {
        return radius;
    }
}
