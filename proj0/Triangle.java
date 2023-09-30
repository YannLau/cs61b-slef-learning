public class Triangle {
    public static void main(String[] args) {

        // 5% border
        StdDraw.setScale(-0.05, 1.05);

        // draw the triangle
        double t = Math.sqrt(3.0) / 2.0;
        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, t);
        StdDraw.line(0.5, t, 0.0, 0.0);

        // draw the point; make pen radius large enough to see it
        StdDraw.setPenRadius(0.01);
    }
}