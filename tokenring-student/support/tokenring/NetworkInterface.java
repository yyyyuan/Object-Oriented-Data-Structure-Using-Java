package tokenring;


public class NetworkInterface implements Simulatable {

	private Frame frame;
	
	public NetworkInterface() {
		frame = null;
	}
	
	public boolean hasFrame() {
		return frame != null;
	}
	
	public void write(Frame frame) {
		this.frame = frame;		
	}
	
	public Frame read() {
		Frame f = frame;
		frame = null;
		return f;
	}
	
	@Override
	public void tick() {
		/* A basic frame does not do anything on its own. It waits to
		 * be accessed by the network and/or the workstation. 
		 */
	}

}
