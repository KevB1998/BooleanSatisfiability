public class Group {
    private int open;
    private int close;
    private int depth;

    public Group(int open, int close, int depth) {
        this.open = open;
        this.close = close;
        this.depth = depth;
    }

    public int getOpen() {
        return open;
    }

    public int getClose() {
        return close;
    }

    public int getDepth() {
        return depth;
    }
}
