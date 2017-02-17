package tokenring;

/**
 * A Message represents a message that is sent from 
 * a sender to a receiver.  
 */
public class Message {
	// An id for each message object:
	private static int messageIds = 0;
	
	// The id of this message:
	private int messageId;
	// The id of the sender:
	private int sender;
	// The id of the receiver:
	private int receiver;
	
	/**
	 * Creates a new Message object. 
	 */
	public Message(int sender, int receiver) {
		this.messageId = messageIds++;
		this.sender    = sender;
		this.receiver  = receiver;
	}
	
	/**
	 * Returns the message id. 
	 */	
	public int getMessageId() {
		return messageId;
	}
	
	/**
	 * Returns the sender id. 
	 */
	public int getSender() {
		return sender;
	}

	/**
	 * Returns the receiver id.
	 */
	public int getReceiver() {
		return receiver;
	}

	/**
	 * Returns a string representation of the message.
	 */
	public String toString() {
		return "M" + messageId + "[" + sender + "->" + receiver + "]";
	}
}
