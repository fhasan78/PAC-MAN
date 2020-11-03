/**
 * 
 * @author Fatima Hasan 
 * This class represents the data items to be stored in the binary search tree. Each data item consists 
 * of two parts: a Location and an int color.
 */
public class Pixel {
//Declaring variables
	private Location p;
	private int color;
/**
 * public Pixel(Location p, int color) is the constructor which initializes the new pixel with the specified
 * coordinates and color.
 * @param p is the key for the Pixel
 * @param color the color of the pixel
 */
	public Pixel(Location p, int color) {
		this.p = p;
		this.color = color;
	}
/**
 * public Location getLocation() method returns the location of the pixel
 * @return the location of the pixel(p , which is the key of the pixel)
 */
	public Location getLocation() {
		return this.p;
	}
/**
 * public int getColor() method returns the color of the pixel.
 * @return the color of the pixel
 */
	public int getColor() {
		return this.color;
	}
}