package bridge.implementor;

/**
 * Concrete Implementor I2: RasterRenderer.
 * Simulates rendering shapes onto a discrete pixel raster grid.
 */
public class RasterRenderer implements Renderer {

    @Override
    public String renderCircle(double radius) {
        return "RASTER circle radius=" + formatDimension(radius);
    }

    @Override
    public String renderSquare(double side) {
        return "RASTER square side=" + formatDimension(side);
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
