package comparators;

import java.util.Comparator;

/**
 * Comparator on two Integers in the usual order.
 * 
 * @author liberato
 *
 */
public class IntegerComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
}
