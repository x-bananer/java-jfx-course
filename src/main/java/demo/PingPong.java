package demo;

public class PingPong extends Thread {
    String word;
    long delay;

    public PingPong(String word, long delay) {
        this.word = word;
        this.delay = delay;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(word + "");
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void main(String args[]) {
        PingPong a = new PingPong("PING", 33);
        PingPong b = new PingPong("pong", 100);

        a.start();
        b.start();
    }
}
