package algorithms.pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by MHSL on 27.01.2017.
 *
 * The closest pair of points problem or closest pair problem is a problem of computational geometry: given n points in
 * metric space, find a pair of points with the smallest distance between them.
 */
public class ClosestPair {
    
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("Enter coordinates for points. First X and then Y.");
        System.out.println("For exit enter empty line.");
        try {
            while (!(line = reader.readLine()).equals("")) {
                String[] coordinates = line.split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                points.add(new Point(x, y));
            }
            Collections.sort(points, Point::compareTo);
            System.out.println(findMinDistance(points));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static double findMinDistance(List<Point> points) {
        if (points.size() > 2) {
            double firstDistance = findMinDistance(points.subList(0, points.size()/2));
            double secondDistance = findMinDistance(points.subList(points.size(), points.size()));
            return findMinDistance(points, Math.min(firstDistance, secondDistance));
        } else if (points.size() == 2) {
            return calculateDistance(points.get(0), points.get(1));
        }
        return Double.MAX_VALUE;
    }
    
    private static double findMinDistance(List<Point> points, double currentDistance) {
        int middleX = points.get(points.size()/2).getX();
        List<Point> pointsB = points.stream()
                .filter(element -> (Math.abs(element.getX() - middleX)) < currentDistance)
                .sorted(Comparator.comparing(Point::getY))
                .collect(toList());
        double distance;
        double tempDistance = currentDistance;
        for (int i = 0; i < pointsB.size(); i++) {
            for (int j = 0; j < i; j++) {
                Point first = pointsB.get(i);
                Point second = pointsB.get(j);
                if (second.getY() <= first.getY() && (first.getY() - currentDistance) < second.getY()) {
                    distance = calculateDistance(first, second);
                    if (distance < tempDistance) {
                        tempDistance = distance;
                    }
                }
            }
        }
        return tempDistance;
    }
    
    private static double calculateDistance(Point first, Point second) {
        return Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2));
    }
}
