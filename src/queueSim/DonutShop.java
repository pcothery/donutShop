/**
 * Philip Cothery
 * COSC311 FA19
 * PP1008 Donut Shop Simulation
 * 
 */
package queueSim;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DonutShop {
	private Queue<Customer> customerQueue;
	private Random rng;
	private Server[] servers;
	private int totalCustomers;
	private int[] totalWait; // 0 = waitCompletedCust 1 = waitCustInServ 2 = waitInQueue
	private int totalTicks;
	private int minimumWait;
	private int maximumWait;
	private final int ticksPerMinute;
	private final double customerArrivalMean;
	private final int maximumServiceSize;

	public DonutShop(int serverCount, double customerArrivalMean, int maximumServiceSize) {
		rng = new Random(97);
		customerQueue = new LinkedList<Customer>();
		totalCustomers = 0;
		totalTicks = 0;
		ticksPerMinute = 1;
		minimumWait = 0;
		maximumWait = 0;
		totalWait = new int[3];
		this.maximumServiceSize = maximumServiceSize;
		this.customerArrivalMean = customerArrivalMean;
		servers = new Server[serverCount];
		for (int i = 0; i < serverCount; i++) {
			servers[i] = new Server();
		}
	}

	// Poisson Random number generator
	private int getPoissonRandom(double mean) {
		double L = Math.exp(-mean);
		int k = 0;
		double p = 1.0;
		do {
			p = p * rng.nextDouble();
			k++;
		} while (p > L);
		return k - 1;
	}

	private void addCustomers() {
		int numberOfNewCustomers = getPoissonRandom(customerArrivalMean * ticksPerMinute);
		for (int i = 0; i < numberOfNewCustomers; i++) {
			customerQueue.add(new Customer(1 + rng.nextInt(maximumServiceSize)));
		}
		totalCustomers += numberOfNewCustomers;
	}

	private void releaseServers() {
		for (int i = 0; i < servers.length; i++) {
			totalWait[0] += servers[i].freeServer();
		}
	}

	private void fillServers() {
		totalWait[1] = 0; // resetting in service wait counter
		for (int i = 0; i < servers.length; i++) {
			if (servers[i].isFree()) {
				if (!customerQueue.isEmpty()) {
					Customer temp = customerQueue.remove();
					totalWait[1] += temp.getWaitTime();
					servers[i].setCustomer(temp);
				}
			} else {
				servers[i].decServiceCounter();
			}
		}
	}

	private void increaseWait() {
		totalWait[2] = 0; // clears total queue wait time
		for (int i = 0; i < customerQueue.size(); i++) {
			Customer temp = customerQueue.remove();
			temp.incrementWaitTime();
			if (temp.getWaitTime() > maximumWait) {
				maximumWait = temp.getWaitTime();
			} // updates maximum wait
			if (temp.getWaitTime() < minimumWait) {
				minimumWait = temp.getWaitTime();
			} // updates minimum wait
			totalWait[2] += temp.getWaitTime();
			customerQueue.add(temp);
		}
	}

	private int getInServiceCount() {
		int count = 0;
		for (int i = 0; i < servers.length; i++) {
			if (!servers[i].isFree()) {
				count++;
			}
		}
		return count;
	}

	private int getCompletedCustomers() {
		int temp = totalCustomers;
		for (int i = 0; i < servers.length; i++) {
			if (!servers[i].isFree()) {
				temp--;
			}
		}
		temp = temp - customerQueue.size();
		return temp;
	}

	private int calcAverageWait() {
		int overallWait = totalWait[0] + totalWait[1] + totalWait[2];
		try {
			return overallWait / totalCustomers;
		} catch (ArithmeticException e) {
			return 0;
		}
	}

	private void printOutPut() {
		System.out.println("------------------------------------------------------");
		System.out.println("Tick #: " + totalTicks);
		System.out.println("# Customers in service: " + this.getInServiceCount());
		System.out.println("# Customers with completed service: " + this.getCompletedCustomers());
		System.out.println("# Customers in queue: " + customerQueue.size());
		System.out.println("Total wait time: " + (double) totalWait[0] / ticksPerMinute + " minutes");
		System.out.println("Wait time(Minutes){ min:" + minimumWait / ticksPerMinute + " avg: "
				+ this.calcAverageWait() / ticksPerMinute + " max: " + maximumWait / ticksPerMinute + "}");
		System.out.println("------------------------------------------------------\n");
	}

	public void runSimulation(int simulationTime) {
		simulationTime = simulationTime * ticksPerMinute;
		for (int i = 0; i < simulationTime; i++) {
			this.releaseServers();
			this.increaseWait();
			this.addCustomers();
			this.fillServers();
			totalTicks++;
			this.printOutPut();
		}
	}

}
