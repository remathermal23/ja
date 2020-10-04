package Maths;

/**
 * Find the area of various geometric shapes
 */
public class Area {
    public static void main(String[] args) {
        
        /* test cube */
        assert Double.compare(surfaceAreaCube(1), 6.0) == 0;

        /* test sphere */
        assert Double.compare(surfaceAreaSphere(5), 314.1592653589793) == 0;
        assert Double.compare(surfaceAreaSphere(1), 12.566370614359172) == 0;

        /* test rectangle */
        assert Double.compare(surfaceAreaRectangle(10, 20), 200.0) == 0;

        /* test square */
        assert Double.compare(surfaceAreaSquare(10), 100.0) == 0;

        /* test triangle */
        assert Double.compare(surfaceAreaTriangle(10, 10), 50.0) == 0;

        /* test parallelogram */
        assert Double.compare(surfaceAreaParallelogram(10, 20), 200.0) == 0;

        /* test trapezium */
        assert Double.compare(surfaceAreaTrapezium(10, 20, 30), 450.0) == 0;

        /* test circle */
        assert Double.compare(surfaceAreaCircle(20), 1256.6370614359173) == 0;
        
        /* test polygon from apothem */
        assert Double.compare(surfaceAreaPolygonApothem(8, 2), 13.254833995939041) == 0;
        
        /* test polygon from radius */
        assert Double.compare(surfaceAreaPolygonRadius(8, 2), 11.313708498984761) == 0;
        
        /* test polygon from side length */
        assert Double.compare(surfaceAreaPolygonSideLength(8, 2), 19.31370849898476) == 0;
    }

    /**
     * Calculate the surface area of a cube.
     *
     * @param sideLength side length of cube
     * @return surface area of given cube
     */
    private static double surfaceAreaCube(double sideLength) {
        return 6 * sideLength * sideLength;
    }

    /**
     * Calculate the surface area of a sphere.
     *
     * @param radius radius of sphere
     * @return surface area of given sphere
     */
    private static double surfaceAreaSphere(double radius) {
        return 4 * Math.PI * radius * radius;
    }

    /**
     * Calculate the area of a rectangle
     *
     * @param length length of rectangle
     * @param width  width of rectangle
     * @return area of given rectangle
     */
    private static double surfaceAreaRectangle(double length, double width) {
        return length * width;
    }

    /**
     * Calculate the area of a square
     *
     * @param sideLength side length of square
     * @return area of given square
     */
    private static double surfaceAreaSquare(double sideLength) {
        return sideLength * sideLength;
    }

    /**
     * Calculate the area of a triangle
     *
     * @param base   base of triangle
     * @param height height of triangle
     * @return area of given triangle
     */
    private static double surfaceAreaTriangle(double base, double height) {
        return base * height / 2;
    }

    /**
     * Calculate the area of a parallelogram
     *
     * @param base   base of parallelogram
     * @param height height of parallelogram
     * @return area of given parallelogram
     */
    private static double surfaceAreaParallelogram(double base, double height) {
        return base * height;
    }

    /**
     * Calculate the area of a trapezium
     *
     * @param base1  upper base of trapezium
     * @param base2  bottom base of trapezium
     * @param height height of trapezium
     * @return area of given trapezium
     */
    private static double surfaceAreaTrapezium(double base1, double base2, double height) {
        return (base1 + base2) * height / 2;
    }

    /**
     * Calculate the area of a circle
     *
     * @param radius radius of circle
     * @return area of given circle
     */
    private static double surfaceAreaCircle(double radius) {
        return Math.PI * radius * radius;
    }
    
    /**
     * Calculate the area of a regular polygon with an apothem
     * 
     * @param sides number of sides
     * @param apothem apothem of polygon (distance from origin to center of side)
     * @return area of given polygon
     */
    private static double surfaceAreaPolygonApothem(int sides, double apothem) {
    	return apothem * apothem * sides * Math.tan( Math.PI / sides );
    }
    
    /**
     * Calculate the area of a regular polygon with a radius
     * 
     * @param sides number of sides
     * @param radius radius of polygon (distance from origin to corner)
     * @return area of given polygon
     */
    private static double surfaceAreaPolygonRadius(int sides, double radius) {
    	return radius * radius * sides * Math.sin( Math.PI / sides ) * Math.cos( Math.PI / sides );
    }
    
    /**
     * Calculate the area of a regular polygon with a side length
     * 
     * @param sides number of sides
     * @param sideLength length of a side
     * @return area of given polygon
     */
    private static double surfaceAreaPolygonSideLength(int sides, double sideLength) {
    	return sideLength * sideLength * sides / ( 4 * Math.tan( Math.PI / sides ) );
    }
}