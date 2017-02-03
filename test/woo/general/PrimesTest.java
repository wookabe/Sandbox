package woo.general;

import org.junit.Before;
import org.junit.Test;
import woo.general.Primes;

import java.util.Set;
import java.util.SortedSet;

/**
 * Created by Łukasz on 2017-01-16.
 */
public class PrimesTest {
    private Primes p;

    @Before
    public void setUp() throws Exception {
        p = new Primes();
    }


    /*
     * Last stop: Prime [36 573 125]: 706 521 913
     * Prime [24 371 586]: 460 340 981
     * Prime [15 653 375]: 288 323 353
     * Prime [11 845 640]: 214 683 631
     */
    @Test
    public void test() throws Exception {
        p.printPrimes(460340981 + 1, Integer.MAX_VALUE, 24371586 + 1);
    }

    @Test
    public void testConcurrent() throws Exception {
        final int lowerBound = 1;
        final int upperBound = 5 * 1000 * 1000;
        final int nOfCPUs = 4;

        long time = System.nanoTime();
        final Set<Long> primes = p.countPrimes(lowerBound, upperBound, nOfCPUs);
        time = (System.nanoTime() - time) / 1000000000;

        System.out.println("Primes between " + lowerBound + " and " + upperBound
                + " (with " + nOfCPUs + " CPUs) found in " + time + " secs: " + primes.size());
    }

    @Test
    public void testConcurrentChunks() throws Exception {
        new ConcurrentChunkPrimesTester().find();
    }

    private class ConcurrentChunkPrimesTester {
        /*
            [144 449 538]: 2 999 999 929
            [111 604 030]: 2 287 483 619
            [105 097 565]: 2 147 483 629
            [78 343 344]: 1 576 521 803
            [74 561 943]: 1 496 521 823
            [64 586 357]: 1 286 521 843
            [55 495 243]: 1 096 521 859
         */
        final long lowerBound = 2999999929L;
        final long upperBound = 3 * 1000 * 1000 * 1000L;
        final int nOfCPUs = 4;
        final int threadChunk = 1 * 1000;
        final long printChunk = 10 * 1000 * 1000;

        long count = 144449538L - 1;
        private SortedSet<Long> primes;
        private long time;
        private long lower;
        private long upper;

        public void find() {
            for (long i = lowerBound; i <= upperBound; i += printChunk) {
                calculateChunkBoundaries(i);
                findChunk();
                printChunk();
            }
        }

        private void calculateChunkBoundaries(long i) {

            lower = i;
            upper = lower + printChunk > upperBound ? upperBound : lower + printChunk;
        }

        private void findChunk() {
            time = System.nanoTime();
            primes = p.countPrimes(lower, upper, nOfCPUs, threadChunk);
            time = (System.nanoTime() - time) / 1000000000;
            count += primes.size();
        }

        private void printChunk() {
            System.out.println("Number of primes between " + lower + " and " + upper
                    + " (with " + nOfCPUs + " CPUs and in " + threadChunk + " chunks)"
                    + " found in " + time + " secs : " + primes.size());
            System.out.println(String.format("Last prime in batch of %,d [%,d]: %,d",
                    printChunk, count , primes.isEmpty() ? 0 : primes.last()));
        }
    }
}