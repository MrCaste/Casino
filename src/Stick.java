public enum Stick {

    DIAMOND('D'),
    CLOVER('C'),
    SPADES('S'),
    HEART('H');

    public final char index;

    private Stick(char index) {
        this.index = index;
    }
}
