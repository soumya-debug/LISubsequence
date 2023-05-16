package com.main;
import java.util.*;

public class LISDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//Collect length of subsequence
		System.out.println("How long of a subsequence do you have?");
		int n = sc.nextInt();

		int[] sub = new int[n];
		//Collect values of the subsequence
		for(int i = 0; i < n; i++){
			System.out.println("Enter value #" + (i+1) + " of the subsequence");
			sub[i] = sc.nextInt();
			System.out.println();
		}

		//Method to find longest increasing subsequence
		longestIncSub(sub);
	}

	public static void longestIncSub(int[] sub){
		int n = sub.length, max = 0, lastIn = 0;
		String longest = ""; //Will hold values
		int[] L = new int[n]; //Holds longest inc subsequence to that point of the subsequence
		int[] C = new int[n]; //Holds what previous value it connects to/comes after

		//Initial values for L and C arrays
		for(int i = 0; i < n; i++){
			L[i] = 1;
			C[i] = -1;
		}

		//Traverse subsequence
		for(int i = 1; i < n; i++){
			for(int j = i-1; j >= 0; j--){
				//Check if the length value could be increased by the value we are checking & that value is less than value we are on
				if(L[j] + 1 > L[i] && sub[j] < sub[i]){
					L[i] = L[j] + 1;
					C[i] = j;
				}
			}
		}

		//Finds the value of the longest inc subsequence and the index of that value
		for(int i = 0; i < n; i++){
			if(L[i] > max){
				max = L[i];
			}
			lastIn = i;
		}

		longest += sub[lastIn]; //Adds value to answer string
		lastIn = C[lastIn]; //the index gets updated so it moves to index that comes prior

		while(lastIn != -1){ //Continues until we reach beginning of the desired subsequence
			longest = sub[lastIn] + ", " + longest;
			lastIn = C[lastIn];
		}

		//Output
		System.out.println("The longest increasing subsequence has a length of " + max + " and is " + longest);
	}
}

