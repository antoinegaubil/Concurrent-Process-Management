import ca.concordia.coen346.server.Buffer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                buffer.lock.lock();
                try {
                    int pos = buffer.getNextPosition();
                    buffer.insertItem(i, pos);
                    buffer.setIn((pos + 1) % Buffer.BUFFER_SIZE);
                    buffer.readCount();
                }
                finally {
                    buffer.lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
           for (int i = 0; i < 1000; i++) {
               buffer.lock.lock();
               try {
                   int pos = (buffer.getNextPosition() - 1 + Buffer.BUFFER_SIZE) % Buffer.BUFFER_SIZE;
                   buffer.getNextItem(pos);
                   buffer.readCount();
               }
               finally {
                   buffer.lock.unlock();
               }
           }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count " + buffer.readCount());
    }
}