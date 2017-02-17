package tokenring;

import java.util.LinkedList;
import java.util.Queue;

public class WorkstationImplementation extends Workstation {

	protected Queue<Message> queue = new LinkedList<Message>();
	protected NetworkInterface nic;
	private Frame frame;

	
	public WorkstationImplementation(NetworkInterface nic) {
            // TODO
		queue.clear();
		this.nic = nic;
	}

	public NetworkInterface getNIC() {
            // TODO
            return nic;
	}
	
	@Override
	public int compareTo(Workstation o) {
            // TODO
		int value = 0;
		
		if (this.id < o.id) {
			value = -1;
		}
		else if (this.id == o.id) {
			value = 0;
		}
		else {
			value = 1;
		}
            return value;
	}
	
	@Override
	public boolean equals(Object obj) {
            // TODO
		if (this.id == ((Workstation)obj).id) {
			return true;
		}
		else {
            return false;
		}
	}

	public void sendMessage(Message m) {
            // TODO
		this.queue.add(m);
	}

	@Override
	public void tick() {
            // TODO
		
		if (this.nic.hasFrame()) {
			Message m;
			frame = nic.read();
			
			if (frame.isTokenFrame()) {
				if (queue.isEmpty()) {
					nic.write(frame);
				}
				else {
					m = queue.remove();
					frame = new DataFrame(m);
					nic.write(frame);
					incMsgSent();
				}
			}
			else {
				DataFrame dataframe = (DataFrame) frame;
				m = dataframe.getMessage();
				
				if (m.getReceiver() == this.getId()) {
					System.out.println("message " + m.toString() + " received by " + m.getReceiver() + ";" + " sent by " + m.getSender() );
					
					dataframe.setReceived(true);
					nic.write(dataframe);
					
					incMsgRcvd();

				}
				else if (m.getSender() == this.getId() && dataframe.wasReceived()) {
					System.out.println("message " + m.toString() + " acknowledged by sender " + m.getSender() + " from destination " + m.getReceiver());
					
					frame = TokenFrame.TOKEN;
					nic.write(frame);
					
					incMsgDelivered();
					
				}
				else if (m.getSender() == this.getId() && !dataframe.wasReceived()) {
					System.out.println("message " + m.toString() + " dropped; destination not reachable");
					
					frame = TokenFrame.TOKEN;
					nic.write(frame);
					
				}
				else {
					nic.write(dataframe);
				}
			}
		}
	}

}
