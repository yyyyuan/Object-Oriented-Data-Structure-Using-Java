package tokenring;

/**
 * The {@link TokenFrame} represents a {@link Frame} that
 * circulates the token ring when there is no other message
 * to send. It is examined and possibly captured by workstations 
 * on the network that want to send a data frame. The token
 * frame does not contain any data.
 * 
 * @author Tim Richards
 *
 */
public class TokenFrame implements Frame {

	/**
	 * A token frame instance.
	 */
	public static TokenFrame TOKEN = new TokenFrame();
	
	/**
	 * This private constructor prevents other classes
	 * from instantiating new token frame objects. We
	 * only need one token frame which is exported by
	 * the static variable TOKEN above.
	 */
	private TokenFrame() {
		// nothing to do
	}
	
	@Override
	public boolean isDataFrame() {
		return false;
	}

	@Override
	public boolean isTokenFrame() {
		return true;
	}

}
