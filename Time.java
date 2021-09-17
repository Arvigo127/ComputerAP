package main;
 
public class Time {
	public static void main(String[] args) {
		long date = System.currentTimeMillis(); 
		
		long time_elapsed = date/1000; 

		long hour_in_seconds = 1*60*60; 
		long day_in_seconds = hour_in_seconds * 24; 
		long year_in_seconds = day_in_seconds * 364; 
		
		long year_elapsed = time_elapsed/year_in_seconds;
		System.out.println("the year is " + (year_elapsed + 1970)); 
		
		long year_remainder = time_elapsed-(year_elapsed * year_in_seconds);  
		System.out.println(year_remainder/day_in_seconds); 
	}
}
