package muteks;

public class TestMutecks {
    public static void main(String[] args) {
        Source source = new Source();
        Writer writer = new Writer(source);
        Reader reader = new Reader(source);

        writer.start();
        reader.start();
    }
}
