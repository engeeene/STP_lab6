import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Words solver = new Words("words.txt");
        Metrics.start();
        solver.start();
        Metrics.stop();
        System.out.format("Memory used %f MB\n", Metrics.getMemory());
        System.out.format("Time used %f s\n", Metrics.getTime());
        System.out.format("Simple words %s\n", solver.getSimpleWords());
        System.out.format("Concatenated words %s\n", solver.getConcatenatedWords());
        System.out.format("Partially concatenated words %s\n", solver.getPartiallyConcatenatedWords());
        System.out.format("First longest concatenated word is %s with length %d\n", solver.getMaxFirst(), solver.getMaxFirstLength());
        System.out.format("Second longest concatenated word is %s with length %d\n", solver.getMaxSecond(), solver.getMaxSecondLength());

    }
}
