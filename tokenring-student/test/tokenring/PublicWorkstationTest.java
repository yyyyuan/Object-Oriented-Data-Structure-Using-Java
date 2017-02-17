package tokenring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PublicWorkstationTest {

	private Workstation w1;
	private Workstation w2;
	private NetworkInterface nic1;
	private NetworkInterface nic2;
	private Engine e;
	
	@Before
	public void setUp() throws Exception {
		nic1 = new NetworkInterface();
		w1 = new WorkstationImplementation(nic1);
		nic2 = new NetworkInterface();
		w2 = new WorkstationImplementation(nic2);
		e = new Engine();
		w1.setEngine(e);
		w2.setEngine(e);
	}

	@Test (timeout = 100)
	public void testGetId() {
		assertNotEquals(w1.getId(), -1);
		assertNotEquals(w2.getId(), -1);
		assertNotEquals(w1.getId(), w2.getId());
		assertTrue(w1.getId() < w2.getId());
	}

	@Test (timeout = 100)
	public void testGetNIC() {
		assertTrue(w1.getNIC() == nic1);
		assertTrue(w2.getNIC() == nic2);
	}
	
	@Test (timeout = 100)
	public void testTokenFrame() {
		TokenFrame tf = TokenFrame.TOKEN;
		nic1.write(tf);
		w1.tick();
		Frame result = nic1.read();
		
		assertNotNull(result);
		assertTrue(result.isTokenFrame());
	}
	
	@Test (timeout = 100)
	public void testNotIntendedRecipient() {
		Message m = new Message(9999, 9999);
		DataFrame df = new DataFrame(m);
		nic1.write(df);
		w1.tick();
		Frame result = nic1.read();
		
		assertNotNull(result);
		assertTrue(result.isDataFrame());
		assertFalse(df.wasReceived());
	}
	
	@Test (timeout = 100)
	public void testIntendedRecipient() {
		Message m = new Message(w1.getId(), w2.getId());
		DataFrame df = new DataFrame(m);
		nic2.write(df);
		w2.tick();
		Frame result = nic2.read();
		
		assertNotNull(result);
		assertTrue(result.isDataFrame());
		assertTrue(df.wasReceived());	
	}

	@Test (timeout = 100)
	public void testAcknowledgement() {
		Message m = new Message(w1.getId(), w2.getId());
		DataFrame df = new DataFrame(m);
		nic2.write(df);
		w2.tick();
		Frame result = nic2.read();
		nic1.write(df);
		w1.tick();
		result = nic1.read();

		assertNotNull(result);
		assertTrue(result.isTokenFrame());
	}
	
	@Test (timeout = 100)
	public void testMessageQueue() {
		Message m = new Message(w1.getId(), w2.getId());
		w1.sendMessage(m);
		nic1.write(TokenFrame.TOKEN);
		w1.tick();
		Frame f = nic1.read();
		
		assertNotNull(f);
		assertTrue(f.isDataFrame());
	}
	
	@Test (timeout = 100)
	public void testDroppedMessage() {
		Message m = new Message(w1.getId(), w2.getId());
		w1.sendMessage(m);
		nic1.write(TokenFrame.TOKEN);
		w1.tick();
		Frame f = nic1.read();
		
		assertNotNull(f);
		assertTrue(f.isDataFrame());
		
		nic1.write(f);
		w1.tick();
		f = nic1.read();
		
		assertNotNull(f);
		assertTrue(f.isTokenFrame());
	}	
	
	@Test
	public void testByMyself() {
		Message m = new Message(w1.getId(), w2.getId());
		w1.sendMessage(m);
		nic1.write(TokenFrame.TOKEN);
		w1.tick();
		Frame f = nic1.read();
		
		assertNotNull(f);
		assertTrue(f.isDataFrame());
	}
}
