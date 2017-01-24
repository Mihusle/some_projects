package numbers.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by MHSL on 22.01.2017.
 *
 * Coin Flip Simulation - Write some code that simulates flipping a single coin however many times the user decides.
 * The code should record the outcomes and count the number of tails and heads.
 */
public class CoinFlipSimulation {
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Write how many times you want to flip coin: ");
        try {
            int times = Integer.parseInt(reader.readLine());
            int heads = 0;
            int tails = 0;
            Random random = new Random(System.currentTimeMillis());
            while (times > 0) {
                if (random.nextBoolean()) {
                    heads++;
                    System.out.println("It's a head");
                } else {
                    tails++;
                    System.out.println("It's a tail");
                }
                times--;
            }
            System.out.println();
            System.out.println("Heads: " + heads);
            System.out.println("Tails: " + tails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
