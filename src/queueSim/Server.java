/**
 * Philip Cothery
 * COSC311 FA19
 * PP1008 Donut Shop Simulation
 * 
 */
package queueSim;

public class Server {
	private boolean occupiedStatus;
	private int serviceCounter;
	private int customersWaitTime;

	public Server() {
		occupiedStatus = false;
		serviceCounter = 0;
		customersWaitTime = 0;
	}

	public void setCustomer(Customer c) {
		serviceCounter = c.getServiceTime();
		customersWaitTime = c.getWaitTime();
		occupiedStatus = true;
	}

	public boolean isFree() {
		return !occupiedStatus;
	}

	public void decServiceCounter() {
		switch (serviceCounter) {
		case (0):
			occupiedStatus = false;
			return;
		default:
			serviceCounter--;
		}

	}

	public int freeServer() {
		if(serviceCounter == 0) {
		occupiedStatus = false;
		return customersWaitTime;
		}
		return 0;
	}

	public int getCustomersWait() {
		return customersWaitTime;
	}
}
