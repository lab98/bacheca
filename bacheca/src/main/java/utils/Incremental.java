/**
 * 
 */
package utils;

/**
 * @author lucalabarbera
 *
 */
public class Incremental {

	 private static int instanceCount = 0;
	 
	 public Incremental() {
		 instanceCount++;
	 }
	 public static int getInstanceCount() {
	        return instanceCount;
	    }
}
