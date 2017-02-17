package tokenring;

/**
 * Represents a frame that can be sent in the token ring network. The
 * two supported frames in this simulation are a token frame and a 
 * data frame. More details can be found on <a href="http://en.wikipedia.org/wiki/Token_ring">
 * Wikipedia</a>.
 * 
 * @author tim
 *
 */
public interface Frame {
	boolean isDataFrame();
	boolean isTokenFrame();
}
