package Board;

public abstract class Tiles {
    
    public static final String REGULAR = "\u001B[47m\u001B[30m"; //white background black text
    public static final String DOUBLE_LETTER = "\u001B[46m\u001B[30m"; //cyan background black text
    public static final String TRIPPLE_LETTER = "\u001B[42m\u001B[30m"; //green background black text
    public static final String DOUBLE_WORD = "\u001B[43m\u001B[30m"; //yellow background black text
    public static final String TRIPPLE_WORD = "\u001B[45m\u001B[30m"; //magenta background black text
    public static final String HEADING = "\u001B[44m\u001B[37m"; //blue background white text
    public static final String RESET = "\u001B[0m"; //reset to default

}
