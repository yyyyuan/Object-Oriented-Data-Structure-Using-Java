package sorters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import java.util.concurrent.TimeUnit;

import comparators.IntegerComparator;
import comparators.LexicographicStringComparator;
import structures.ArrayBasedSwapList;
import structures.SwapList;

public class PublicInsertionSorterTest {
	@Rule
	public Timeout globalTimeout = new Timeout(500L, TimeUnit.MILLISECONDS);

	private static final Comparator<Integer> INTEGER_COMPARATOR = new IntegerComparator();
	private static final Comparator<String> STRING_COMPARATOR = new LexicographicStringComparator();

	SwapList<Integer> emptyList;
	AbstractSorter<Integer> emptySorter;
	SwapList<Integer> sortedList;
	AbstractSorter<Integer> sortedSorter;
	SwapList<String> reversedList;
	AbstractSorter<String> reversedSorter;
	SwapList<Integer> firstAsLastList;
	AbstractSorter<Integer> firstAsLastSorter;

	@Before
	public void before() {
		emptyList = new ArrayBasedSwapList<Integer>(new Integer[] {});
		emptySorter = new InsertionSorter<Integer>(emptyList,
				INTEGER_COMPARATOR);

		sortedList = new ArrayBasedSwapList<Integer>(new Integer[] { -3, -1, 0,
				2, 4 });
		sortedSorter = new InsertionSorter<Integer>(sortedList,
				INTEGER_COMPARATOR);

		List<String> rList = new ArrayList<String>();
		for (char c = 'z'; c >= 'a'; c--) {
			rList.add(Character.toString(c));
		}
		reversedList = new ArrayBasedSwapList<String>(rList);
		reversedSorter = new InsertionSorter<String>(reversedList,
				STRING_COMPARATOR);

		firstAsLastList = new ArrayBasedSwapList<Integer>(new Integer[] { 5, 6,
				7, 8, 9, 10, 4 });
		firstAsLastSorter = new InsertionSorter<Integer>(firstAsLastList,
				INTEGER_COMPARATOR);
	}

	@Test
	public void testEmpty() {
		SwapList<Integer> result = emptySorter.sort();
		assertTrue(result.isSorted(INTEGER_COMPARATOR));
	}

	@Test
	public void testSorted() {
		SwapList<Integer> result = sortedSorter.sort();
		assertTrue(result.isSorted(INTEGER_COMPARATOR));
	}

	@Test
	public void testSortedComparisons() {
		SwapList<Integer> result = sortedSorter.sort();
		final int n = sortedList.size();
		assertEquals(n - 1, result.getComparisons());
	}

	@Test
	public void testSortedSwaps() {
		SwapList<Integer> result = sortedSorter.sort();
		assertEquals(0, result.getSwaps());
	}

	@Test
	public void testReversed() {
		SwapList<String> result = reversedSorter.sort();
		assertTrue(result.isSorted(STRING_COMPARATOR));
	}

	@Test
	public void testReversedComparisons() {
		SwapList<String> result = reversedSorter.sort();
		final int n = reversedList.size();
		assertEquals((n * (n - 1) / 2), result.getComparisons());
	}

	@Test
	public void testReversedSwaps() {
		SwapList<String> result = reversedSorter.sort();
		final int n = reversedList.size();
		assertEquals((n * (n - 1) / 2), result.getSwaps());
	}

	@Test
	public void testFirstAsLast() {
		SwapList<Integer> result = firstAsLastSorter.sort();
		assertTrue(result.isSorted(INTEGER_COMPARATOR));
	}

	@Test
	public void testFirstAsLastComparisons() {
		SwapList<Integer> result = firstAsLastSorter.sort();
		final int n = firstAsLastList.size();
		assertEquals((n - 2) + (n - 1), result.getComparisons());
	}

	@Test
	public void testFirstAsLastSwaps() {
		SwapList<Integer> result = firstAsLastSorter.sort();
		final int n = firstAsLastList.size();
		assertEquals(n - 1, result.getSwaps());
	}

	@Test
	public void testRandomLists() {
		List<SwapList<Integer>> randomizedLists = new ArrayList<SwapList<Integer>>();
		Random random = new Random(0);
		for (int length = 1; length < Math.pow(2, 8); length *= 2) {
			for (int count = 0; count < Math.min(length, 10); count++) {
				List<Integer> list = new ArrayList<Integer>(length);
				for (int i = 0; i < length; i++) {
					list.add(random.nextInt());
				}
				randomizedLists.add(new ArrayBasedSwapList<Integer>(list));
			}
		}

		for (SwapList<Integer> list : randomizedLists) {
			AbstractSorter<Integer> sorter = new InsertionSorter<Integer>(list,
					INTEGER_COMPARATOR);
			SwapList<Integer> result = sorter.sort();
			final int n = list.size();
			final int upperBound = (n * (n - 1) / 2);
			assertTrue(result.isSorted(INTEGER_COMPARATOR));
			assertTrue(result.getComparisons() <= upperBound);
			assertTrue(result.getSwaps() <= upperBound);
		}
	}
}
