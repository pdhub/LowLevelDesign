import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    //Token bucket
    AtomicInteger tokens;
    int maxTokens;
    int refillRate;
    ScheduledExecutorService scheduledExecutorService;

    RateLimiter(int maxTokens, int refillRatePerSec){
        this.maxTokens = maxTokens;
        this.refillRate = refillRatePerSec;
        this.tokens = new AtomicInteger(maxTokens);
        scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(this::refill, 1, 1, TimeUnit.SECONDS);
    }

    boolean tryAcquire(){
       int currentTokens = tokens.get();
       if (currentTokens>0 &&
       tokens.compareAndSet(currentTokens,
               currentTokens-1)){
           return true;
       }
       return false;
    }

    void refill(){
        int currentTokens = tokens.get();
        if(currentTokens < maxTokens){
            int newTokens = Math.min(maxTokens, currentTokens + refillRate);
            tokens.set(newTokens);
        }
    }

    void shutdown(){
        scheduledExecutorService.shutdown();
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 2);
        for (int i = 0; i < 30; i++) {
            if (rateLimiter.tryAcquire()){
                System.out.println( i + " passed..");
            }else
                System.out.println(i + " failed .. ");

            try {
                Thread.sleep(100);
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }

        rateLimiter.shutdown();
    }
}
