package com.damelyngdoh.codemine.friendstrip;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dame Lyngdoh
 *
 */
public class FriendsTrip {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int carsCount = in.nextInt();
		int carCapacities[] = new int[carsCount];
		int personsInCar[] = new int[carsCount];
		
		for(int i = 0; i < carsCount; i++) {
			carCapacities[i] = in.nextInt();
		}
		for(int i = 0; i < carsCount; i++) {
			personsInCar[i] = in.nextInt();
		}
		in.close();
		
		System.out.println(minimumCars(personsInCar, carCapacities));
	}
	
	/**
	 * Method that returns the minimum number of cars required.
	 * @param p Array of count of people traveling in each vehicle.
	 * @param s Array of maximum capacities of the vehicles.
	 * @return Integer for minimum number of cars required.
	 */
	public static int minimumCars(int[] p, int[] s) {
		int requiredCars = 0;
		
		// Sorting the array of cars capacities
		Arrays.sort(s);
		int totalPassengers = 0;
		
		// Counting the total number of people involved in the trip
		for(int i = 0; i < p.length; i++) {
			totalPassengers += p[i];
		}
		
		// Starting from the car with the maximum capacity and then 
		// proceeding to cars with lower capacities we keep reducing 
		// the total number of people by the cars capacity until there 
		// are no more remaining people to accommodate
		for(int i = s.length - 1; totalPassengers > 0; i--) {
			totalPassengers -= s[i];
			requiredCars++;
		}
		return requiredCars;
	}

}
