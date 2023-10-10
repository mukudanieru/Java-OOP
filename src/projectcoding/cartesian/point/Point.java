package projectcoding.cartesian.point;

public class Point {
    
    private char point;
    private double x;
    private double y;
    
    public Point(char point) {
        this.point = point;
        this.x = 0;
        this.y = 0;
    }

    public Point(char point, double x, double y) {
        this.point = point;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point " + this.point + ": (" + this.x + ", " + this.y + ")";
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public int getQuadrant() {
        return x > 0 ? y > 0 ? 1 : 4 : y > 0 ? 2 : 3;
    }

    public double distanceTo(Point p2) {
        double dx = Math.pow((p2.x - this.x), 2);
        double dy = Math.pow((p2.y - this.y), 2);
        return Math.sqrt(dx + dy);
    }

    public double slope(Point p2) {
        double dy = p2.y - this.y;
        double dx = p2.x - this.x;
        return dy / dx;
    }
}
