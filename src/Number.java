public enum Number {

    AS("A"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEEN("10"),
    JOTA("J"),
    QUEEN("Q"),
    KING("K");

    public final String index;

    private Number(String index) {
        this.index = index;
    }
}
