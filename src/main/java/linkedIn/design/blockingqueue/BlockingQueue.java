package linkedIn.design.blockingqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue implements MultiPutBlockingBoundedQueue{

    private boolean initDone = false;
    private int capacity, currSize = 0;
    private LinkedList buffer;
    private ReentrantLock lock, writerLock;
    private Condition notEmpty;
    private Condition notFull;


    @Override
    public void init(int capacity) throws Exception {
        if(initDone)
            throw new RuntimeException("Already Inited");
        this.capacity = capacity;
        buffer = new LinkedList();
        lock = new ReentrantLock();
        writerLock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        initDone = true;
    }

    private void assertQueueInitialized(){
        if(!initDone)
            throw new RuntimeException("");
    }
    @Override
    public Object get() throws Exception {
        assertQueueInitialized();
        try {
            lock.lock();
            while (currSize <=0){
                try {
                    notEmpty.await();
                }catch (InterruptedException e){

                }
            }
            currSize--;
            notFull.signal();
            return buffer.remove(0);
        }catch (Exception e){
            throw e;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void put(Object obj) throws Exception {
        assertQueueInitialized();
        try {
            lock.lock();
            while (currSize == capacity){
                try {
                    notFull.await();
                }catch (InterruptedException e){

                }
            }
            buffer.offer(obj);
            currSize--;
            notEmpty.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
            writerLock.unlock();
        }
    }

    @Override
    public void multiput(List objs) throws Exception {
        assertQueueInitialized();
        try {
            lock.lock();
            writerLock.lock();
            for (Object obj: objs) {
                while (currSize == capacity){
                    try {
                        notFull.await();
                    }catch (InterruptedException e){

                    }
                    buffer.offer(obj);
                    currSize++;
                    notEmpty.signal();
                }
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
            writerLock.unlock();
        }
    }
}
