package tokenring;

import structures.DoublyCicularLinkedList;
import structures.DoublyCircularLinkedListImplementation;

public class TokenRingImplementation extends TokenRing {

	private boolean direction;
	
	private DoublyCicularLinkedList<Workstation> ring;
	
	private Workstation current;
	
	private Frame frame;
	
	private int ETA;
	
	private boolean waiting;
	
	public TokenRingImplementation(boolean direction) {
		this.direction = direction;
		this.current   = null;
		this.frame     = TokenFrame.TOKEN;
		this.ETA       = 0;
		this.waiting   = false;
		this.ring      = new DoublyCircularLinkedListImplementation<Workstation>();		
	}
	
	public TokenRingImplementation() {
		this(true);
	}
	
	public void add(Workstation w) {
		ring.add(w);
	}
	
	private Workstation next() {
		if (direction)
			return ring.getNext();
		else
			return ring.getPrevious();
	}
	
	@Override
	public void tick() {
		current = current == null ? ring.getNext() : current;
		NetworkInterface nic = current.getNIC();				
		
		if (ETA == 0 && !waiting) {			
			// frame has arrived at next workstation.
			// need to write frame to nic
			nic.write(frame);
			waiting = true;
			incHops();
		}
		else if (ETA == 0 && waiting) {
			// we wrote a frame to the nic
			// waiting for data on nic
			// if we have data, read it and send it along to next
			// if we do not have data, we wait
			if (nic.hasFrame()) {
				frame = nic.read();
				frame   = frame != null ? frame : TokenFrame.TOKEN;
				current = next();
				waiting = false;
				ETA     = 2;				
			}
			else {
				waiting = true;
			}
		}
		else if (ETA > 0 && !waiting) {
			ETA-=1;
		}
		else {			
			throw new IllegalStateException("We should not be here. ETA = " + ETA + ", waiting = " + waiting);
		}
	}

}
