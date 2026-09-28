package bridge.implementor;

/**
 * Concrete Implementor I1: VectorRenderer.
 * Simulates rendering shapes as scalable vector graphics.
 */
public class VectorRenderer implements Renderer {

    @Override
    public String renderCircle(double radius) {
        return "VECTOR circle radius=" + formatDimension(radius);
    }

    @Override
    public String renderSquare(double side) {
        return "VECTOR square side=" + formatDimension(side);
    }

    /**
     * Formats numerical dimensions cleanly, omitting trailing decimal zeros
     * for whole integer values.
     *
     * @param value Dimension value.
     * @return Formatted dimension string.
     */
    private String formatDimension(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
