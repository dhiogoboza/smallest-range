package range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import range.model.IntegerRange;
import range.model.Item;
import range.model.Range;

/**
 *
 * @author dhiogoboza
 */
public class RangeCalculatorTest {
    
    public RangeCalculatorTest() {
        
    }
    
    public void runTest(List<List<Item>> items, Range result, Range expectedResult) {
        RangeCalculator.calcRange(items, result);
        assertEquals(expectedResult, result);
    }
    
    public void runTest(List<List<Item>> items, Range result, Range expectedResult1, Range expectedResult2) {
        RangeCalculator.calcRange(items, result);
        assertTrue(result.equals(expectedResult1) || result.equals(expectedResult2));
    }
    
    /**
     * Test 01 of calcRange method, of class RangeCalculator.
     */
    @Test
    public void testCalcRange01() {
        System.out.println("calcRange 01");
        
        List<Item> list1 = Arrays.asList(new Item(1, 4), new Item(1, 10),
                new Item(1, 15), new Item(1, 24), new Item(1, 26));
        
        List<Item> list2 = Arrays.asList(new Item(2, 0), new Item(2, 9),
                new Item(2, 12), new Item(2, 20));
        
        List<Item> list3 = Arrays.asList(new Item(3, 5), new Item(3, 18),
                new Item(3, 22), new Item(3, 30));
        
        List<List<Item>> items = new ArrayList<>();
        items.add(list1);
        items.add(list2);
        items.add(list3);
        
        IntegerRange expectedResult = new IntegerRange(items.size(), 20, 24);
        IntegerRange result = new IntegerRange(items.size());
        
        runTest(items, result, expectedResult);
    }
    
    /**
     * Test 02 of calcRange method, of class RangeCalculator.
     */
    @Test
    public void testCalcRange02() {
        System.out.println("calcRange 02");
        
        List<Item> list1 = Arrays.asList(new Item(1, 4), new Item(1, 10),
                new Item(1, 15), new Item(1, 24), new Item(1, 26));
        
        List<Item> list2 = Arrays.asList(new Item(2, 0), new Item(2, 9),
                new Item(2, 12), new Item(2, 20));
        
        List<Item> list3 = Arrays.asList(new Item(3, 5), new Item(3, 18),
                new Item(3, 22), new Item(3, 30));
        
        List<Item> list4 = Arrays.asList(new Item(4, 6));
        
        List<List<Item>> items = new ArrayList<>();
        items.add(list1);
        items.add(list2);
        items.add(list3);
        items.add(list4);
        
        IntegerRange expectedResult = new IntegerRange(items.size(), 4, 9);
        IntegerRange result = new IntegerRange(items.size());
        
        runTest(items, result, expectedResult);
    }
    
    /**
     * Test 03 of calcRange method, of class RangeCalculator.
     */
    @Test
    public void testCalcRange03() {
        System.out.println("calcRange 03");
        
        List<Item> list1 = Arrays.asList(new Item(1, 4), new Item(1, 7),
                new Item(1, 9), new Item(1, 12), new Item(1, 15));
        
        List<Item> list2 = Arrays.asList(new Item(2, 0), new Item(2, 8),
                new Item(2, 10), new Item(2, 14), new Item(2, 20));
        
        List<Item> list3 = Arrays.asList(new Item(3, 6), new Item(3, 12),
                new Item(3, 16), new Item(3, 30), new Item(3, 50));
        
        List<List<Item>> items = new ArrayList<>();
        items.add(list1);
        items.add(list2);
        items.add(list3);
        
        IntegerRange expectedResult1 = new IntegerRange(items.size(), 6, 8);
        IntegerRange expectedResult2 = new IntegerRange(items.size(), 14, 16);
        IntegerRange result = new IntegerRange(items.size());
        
        runTest(items, result, expectedResult1, expectedResult2);
    }
    
    /**
     * Test 04 of calcRange method, of class RangeCalculator.
     */
    @Test
    public void testCalcRange04() {
        System.out.println("calcRange 04");
        
        List<Item> list1 = Arrays.asList(new Item(1, 4), new Item(1, 7));
        List<Item> list2 = Arrays.asList(new Item(2, -1), new Item(2, 1), new Item(2, 2));
        List<Item> list3 = Arrays.asList(new Item(3, 20), new Item(3, 40));
        
        List<List<Item>> items = new ArrayList<>();
        items.add(list1);
        items.add(list2);
        items.add(list3);
        
        IntegerRange expectedResult = new IntegerRange(items.size(), 2, 20);
        IntegerRange result = new IntegerRange(items.size());
        
        runTest(items, result, expectedResult);
    }
}
