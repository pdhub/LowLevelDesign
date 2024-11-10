import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LeakyBucket {
    //This is the reverse of Token

    AtomicInteger currentWaterLevel;
    int leakRate;
    int capacity;
    ScheduledExecutorService scheduledExecutorService;
    ReentrantLock lock = new ReentrantLock();

    LeakyBucket(int capacity, int leakRate){
        this.capacity = capacity;
        this.leakRate = leakRate;
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(this::leak, 1, 1, TimeUnit.SECONDS);
    }

    void leak(){
        //thread safe
        lock.lock();
        int currentLevel = currentWaterLevel.get();
        if (currentLevel > 0){
            int newLevel = Math.max(0, currentLevel - leakRate);
            currentWaterLevel.set(newLevel);
        }
        lock.unlock();
    }

    boolean tryAcquire(){
        lock.lock();
        int currentLevel = currentWaterLevel.get();
        if (currentLevel < capacity){
            currentWaterLevel.incrementAndGet();
            return  true;
        }
        lock.unlock();
        return false;
    }


}
