import org.junit.Assert;
import org.junit.Test;

public class WordTest {
    @Test
    public void Solve() {
        try {
            Words solver = new Words("wordsTest.txt");
            solver.start();
            Assert.assertEquals("Solve Test fail Concatenated Words", solver.getConcatenatedWords(), 3);
            Assert.assertEquals("Solve Test fail Partially Concatenated Words", solver.getPartiallyConcatenatedWords(), 1);
            Assert.assertEquals("Solve Test fail Simple Words", solver.getSimpleWords(), 6);
            Assert.assertEquals("Solve Test fail Max First", solver.getMaxFirst(),"catflycat");
            Assert.assertEquals("Solve Test fail Max Second", solver.getMaxSecond(),"catsdog");
            Assert.assertEquals("Solve Test fail Max First Length", solver.getMaxFirstLength(), 9);
            Assert.assertEquals("Solve Test fail Max Max Second Length", solver.getMaxSecondLength(), 7);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
