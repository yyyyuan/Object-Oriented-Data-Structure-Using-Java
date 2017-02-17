package hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Words implements Iterable<String> {
	ArrayList<String> words;
	
	/**
	 * Creates a new Words object.
	 * @param file the file to read words from
	 */
	public Words(String file) {
		words = readWordFile(file);
	}

	/**
	 * Reads a file of words.
	 * @param file the file to read words from
	 * @return array list of words
	 */
	private ArrayList<String> readWordFile(String file) {
		try {
			FileReader 	      fr    = new FileReader(file);
			BufferedReader    br    = new BufferedReader(fr);
			ArrayList<String> words = new ArrayList<String>();
			String word; //       = null;
			while ((word = br.readLine()) != null) {
				words.add(word.trim());
			}
			br.close();
			return words;
		} catch (FileNotFoundException e) {
			System.err.println("Could not read the file " + file);
			return new ArrayList<String>();
		} catch (IOException e) {
			System.err.println("Problem reading the file " + file);
			return new ArrayList<String>();
		}
	}

	/**
	 * Returns a randomly chosen word (String) from the list.
	 * @return a word as a string
	 */
	public String pick() {
		int    size   = words.size();
		Random random = new Random();
		int    index  = random.nextInt(size-1); 
		return words.get(index);
	}
	
	/**
	 * Returns true if the word is in Words; false otherwise.
	 * @param word the word to look for
	 * @return true if the word is in Words; false otherwise
	 */
	public boolean has(String word) {
		for (String w : words) {
			if (w.equals(word))
				return true;
		}
		return false;
	}
	
	@Override
	public Iterator<String> iterator() {
		return words.iterator();
	}

}
