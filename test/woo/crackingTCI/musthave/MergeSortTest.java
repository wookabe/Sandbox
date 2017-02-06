package woo.crackingTCI.musthave;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Łukasz on 2017-02-06.
 */
public class MergeSortTest {

    private MergeSort<String> ms;

    @Before
    public void setUp() throws Exception {
        ms = new MergeSort<>();
    }

    @Test
    public void sort_whenNullOrLessThanTwo_shouldReturnSame() throws Exception {
        ms.sort(null);

        ms.sort(new String[0]);

        final String[] array = {"1"};
        ms.sort(array);
        assertEquals("1", array[0]);
    }

    @Test
    public void sort_whenEvenSorted_shouldReturnSame() throws Exception {
        final String[] array = {"0", "1", "2", "3"};

        ms.sort(array);

        assertEquals("0", array[0]);
        assertEquals("1", array[1]);
        assertEquals("2", array[2]);
        assertEquals("3", array[3]);
    }

    @Test
    public void sort_whenEvenUnSorted_shouldReturnSorted() throws Exception {
        final String[] array = {"0", "2", "1", "3"};

        ms.sort(array);

        assertEquals("0", array[0]);
        assertEquals("1", array[1]);
        assertEquals("2", array[2]);
        assertEquals("3", array[3]);
    }

    @Test
    public void sort_whenOddSorted_shouldReturnSame() throws Exception {
        final String[] array = {"0", "1", "2", "3", "4"};

        ms.sort(array);

        assertEquals("0", array[0]);
        assertEquals("1", array[1]);
        assertEquals("2", array[2]);
        assertEquals("3", array[3]);
        assertEquals("4", array[4]);
    }

    @Test
    public void sort_whenOddUnSorted_shouldReturnSorted() throws Exception {
        final String[] array = {"4", "0", "1", "2", "3"};

        ms.sort(array);

        assertEquals("0", array[0]);
        assertEquals("1", array[1]);
        assertEquals("2", array[2]);
        assertEquals("3", array[3]);
        assertEquals("4", array[4]);
    }

    @Test
    public void sort_whenEvenRandom_shouldReturnSorted() throws Exception {
        final int size = 1234;
        final String[] array = new String[size];
        final Random random = new Random();
        for (int i = 0; i < size; array[i] = String.valueOf(random.nextInt(100)), i++) ;

        ms.sort(array);

        String previous = array[0];
        for (int i = 1; i < size; assertTrue(previous.compareTo(array[i]) <= 0), previous = array[i], i++) ;
    }

    @Test
    public void sort_whenOddRandom_shouldReturnSorted() throws Exception {
        final int size = 4321;
        final String[] array = new String[size];
        final Random random = new Random();
        for (int i = 0; i < size; array[i] = String.valueOf(random.nextInt(100)), i++) ;

        ms.sort(array);

        String previous = array[0];
        for (int i = 1; i < size; assertTrue(previous.compareTo(array[i]) <= 0), previous = array[i], i++) ;
    }
}