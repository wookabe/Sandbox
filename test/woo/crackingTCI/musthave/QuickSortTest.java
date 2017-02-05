package woo.crackingTCI.musthave;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Łukasz on 2017-02-05.
 */
public class QuickSortTest {
    private QuickSort<Integer> qs;

    @Before
    public void setUp() throws Exception {
        qs = new QuickSort<>();
    }

    @Test
    public void sort_whenNull_shouldReturn() throws Exception {
        qs.sort(null);
    }

    @Test
    public void sort_whenEmpty_shouldReturn() throws Exception {
        qs.sort(new Integer[0]);
    }

    @Test
    public void sort_whenOneElem_shouldKeepOne() throws Exception {
        Integer[] array = {1};

        qs.sort(array);

        assertEquals((Integer) 1, array[0]);
    }

    @Test
    public void sort_whenSorted_shouldKeepSorted() throws Exception {
        Integer[] array = {1, 2, 3};

        qs.sort(array);

        assertEquals((Integer) 1, array[0]);
        assertEquals((Integer) 2, array[1]);
        assertEquals((Integer) 3, array[2]);
    }

    @Test
    public void sort_whenReverseSorted_shouldSort() throws Exception {
        Integer[] array = {3, 2, 1};

        qs.sort(array);

        assertEquals((Integer) 1, array[0]);
        assertEquals((Integer) 2, array[1]);
        assertEquals((Integer) 3, array[2]);
    }

    @Test
    public void sort_whenRandomAndEven_shouldSort() throws Exception {
        final int numOfElems = 1234;
        Integer[] array = new Integer[numOfElems];
        final Random random = new Random();
        for (int i = 0; i < numOfElems; array[i] = random.nextInt(1000), i++) ;

        qs.sort(array);

        int compare = array[0];
        for (int i = 1; i < numOfElems; assertTrue(compare <= array[i]), compare = array[i], i++) ;
    }

    @Test
    public void sort_whenRandomAndOdd_shouldSort() throws Exception {
        final int numOfElems = 4321;
        Integer[] array = new Integer[numOfElems];
        final Random random = new Random();
        for (int i = 0; i < numOfElems; array[i] = random.nextInt(1000), i++) ;

        qs.sort(array);

        int compare = array[0];
        for (int i = 1; i < numOfElems; assertTrue(compare <= array[i]), compare = array[i], i++) ;
    }

    @Test
    public void sort_whenSameValues_shouldSort() throws Exception {
        Integer[] array = {5, 4, 3, 3, 3, 2, 1, 3};

        qs.sort(array);

        assertEquals((Integer) 1, array[0]);
        assertEquals((Integer) 2, array[1]);
        assertEquals((Integer) 3, array[2]);
        assertEquals((Integer) 3, array[3]);
        assertEquals((Integer) 3, array[4]);
        assertEquals((Integer) 3, array[5]);
        assertEquals((Integer) 4, array[6]);
        assertEquals((Integer) 5, array[7]);
    }
}