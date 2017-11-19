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

        Assert.assertTrue("PrefixTree Test Insert", prefixTree.startsWith("cat"));
    }

    @Test
    public void testPrefixTreeStartsWith() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("cat");
        PrefixTree prefixTree = new PrefixTree(testList);

        Assert.assertFalse("PrefixTree Test Contains", prefixTree.startsWith("dog"));
    }

    @Test
    public void testPrefixTreeisContained() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("cat");
        PrefixTree prefixTree = new PrefixTree(testList);

        Assert.assertTrue(prefixTree.isContained("cats"));
    }
}
