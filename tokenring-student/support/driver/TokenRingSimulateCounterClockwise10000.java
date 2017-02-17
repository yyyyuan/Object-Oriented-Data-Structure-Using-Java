package driver;

import tokenring.*;

import java.util.ArrayList;

public class TokenRingSimulateCounterClockwise10000 {

	public static void main(String[] args) {
		// Create simulation engine:
		Engine e = new Engine();
		
		// Create the token ring:
		TokenRing tokenring = new TokenRingImplementation(false);
		tokenring.setEngine(e);
		e.add(tokenring);
		
		// Create NICs:
		ArrayList<NetworkInterface> nics = new ArrayList<NetworkInterface>();
		for (int i = 0; i < 10; i++) {
			NetworkInterface nic = new NetworkInterface();
			e.add(nic);
			nics.add(nic);
		}
		
		// Create Workstations:
		for (NetworkInterface nic : nics) {
			Workstation w = new WorkstationImplementation(nic);
			w.setEngine(e);
			e.add(w);
			tokenring.add(w);
		}		
		
		// Simulate:
		e.simulate(1000000);
		System.out.printf("Number of messages sent: %d\n", e.getMsgSent());
		System.out.printf("Number of messages rcvd: %d\n", e.getMsgRcvd());
		System.out.printf("Number of messages delivered: %d\n", e.getMsgDelivered());
		System.out.printf("Number of frame hops: %d\n", e.getHops());
	}
	
}
