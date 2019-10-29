/**
 * Philip Cothery
 * COSC311 FA19
 * PP1008 Donut Shop Simulation
 * 
 */
package queueSim;

public class Customer {
	private int waitTime;
	private int serviceTime;
	
	public Customer(int serviceTimer){
		this.waitTime = 0;
		this.serviceTime = serviceTimer;
		
	}
	public void incrementWaitTime(){
		waitTime++;
	}
	public int getWaitTime(){
		return waitTime;
	}
	public int getServiceTime(){
		return serviceTime;
	}
}
