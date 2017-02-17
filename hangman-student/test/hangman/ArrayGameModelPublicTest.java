package hangman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayGameModelPublicTest {

	private ArrayGameModel model1;
	private ArrayGameModel model2;

	@Before
	public void before() {
		model1 = new ArrayGameModel("Zigzag");
		model2 = new ArrayGameModel("Volume");
	}

	@Test(timeout = 1000)
	public void testIsCorrectGuess() {
		boolean result;
		result = model1.isCorrectGuess('c');
		assertFalse("'c' is not in Zigzag", result);
		result = model1.isCorrectGuess('z');
		assertTrue("'z' is in Zigzag", result);
		result = model1.isCorrectGuess('g');
		assertTrue("'g' is in Zigzag twice", result);
	}

	@Test(timeout = 1000)
	public void testIsPriorGuess() {
		boolean result;
		result = model1.isCorrectGuess('g');
		assertTrue("'g' is in Zigzag twice", result);
		result = model1.doMove('g');
		assertTrue("'g' is in Zigzag; move was played", result);
		result = model1.isPriorGuess('g');
		assertTrue("'g' is a prior guess", result);
	}

	@Test(timeout = 1000)
	public void testDoMove() {
		boolean result;

		result = model1.doMove('i');
		assertTrue("'i' is in the word so doMove should return true", result);
		result = model1.doMove('i');
		assertFalse("We already guessed 'i' so doMove should return false", result);
		result = model1.doMove('p');
		assertFalse("'p' is not in the word so doMove should return false", result);
		result = model1.doMove('g');
		assertTrue("'g' is in the word twice so doMove should return true", result);
		result = model1.doMove('g');
		assertFalse("We already guessed 'g' (in the word twice) so doMove should return false", result);
	}

	@Test(timeout = 1000)
	public void testInWinningState() {
		boolean result = false;

		char[] letters = { 'Z', 'i', 'g', 'z', 'a' };

		for (int i = 0; i < letters.length - 1; i++) {
			result = model1.doMove(letters[i]);
			assertTrue("'" + letters[i] + "' is in the word", result);
			result = model1.inWinningState();
			assertFalse("[" + i + "] The model is not in the winning state", result);
		}

		result = model1.doMove(letters[letters.length - 1]);
		assertTrue("'" + letters[letters.length - 1] + "' is in the word", result);
		result = model1.inWinningState();
		assertTrue("The model is in the winning state", result);
	}

	@Test(timeout = 1000)
	public void testInLosingState() {
		boolean result = false;

		char[] letters = { 'v', 'd', 'c', 'x', 'q', 'r', 'l', 'm', 'n', 'p' };

		for (int i = 0; i < letters.length - 1; i++) {
			result = model1.doMove(letters[i]);
			assertFalse("'" + letters[i] + "' is not in the word", result);
			result = model1.inLosingState();
			assertFalse("[" + i + "] The model is not in the losing state", result);
		}

		result = model1.doMove(letters[letters.length - 1]);
		assertFalse("'" + letters[letters.length - 1] + "' is not in the word", result);
		result = model1.inLosingState();
		assertTrue("The model is in the losing state", result);
	}

	@Test(timeout = 1000)
	public void testCurrentHungState() {
		model1.doMove('Z');
		assertEquals("Is in state 0", 0, model1.getState());
		model1.doMove('i');
		assertEquals("Is in state 0", 0, model1.getState());
		model1.doMove('g');
		assertEquals("Is in state 0", 0, model1.getState());
		model1.doMove('z');
		assertEquals("Is in state 0", 0, model1.getState());
		model1.doMove('a');
		assertEquals("Is in state 0", 0, model1.getState());

		assertEquals("Is in state 0", 0, model2.getState());
		model2.doMove('Z');
		assertEquals("Is in state 1", 1, model2.getState());
		model2.doMove('i');
		assertEquals("Is in state 2", 2, model2.getState());
		model2.doMove('g');
		assertEquals("Is in state 3", 3, model2.getState());
		model2.doMove('z');
		assertEquals("Is in state 4", 4, model2.getState());
		model2.doMove('a');
		assertEquals("Is in state 5", 5, model2.getState());

		model2.doMove('V');
		assertEquals("Is in state 5", 5, model2.getState());
		model2.doMove('x');
		assertEquals("Is in state 6", 6, model2.getState());
		model2.doMove('x');
		assertEquals("Is in state 6", 6, model2.getState());
		model2.doMove('x');
		assertEquals("Is in state 6", 6, model2.getState());
		model2.doMove('x');
		assertEquals("Is in state 6", 6, model2.getState());
		model2.doMove('x');
		assertEquals("Is in state 6", 6, model2.getState());

		// Test after state 6 -> should still be in state 6:
		model2.doMove('x');
		assertEquals("Should still be in state 6", 6, model2.getState());
	}

	@Test(timeout = 1000)
	public void testToString() {
		model1.doMove('Z');
		assertEquals("State should be \"Z _ _ _ _ _\"", "Z _ _ _ _ _", model1.toString());
		model1.doMove('i');
		assertEquals("State should be \"Z i _ _ _ _\"", "Z i _ _ _ _", model1.toString());
		model1.doMove('g');
		assertEquals("State should be \"Z i g _ _ g\"", "Z i g _ _ g", model1.toString());
		model1.doMove('z');
		assertEquals("State should be \"Z i g z _ g\"", "Z i g z _ g", model1.toString());
		model1.doMove('a');
		assertEquals("State should be \"Z i g z a g\"", "Z i g z a g", model1.toString());

		model2.doMove('Z');
		assertEquals("State should be \"_ _ _ _ _ _\"", "_ _ _ _ _ _", model2.toString());
		model2.doMove('l');
		assertEquals("State should be \"_ _ l _ _ _\"", "_ _ l _ _ _", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		model2.doMove('e');
		assertEquals("State should be \"_ _ l _ _ e\"", "_ _ l _ _ e", model2.toString());
		// Should always remain as the same string even after the number of
		// guesses exceeded!
	}

	@Test(timeout = 1000)
	public void testPreviousGuessString() {
		char[] letters = { 'v', 'd', 'c', 'x', 'q', 'r', 'l', 'm', 'n', 'p' };

		for (int i = 0; i < letters.length - 1; i++) {
			model1.doMove(letters[i]);
		}

		assertEquals("Previous guess string should be \"[v, d, c, x, q, r, l, m, n]\"", "[v, d, c, x, q, r, l, m, n]",
				model1.previousGuessString());
	}

}
