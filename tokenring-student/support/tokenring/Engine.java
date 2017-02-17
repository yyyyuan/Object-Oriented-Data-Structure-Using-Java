package tokenring;

import java.util.ArrayList;
import java.util.Random;

public class Engine {
	
	/**
	 * The total number of messages sent by each workstation.
	 */
	private int msgSent;
	
	/**
	 * The total number of messages received by each workstation.
	 */
	private int msgRcvd;
	
	/**
	 * The total number of messages that were successfully delivered.
	 * A successfully delivered message is one that was sent by a sending
	 * workstation, received by the intended destination workstation,
	 * and acknowledged by the original sending workstation.
	 */
	private int msgDelivered;
	
	/**
	 * The total number of hops of each frame that was sent.
	 */
	private int hops;
	
	/**
	 * This is used to randomly generate messages.
	 */
	private Random random = new Random(0);
		
	/**
	 * A list of all the {@link Simulatable} objects in this simulation.
	 */
	private ArrayList<Simulatable> sims;
	
	/**
	 * A list of all the {@link Workstation} objects in this simulation.
	 */
	private ArrayList<Workstation> workstations;
	
	/**
	 * Creates a new {@link Engine} object.
	 */
	public Engine() {
		sims = new ArrayList<Simulatable>();
		workstations = new ArrayList<Workstation>();
	}
	
	/**
	 * Adds a {@link Simulatable} object to the {@link Engine}.
	 * 
	 * @param sim a {@link Simulatable} object
	 */
	public void add(Simulatable sim) {
		sims.add(sim);
		if (sim instanceof Workstation)
			workstations.add((Workstation) sim);
	}
		
	/**
	 * Increments the number of messages sent. This should be called
	 * within {@link Workstation#tick()} to record when a {@link DataFrame}
	 * is sent to a destination workstation. 
	 */
	public void incMsgSent() {
		msgSent+=1;
	}
	
	/**
	 * Increments the number of messages received. This should be called
	 * within {@link Workstation#tick()} to record when a {@link DataFrame}
	 * is received by a destination workstation. 
	 */
	public void incMsgRcvd() {
		msgRcvd+=1;
	}
	
	/**
	 * Increments the number of messages delivered. This should be called
	 * within {@link Workstation#tick()} to record when a {@link DataFrame}
	 * has been sent, received, and acknowledged. 
	 */
	public void incMsgDelivered() {
		msgDelivered+=1;
	}	
	
	/**
	 * Increments the number of hops. This should be called
	 * within {@link TokenRing#tick()} to record when a {@link Frame}
	 * has moved from one {@link Workstation} to the next.
	 */
	public void incHops() {
		hops+=1;
	}	
	
	/**
	 * Returns the number of messages sent.
	 * 
	 * @return number of messages sent
	 */
	public int getMsgSent() {
		return msgSent;
	}

	/**
	 * Returns the number of messages received.
	 * 
	 * @return number of messages received
	 */
	public int getMsgRcvd() {
		return msgRcvd;
	}

	/**
	 * Returns the number of messages delivered.
	 * 
	 * @return number of messages delivered
	 */
	public int getMsgDelivered() {
		return msgDelivered;
	}

	/**
	 * Returns the number of hops.
	 * 
	 * @return number of hops
	 */
	public int getHops() {
		return hops;
	}

	/**
	 * This method generates a message between a randomly chosen sending
	 * {@link Workstation} and a randomly chosen destination 
	 * {@link Workstation}. The message is added to the source
	 * {@link Workstation} to be sent during the simulation. 
	 */
	private void generateMessage() {
		int    n =  workstations.size()-1;
		Workstation src = workstations.get(random.nextInt(n));
		Workstation dst = workstations.get(random.nextInt(n));
		while (dst == src) {
			dst = workstations.get(random.nextInt(n));
		}
		Message m = new Message(src.getId(), dst.getId());
		src.sendMessage(m);
	}
	
	/**
	 * Generates {@code count} number of messages.
	 * 
	 * @param count the number of messages to generate
	 */
	private void generateMessages(int count) {
		for (int i = 0; i < count; i++)
			generateMessage();
	}
	
	/**
	 * This method kicks off the simulation. It will run the simulation
	 * for the given number of {@code ticks}. It iterates over each of
	 * the {@link Simulatable} objects invoking their {@link Simulatable#tick()}
	 * methods.
	 * 
	 * @param ticks the number of ticks to simulate
	 */
	public void simulate(int ticks) {
		while (ticks != 0) {
			generateMessages(1);
			for (Simulatable sim : sims) {
				sim.tick();
			}
			ticks-=1;
		}
	}
	
}
