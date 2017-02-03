package woo.towers;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static woo.towers.Move.Pole;

/**
 * Created by Łukasz on 2017-01-20.
 */
public class TowersOfHanoiTest {

    private TowersOfHanoi t;

    @Before
    public void setUp() throws Exception {
        t = new TowersOfHanoi(new SimpleSolutionPrinter());
    }

    @Test
    public void whenZeroDisks_shouldReturnEmpty() throws Exception {
        Map<Integer, Move> solution = t.solve(0);

        assertThat(solution.size(), is(0));
    }

    @Test
    public void whenOneDisk_shouldReturnAC() throws Exception {
        Map<Integer, Move> solution = t.solve(1);

        assertThat(solution.size(), is(1));
        assertThat(solution.get(1), is(new Move(Pole.A, Pole.C)));
    }

    @Test
    public void whenTwoDisks_shouldReturnABACBC() throws Exception {
        final Map<Integer, Move> solution = t.solve(2);

        assertEquals(3, solution.size());
        assertEquals(new Move(Pole.A, Pole.B), solution.get(1));
        assertEquals(new Move(Pole.A, Pole.C), solution.get(2));
        assertEquals(new Move(Pole.B, Pole.C), solution.get(3));
    }

    @Test
    public void whenThreeDisks_shouldReturnACABCBACBABCAC() throws Exception {
        final Map<Integer, Move> solution = t.solve(3);

        assertEquals(7, solution.size());
        assertEquals(new Move(Pole.A, Pole.C), solution.get(1));
        assertEquals(new Move(Pole.A, Pole.B), solution.get(2));
        assertEquals(new Move(Pole.C, Pole.B), solution.get(3));
        assertEquals(new Move(Pole.A, Pole.C), solution.get(4));
        assertEquals(new Move(Pole.B, Pole.A), solution.get(5));
        assertEquals(new Move(Pole.B, Pole.C), solution.get(6));
        assertEquals(new Move(Pole.A, Pole.C), solution.get(7));
    }
}