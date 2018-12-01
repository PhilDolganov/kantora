

import java.util.Random;

public class DebuggerPractice {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            DebuggerPractice world = new DebuggerPractice();
            System.out.println(world.calculateRandomNumber());
            Thread.sleep(1000);
        }
    }

    public int calculateRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }

}
