package tokenring;

/**
 * An abstract class representing a token ring network. It provides the
 * support for associating the token ring with an engine. A subclass of
 * {@link TokenRing} must implement the {@link TokenRing#add(Workstation)}
 * method as well as any other methods required by {@link Simulatable}.
 * 
 * @author tim
 *
 */
public abstract class TokenRing implements Simulatable {
	/**
	 * The {@link Engine} that is running the simulation. The token ring
	 * object is associated with an engine so it can record useful information
	 * about the simulation.
	 */
	private Engine engine;
	
	/**
	 * Sets the {@link Engine} this {@link TokenRing} belongs to.
	 * 
	 * @param engine the engine
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	/**
	 * A delegate method to increment the number of hops.	
	 */	
	protected void incHops() {
		engine.incHops();
	}

	/**
	 * Adds a {@link Workstation workstation} to the token ring network.
	 * 
	 * @param w the workstation
	 */
	public abstract void add(Workstation w);
}
