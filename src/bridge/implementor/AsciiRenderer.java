package bridge.implementor;

/**
 * Concrete Implementor I3: AsciiRenderer.
 * Independent extension implementing ASCII-art rendering simulation.
 * Added without modifying existing Shape abstractions or Renderer interface.
 */
public class AsciiRenderer implements Renderer {

    @Override
    public String renderCircle(double radius) {
        return "ASCII circle radius=" + formatDimension(radius);
    }

    @Override
    public String renderSquare(double side) {
        return "ASCII square side=" + formatDimension(side);
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
