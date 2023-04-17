package ca.concordia.coen346.server;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    public final static int BUFFER_SIZE = 10;

    private int[] buffer = new int[BUFFER_SIZE];
    private int in;
    private int out;
    private int count;
    public Lock lock;


    public Buffer(){
        this.lock = new ReentrantLock(); // create lock
    }

    public int readCount(){
        lock.lock(); //acquire lock
        try {
            return count;
        }
        finally {
            lock.unlock(); //release lock
        }
    }

    public int getNextItem(int pos){
        lock.lock();
        try {
            int item = buffer[pos];
            return item;
        }
        finally {
            lock.unlock();
        }
    }

    public void setIn(int pos){
        lock.lock();
        try {
            this.in = pos;
        }
        finally {
            lock.unlock();
        }
    }

    public int getNextPosition(){
        lock.lock();
        try {
            return in;
        }
        finally {
            lock.unlock();
        }
    }

    public void insertItem(int item, int pos){
        lock.lock();
        try {
            buffer[pos] = item;
        }
        finally {
            lock.unlock();
        }
    }

}
