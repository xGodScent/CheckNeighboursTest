// package
package mainPackage;

import java.util.ArrayList;

// main class
public class GetNeighbours {

	// variables
	static ArrayList<String> pos = new ArrayList<String>();
	
	
	// neighbours 4 method
	public static ArrayList<String> requestN4(ArrayList<String> array) {
		
		int mid = array.indexOf("_");
		
		String right = array.get(mid + 1);
		right.replace("0", "\u00A4");
		right.replace("1", "c");
		pos.add(right);
		
		String left = array.get(mid - 1);
		left.replace("0", "\u00A4");
		left.replace("1", "c");
		pos.add(left);

		pos.add(array.get(mid));
		
		String top = array.get(array.size() / 4 - 1);
		top.replace("0", "\u00A4");
		top.replace("1", "c");
		pos.add(top);

		String bottom = array.get((array.size() - (array.size() / 4)) - 1);
		bottom.replace("0", "\u00A4");
		bottom.replace("1", "c");
		pos.add(bottom);
		
		
		return pos;
	}	
	
	// neighbours 8 method
	public static ArrayList<String> requestN8(ArrayList<String> array) {
			
			
		return pos;
	}
	
}
