package leet_code_75;

import java.util.List;
import java.util.Objects;

public class Pair<FIRST, SECOND> {
    private int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;

    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
