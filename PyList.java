package main;

/***
 * Flexible Python Style Arrays in Native Java
 * Currently only for arrays of doubles, could be adapted for a generic
 * @author Arvigo127
 *
 */

public class PyList{
	private static double[] list; 
	
	public PyList(int size) {
		if (size < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+ size);
		list = new double[size]; 
	}
	
	public double[] toArray() {
		return list; 
	}
	
	public String print(double[] input) {
		String result = "["; 
		
		for(int i = 0; i<input.length; i++) {
			result = result.concat(String.valueOf(input[i])); 
			
			if(i != input.length-1) {
				result = result.concat(", "); 
			}
		}
		result = result.concat("]"); 
		return result; 
	}
	
	public String print() {
		return print(list); 
	}
	
	public void add(double a) {
		double[] temp_list = new double[list.length]; 
		
		for(int i = 0; i<list.length; i++) {
			temp_list[i] = list[i]; 
		}
		
		list = new double[temp_list.length+1]; 
		
		for(int i = 0; i<temp_list.length; i++) {
			list[i] = temp_list[i]; 
		}
		
		list[list.length-1] = a; 
	}
	
	public void removeByIndex(int index) {
		if (index<0 || index>list.length-1) 
			throw new IllegalArgumentException("Index out of bounds: "+index); 
		double[] temp_list = new double[list.length-1]; 
		
		for(int i = 0; i<list.length; i++) {
			if(i<index) {
				temp_list[i] = list[i]; 
			} else if (i==index) {
				//don't think I need anything in here but I'll leave it for old times sake
			} else if (i>index) {
				temp_list[i-1] = list[i]; 
			}
		}
		
		list = new double[temp_list.length]; 
		
		for(int i = 0; i<list.length; i++) {
			list[i] = temp_list[i]; 
		}
		
	}
	
	//lot of redundant for loops, but what works works
	public void removeByValue(double value) {
		int sizeToReduce = count(value); 
		
		
		if(sizeToReduce ==0) {
			return; 
		}
		
		double[] temp_list = new double[list.length-sizeToReduce]; 
		
		int index = 0; 
		
		for(double x: list) {
			if(x!=value) {
				temp_list[index] = x; 
				index++; 
			}
		}
		
		list = new double[temp_list.length]; 
		
		for(int i = 0; i<temp_list.length; i++) {
			list[i] = temp_list[i]; 
		}
	}
	
	public double max(double[] input) {
		if(input.length == 0) {
			return 0; 
		}
		
		double max = input[0];
		
		for(double x: input) {
			if(x>max) {
				max = x; 
			}
		}
		return max; 
	}
	
	public double max() {
		return max(list); 
	}
	
	public double min(double[] input) {
		if(input.length == 0) {
			return 0;
		}
		double min = input[0];
		
		for(double x:input) {
			if(x<min) {
				min = x; 
			}
		}
		return min; 
	}
	
	public double min() {
		return min(list); 
	}
	
	public int count(double a) {
		int count = 0; 
		
		for(double x: list) {
			if(x==a) {
				count++; 
			}
		}
		return count; 
	}
	
	public double index(int a) {
		if(a<0) {
			return list[list.length+a]; 
		}
		return list[a]; 
	}
	
}
