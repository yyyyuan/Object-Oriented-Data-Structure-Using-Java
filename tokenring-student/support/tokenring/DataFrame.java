package tokenring;


/**
 * A data frame to be sent around a token ring. 
 */
public class DataFrame implements Frame {
	// The message contained in the data frame:
	private Message message;
	// Indicates if the token was received by a destination workstation:
	private boolean received;
	
	/**
	 * Creates a new Token object.
	 */
	public DataFrame(Message m) {
		message  = m;
		received = false;
	}
	
	/**
	 * Returns the message in the token.
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * Sets the token as being received.
	 */
	public void setReceived(boolean received) {
		this.received = received;
	}

	/**
	 * Returns true if the token was received. 
	 */
	public boolean wasReceived() {
		return received;
	}
	
	/**
	 * Resets the token to contain no messages and not received.
	 */
	public void reset() {
		message  = null;
		received = false;
	}

	@Override
	public boolean isDataFrame() {
		return true;
	}

	@Override
	public boolean isTokenFrame() {
		return false;
	}
}
