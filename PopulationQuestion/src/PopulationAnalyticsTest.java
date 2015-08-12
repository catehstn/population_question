import static org.junit.Assert.*;

import org.junit.Test;


public class PopulationAnalyticsTest {

	@Test
	public void testGetMaxValueEmpty() {
		int[] input = {};
		assertEquals(-1, PopulationAnalytics.getMaxValue(input));
	}
	
	@Test
	public void testGetMaxValueOneItem() {
		int[] input = {6};
		assertEquals(6, PopulationAnalytics.getMaxValue(input));
	}
	
	@Test
	public void testGetMaxValueMultipleValues() {
		int[] input = {6,5,2,8,20,1,3,2,36,6};
		assertEquals(36, PopulationAnalytics.getMaxValue(input));
	}
	
	@Test
	public void testGetMinValueEmpty() {
		int[] input = {};
		assertEquals(-1, PopulationAnalytics.getMinValue(input));
	}
	
	@Test
	public void testGetMinValueOneItem() {
		int[] input = {6};
		assertEquals(6, PopulationAnalytics.getMinValue(input));
	}
	
	@Test
	public void testGetMinValueMultipleValues() {
		int[] input = {6,5,2,8,20,1,3,2,36,6};
		assertEquals(1, PopulationAnalytics.getMinValue(input));
	}
	
	@Test
	public void testGetMaxIndexEmpty() {
		int[] input = {};
		assertEquals(-1, PopulationAnalytics.getMaxIndex(input));
	}
	
	@Test
	public void testGetMaxIndexOneItem() {
		int[] input = {6};
		assertEquals(0, PopulationAnalytics.getMaxIndex(input));
	}
	
	@Test
	public void testGetMaxIndexMultipleValues() {
		int[] input = {6,5,2,8,20,1,3,2,36,6};
		assertEquals(8, PopulationAnalytics.getMaxIndex(input));
	}
	
	@Test
	public void testGetAccumulativeValuesEmpty() {
		int[] input = {};
		int[] expected = {0,0,0};
		assertArrayEquals(expected, PopulationAnalytics.getAccumulativeValuesInRange(input, 2003, 2005));
	}
	
	@Test
	public void testGetAccumulativeValues() {
		int[] input = {2005,2004,2003,2004,2007,2003,2004,2005};
		int[] expected = {2,5,7,7,8};
		assertArrayEquals(expected, PopulationAnalytics.getAccumulativeValuesInRange(input, 2003, 2007));
	}
	
	@Test
	public void testSubtractValuesOffsetZero() {
		int[] array1 = {2,3,4,5,6,7};
		int[] array2 = {1,1,1,2,2,3};
		int[] expected = {1,2,3,3,4,4};
		PopulationAnalytics.subtractValuesWithOffset(array1, array2, 0);
		assertArrayEquals(expected, array1);
	}
	
	@Test
	public void testSubtractValuesOffsetOne() {
		int[] array1 = {2,3,4,5,6,7};
		int[] array2 = {1,1,1,2,2,3};
		int[] expected = {2,2,3,4,4,5};
		PopulationAnalytics.subtractValuesWithOffset(array1, array2, 1);
		assertArrayEquals(expected, array1);
	}
	
	@Test
	public void testEmptyInput() {
		int[] births = {};
		int[] deaths = {};
		assertEquals(0, PopulationAnalytics.getMaxPopulationYear(births, deaths));
	}

	@Test
	public void testOneElement() {
		int[] births = {1950};
		int[] deaths = {2000};
		assertEquals(1950, PopulationAnalytics.getMaxPopulationYear(births, deaths));
	}
	
	@Test
	public void testMultipleElementsLimitedRangeOrdered() {
		int[] births = {1,2,3,4,5};
		int[] deaths = {3,4,5,6,7};
		assertEquals(3, PopulationAnalytics.getMaxPopulationYear(births, deaths));
	}
	
	@Test
	public void testMultipleElements() {
		int[] births = {1950,1999,2000,1945,1920,1921,1946};
		int[] deaths = {1985,2000,2001,1951,1953,1958,1948};
		assertEquals(1946, PopulationAnalytics.getMaxPopulationYear(births, deaths));
	}
	
	@Test
	public void testMultipleElementsCollisions() {
		int[] births = {1921,1918,1934,1925,2003,2010,2003};
		int[] deaths = {1929,1952,1982,2003,2008,2013,2005};
		assertEquals(1925, PopulationAnalytics.getMaxPopulationYear(births, deaths));
	}
}
