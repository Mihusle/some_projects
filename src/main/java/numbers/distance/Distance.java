package numbers.distance;

import numbers.distance.exceptions.InputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by MHSL on 18.01.2017.
 */
public class Distance {
    
    private static final int EARTH_RADIUS = 6371;
    
    public static void main(String[] args) {
        ArrayList<Double> coordinates = new ArrayList<Double>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("This program calculates numbers.distance between two cities. You have to input coordinates of these" +
                            " cities and choose a unit of numbers.distance.\n" +
                            "Input name of first city: ");
        try {
            String firstCityName = reader.readLine();
            System.out.println("Input coordinates of " + firstCityName);
            coordinates.addAll(inputCoordinates(reader));
            
            System.out.print("Input name of second city: ");
            String secondCityName = reader.readLine();
            coordinates.addAll(inputCoordinates(reader));
            
            System.out.println(String.format("Distance between %s and %s equals: " + calculateDistance(coordinates) + " km", firstCityName, secondCityName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InputException e) {
            System.out.println("You made mistake in coordinates.");
        }
    }
    
    public static ArrayList<Double> inputCoordinates(BufferedReader reader) throws InputException {
        ArrayList<Double> coordinates = new ArrayList<Double>();
        System.out.println("Input coordinates of this city");
        try {
            System.out.print("Latitude: ");
            String latitude = reader.readLine();
            System.out.print("Longitude: ");
            String longitude = reader.readLine();
            
            coordinates.add(Double.valueOf(latitude));
            coordinates.add(Double.valueOf(longitude));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordinates;
    }
    
    public static double calculateDistance(ArrayList<Double> coordinates) {
        double radians = Math.acos(Math.sin(Math.toRadians(coordinates.get(0))) * Math.sin(Math.toRadians(coordinates.get(2))) +
                         Math.cos(Math.toRadians(coordinates.get(0))) * Math.cos(Math.toRadians(coordinates.get(2))) *
                                 Math.cos(Math.toRadians(coordinates.get(1) - coordinates.get(3))));
        return radians * EARTH_RADIUS;
    }
}
