package algorithms.pair;

/**
 * Created by MHSL on 27.01.2017.
 */
public class Point implements Comparable {
    
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int compareTo(Object o) {
        Point point = (Point) o;
        return x != point.getX() ? x - point.getX() : y - point.getY();
    }
}
