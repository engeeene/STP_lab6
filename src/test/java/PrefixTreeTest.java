import PrefixTree.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PrefixTreeTest {
    @Test
    public void testPrefixTreeInsert() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("cat");
        PrefixTree prefixTree = new PrefixTree(testList);

        Assert.assertTrue("PrefixTree Test Insert", prefixTree.contains("cat"));
    }

    @Test
    public void testPrefixTreeContains() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("cat");
        PrefixTree prefixTree = new PrefixTree(testList);

        Assert.assertFalse("PrefixTree Test not Contains", prefixTree.contains("dog"));
    }
}
