package woo.general;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.*;

/**
 * Created by Łukasz on 2017-01-16.
 */
public class Primes {

    public void printPrimes(long lowerBound, long upperBound, long initialCount) throws ExecutionException, InterruptedException {
        long count = initialCount;
        for (long i = lowerBound; i < upperBound; i++) {
            if (isPrime(i))
                System.out.println(String.format("Prime [%,d]: %,d", count++, i));
        }
    }

    private boolean isPrime(long n) {
        if (n <= 1
                || (n != 2 && n % 2 == 0)
                || (n != 5 && n % 5 == 0))
            return false;

        long nSqrt = (long) Math.sqrt(n);
        for (long i = 3; i <= nSqrt; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

    public SortedSet<Long> countPrimes(long lowerBound, long upperBound) {
        return countPrimes(lowerBound, upperBound, 1);
    }


    public SortedSet<Long> countPrimes(long lowerBound, long upperBound, int nOfCPUs) {
        return countPrimes(lowerBound, upperBound, nOfCPUs, 1);
    }

    public SortedSet<Long> countPrimes(long lowerBound, long upperBound, int nOfCPUs, int chunk) {
        ExecutorService exec = Executors.newFixedThreadPool(nOfCPUs);
        SortedSet<Long> primes = executePrimeFinderInChunks(lowerBound, upperBound, chunk, exec);
        shutdownExecutor(exec);
        return primes;
    }

    private SortedSet<Long> executePrimeFinderInChunks(long lowerBound, long upperBound, int chunk, ExecutorService exec) {
        SortedSet<Long> primes = new ConcurrentSkipListSet<>();
        for (long i = lowerBound; i <= upperBound; i += chunk) {
            long lower = i;
            long upper = lower + chunk > upperBound ? upperBound : lower + chunk;
            exec.execute(new PrimeFinder(primes, lower, upper));
        }
        return primes;
    }

    private void shutdownExecutor(ExecutorService exec) {
        exec.shutdown();
        try {
            exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Immutable
    private class PrimeFinder implements Runnable {
        private final Set<Long> primes;
        private final long lower;
        private final long upper;

        public PrimeFinder(Set<Long> primes, long lower, long upper) {
            this.primes = primes;
            this.lower = lower;
            this.upper = upper;
        }

        public void run() {
            for (long i = lower; i < upper; i++)
                if (isPrime(i))
                    primes.add(i);
        }
    }
}