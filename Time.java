package main;
 
public class Time {
	public static void main(String[] args) {
		long millisecond_time = System.currentTimeMillis(); 
		
		long seconds_elapsed = millisecond_time/1000; 
		long minutes_elapsed = seconds_elapsed/60; 
		long hours_elapsed = minutes_elapsed/60;
		long minutes_today = minutes_elapsed%60;  
		long hours_today = (hours_elapsed%24)-4; 
 
		if (hours_today > 12) {
			System.out.println((hours_today) + ":" + minutes_today + "PM"); 
		} else {
			System.out.println(hours_today + ":" + minutes_today + "AM"); 
		}
		System.out.println(); 
		
	}
}
