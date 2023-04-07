package cinema;

public class PairKey {
    private int id;
    private int name;

    public PairKey(int id, int name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairKey pairKey = (PairKey) o;
        return id == pairKey.id && name == pairKey.name;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name;//name.hashCode();
        return result;
    }
}
