package lesson4_level3_thread;

public class StepByStep {

    static Object monitor = new Object();
    static char currentLetter = 'A';

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 'A') {
                            monitor.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = 'B';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 'B') {
                            monitor.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = 'C';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 'C') {
                            monitor.wait();
                        }
                        System.out.print(currentLetter);
                        currentLetter = 'A';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
