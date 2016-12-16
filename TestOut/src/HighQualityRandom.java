


import android.os.SystemClock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HighQualityRandom extends Random { //good enough, slower than java secureRandom, not cryptographic3r
    int value;

    public int next(int bits) {
        Random random = new Random();
        int randomNumber = (random.nextInt(bits)) % 2;

        if (randomNumber == 0) {
            int value = randomNumber + (int) SystemClock.currentThreadTimeMillis() * 1000 / 3;
        } else {
            int value = randomNumber + (int) SystemClock.currentThreadTimeMillis() * 1000 / 4;
        }

        return value;
    }


    public static void main(String[] args) {
        int reps = 12;
        while (reps > 0) {
            System.out.print(HighQualityRandom.this.next(reps));
        }
    }
}