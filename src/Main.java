import bridge.abstraction.Circle;
import bridge.abstraction.Shape;
import bridge.abstraction.Square;
import bridge.implementor.AsciiRenderer;
import bridge.implementor.RasterRenderer;
import bridge.implementor.Renderer;
import bridge.implementor.VectorRenderer;
import java.util.Objects;

/**
 * Main demonstration harness for the Bridge Pattern implementation.
 * Runs automated checks verifying abstraction-implementor combinations
 * and runtime implementor replacement.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && "--demo".equals(args[0])) {
            runDemo();
        } else {
            runDemo();
        }
    }

    /**
     * Executes the automated demonstration checks without interactive input.
     */
    public static void runDemo() {
        int passedCount = 0;
        int totalChecks = 7;

        // T1: A1 (Circle) with I1 (VectorRenderer)
        Shape circleVector = new Circle("C-01", 2, new VectorRenderer());
        String expectedT1 = "VECTOR circle radius=2";
        if (checkCombination("T1", "Circle + VectorRenderer", circleVector, expectedT1)) {
            passedCount++;
        }

        // T2: A1 (Circle) with I2 (RasterRenderer)
        Shape circleRaster = new Circle("C-01", 2, new RasterRenderer());
        String expectedT2 = "RASTER circle radius=2";
        if (checkCombination("T2", "Circle + RasterRenderer", circleRaster, expectedT2)) {
            passedCount++;
        }

        // T3: A2 (Square) with I1 (VectorRenderer)
        Shape squareVector = new Square("S-01", 3, new VectorRenderer());
        String expectedT3 = "VECTOR square side=3";
        if (checkCombination("T3", "Square + VectorRenderer", squareVector, expectedT3)) {
            passedCount++;
        }

        // T4: A2 (Square) with I2 (RasterRenderer)
        Shape squareRaster = new Square("S-01", 3, new RasterRenderer());
        String expectedT4 = "RASTER square side=3";
        if (checkCombination("T4", "Square + RasterRenderer", squareRaster, expectedT4)) {
            passedCount++;
        }

        // T5: Runtime switching on the same abstraction object
        if (checkRuntimeSwitch()) {
            passedCount++;
        }

        // T6: A1 (Circle) with new I3 (AsciiRenderer)
        Shape circleAscii = new Circle("C-01", 2, new AsciiRenderer());
        String expectedT6 = "ASCII circle radius=2";
        if (checkCombination("T6", "Circle + AsciiRenderer", circleAscii, expectedT6)) {
            passedCount++;
        }

        // T7: A2 (Square) with new I3 (AsciiRenderer)
        Shape squareAscii = new Square("S-01", 3, new AsciiRenderer());
        String expectedT7 = "ASCII square side=3";
        if (checkCombination("T7", "Square + AsciiRenderer", squareAscii, expectedT7)) {
            passedCount++;
        }

        System.out.println("SUMMARY: " + passedCount + "/" + totalChecks + " PASS");
    }

    /**
     * Helper to verify T1-T4, T6-T7 combinations.
     */
    private static boolean checkCombination(String testId, String label, Shape shape, String expected) {
        String actual = shape.execute();
        boolean passed = expected.equals(actual);
        if (passed) {
            System.out.println(testId + " PASS | " + label + " | result=" + actual);
        } else {
            System.out.println(testId + " FAIL | " + label + " | expected=" + expected + " | actual=" + actual);
        }
        return passed;
    }

    /**
     * Verifies T5 runtime implementor replacement on a single object instance.
     */
    private static boolean checkRuntimeSwitch() {
        Circle shape = new Circle("C-01", 2, new VectorRenderer());
        Circle refBefore = shape;
        String idBefore = shape.getId();
        double radiusBefore = shape.getRadius();

        String beforeResult = shape.execute();

        // Switch implementation at runtime
        shape.setImplementation(new RasterRenderer());
        Circle refAfter = shape;
        String idAfter = shape.getId();
        double radiusAfter = shape.getRadius();

        String afterResult = shape.execute();

        boolean sameObject = (refBefore == refAfter);
        boolean stateUnchanged = Objects.equals(idBefore, idAfter) && (radiusBefore == radiusAfter);
        boolean expectedBefore = "VECTOR circle radius=2".equals(beforeResult);
        boolean expectedAfter = "RASTER circle radius=2".equals(afterResult);

        boolean passed = sameObject && stateUnchanged && expectedBefore && expectedAfter;
        if (passed) {
            System.out.println("T5 PASS | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
            System.out.println(" before=" + beforeResult + " | after=" + afterResult);
        } else {
            System.out.println("T5 FAIL | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
            System.out.println(" before=" + beforeResult + " | after=" + afterResult);
        }
        return passed;
    }
}
