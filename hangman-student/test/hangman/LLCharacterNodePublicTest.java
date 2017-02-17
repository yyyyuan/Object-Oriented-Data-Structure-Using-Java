package hangman;

import static org.junit.Assert.*;

import org.junit.Test;

public class LLCharacterNodePublicTest {

	@Test (timeout = 5000)
	public void testInfo() {
		LLCharacterNode a = new LLCharacterNode('a');
		assertEquals("Expected 'a' but found " + a.getInfo(),
					 'a', a.getInfo());
	}

	@Test (timeout = 5000)
	public void testLink() {
		LLCharacterNode a = new LLCharacterNode('a');
		assertEquals("Expected 'a' but found " + a.getInfo(),
					 'a', a.getInfo());
		LLCharacterNode b = new LLCharacterNode('b');
		a.setLink(b);
		assertEquals("Expected reference to b but found " + a.getLink(),
				 b, a.getLink());
	}

	@Test (timeout = 5000)
  public void testTraversal() {
		LLCharacterNode head = null;
		for (int i = 97; i < (97+26); i++) {
			LLCharacterNode n = new LLCharacterNode((char) i);
			if (head == null)
				head = n;
			else {
				n.setLink(head);
				head = n;
			}
		}

		LLCharacterNode n = head;
		for (int i = 122; i >= 97; i--) {
			assertEquals("Expected " + ((char)i) + " but found " + n.getInfo(),
					((char)i), n.getInfo());
			n = n.getLink();
		}
	}
}
