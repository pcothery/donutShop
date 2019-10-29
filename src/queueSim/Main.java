/**
 * Philip Cothery
 * COSC311 FA19
 * PP1008 Donut Shop Simulation
 * 
 */
package queueSim;

public class Main {
	public static void main(String[] args) {
		DonutShop ds;
	/**	System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:1  CustomerArivallMean: .25 Max service time: 3");
		System.out.println("***********************************************************************");
		ds = new DonutShop(1, .25, 3); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)

		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:1  CustomerArivallMean: 2 Max service time: 12");
		System.out.println("***********************************************************************");
		ds = new DonutShop(1, 2, 12); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)

		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:2  CustomerArivallMean: .25 Max service time: 3");
		System.out.println("***********************************************************************");
		ds = new DonutShop(2, .25, 3); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)

		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:2  CustomerArivallMean: 2 Max service time: 12");
		System.out.println("***********************************************************************");
		ds = new DonutShop(2, 2, 12); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)
		
		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:4  CustomerArivallMean: .25 Max service time: 3");
		System.out.println("***********************************************************************");
		ds = new DonutShop(4, 2, 3); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)

		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:4  CustomerArivallMean: 2 Max service time: 12");
		System.out.println("***********************************************************************");
		ds = new DonutShop(4, 2, 12); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)

		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:8  CustomerArivallMean: .25 Max service time: 3");
		System.out.println("***********************************************************************");
		ds = new DonutShop(8, .25, 3); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)
		
		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:4  CustomerArivallMean: 2 Max service time: 12");
		System.out.println("***********************************************************************");
		ds = new DonutShop(8, 2, 12); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)
	**/
		System.out.println("***********************************************************************");
		System.out.println("Simulation on Servers:4  CustomerArivallMean: 2 Max service time: 3");
		System.out.println("***********************************************************************");
		ds = new DonutShop(4, 2, 3); // pass in the number of servers, mean of newCustPerMin, maxCustServTime
		ds.runSimulation(20);// pass in simulation run time (in minutes)

		
		
	}
}
