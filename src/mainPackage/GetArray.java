// used package
package mainPackage;

// used libs
import java.util.ArrayList;
import java.util.Random;

// array class
public class GetArray {
	
	// array method
	public static ArrayList<String> create2DArray(int rows) {
		
		// configure variables / objects
		ArrayList<String> array = new ArrayList<String>();
		Random r = new Random();
		
		// adds a random number to arraylist
		for (int i = -rows; i != rows*rows; i++) {

			array.add(String.valueOf(r.nextInt(2)));
		
		}
		
		// returns arraylist
		return array;
		
	}

}
