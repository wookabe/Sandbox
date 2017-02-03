package woo.general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Łukasz on 2017-01-16.
 */
public class RateBlocker {

    private final Queue<Long> times; // guarded by: this
    private final long allowedTime;
    private final int maxCount;

    private int msgCounter;

    public RateBlocker(final int timeSpan, int maxCount) {
        this.allowedTime = timeSpan;
        this.maxCount = maxCount;
        msgCounter = 0;
        times = new LinkedList();
    }

    public void send() {
        if (inRange())
            System.out.println(String.format("Sending message nbr %d...", ++msgCounter));
        else
            System.out.println(String.format("Not sending message nbr %d...", ++msgCounter));
    }

    private boolean inRange() {
        boolean result = true;
        long myTime = System.currentTimeMillis();

        synchronized (times) {
            if (isMaxCountReached()) {
                if (isTimeLessThanAllowed(myTime))
                    result = false;
                else {
                    times.remove();
                    times.add(myTime);
                }
            } else
                times.add(myTime);
        }

        return result;
    }

    private synchronized boolean isTimeLessThanAllowed(long myTime) {
        return myTime - times.peek() < allowedTime;
    }

    private synchronized boolean isMaxCountReached() {
        return times.size() == maxCount;
    }
}
