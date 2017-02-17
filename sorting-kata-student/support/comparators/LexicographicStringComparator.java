package comparators;

import java.util.Comparator;

/**
 * Comparator on two String (lexicographically).
 * 
 * @author liberato
 *
 */
public class LexicographicStringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}
