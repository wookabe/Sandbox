package woo.towers;

/**
 * Created by Łukasz on 2017-01-20.
 */
class Move {

    enum Pole {
        A, B, C
    }

    final Pole from;
    final Pole to;

    Move(Pole from, Pole to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        return from == move.from && to == move.to;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result *= to != null ? to.hashCode() : 1;
        return result;
    }

    @Override
    public String toString() {
        return "Move{from=" + from + ", to=" + to + '}';
    }
}
