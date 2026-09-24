package bridge.abstraction;

import bridge.implementor.Renderer;
import java.util.Objects;

/**
 * Abstract base class representing the Abstraction hierarchy in the Bridge pattern.
 * Maintains domain identity and encapsulates a reference to the Implementor interface.
 */
public abstract class Shape {
    protected final String id;
    protected Renderer renderer;

    /**
     * Initializes the abstraction with an identifier and an implementor reference.
     *
     * @param id       Unique domain identifier for this shape instance.
     * @param renderer The implementor through which rendering operations will be delegated.
     * @throws IllegalArgumentException if the ID is null or blank.
     * @throws NullPointerException     if the renderer is null.
     */
    protected Shape(String id, Renderer renderer) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Shape ID cannot be null or blank");
        }
        this.id = id.trim();
        this.renderer = Objects.requireNonNull(renderer, "Renderer implementation cannot be null");
    }

    /**
     * Primary domain operation executed on the abstraction.
     * Delegates low-level rendering behavior to the encapsulated implementor.
     *
     * @return Description of the rendered shape.
     */
    public abstract String execute();

    /**
     * Replaces the implementor reference at runtime, enabling dynamic switching
     * of the rendering mechanism on the existing abstraction object.
     *
     * @param renderer New implementor to associate with this shape.
     * @throws NullPointerException if the new renderer is null.
     */
    public void setImplementation(Renderer renderer) {
        this.renderer = Objects.requireNonNull(renderer, "Renderer implementation cannot be null");
    }

    /**
     * Retrieves the domain identifier of the shape.
     *
     * @return Shape ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the current implementor associated with this shape.
     *
     * @return Active Renderer instance.
     */
    public Renderer getRenderer() {
        return renderer;
    }
}
