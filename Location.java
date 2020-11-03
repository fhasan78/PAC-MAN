/**
 * 
 * @author Fatima Hasan id 250895618
 * This class represents the position (x,y) of a pixel.
 */
public class Location {
private int x;
private int y;
/**
 * public Location(int x, int y) is the constructor that initializes the Location 
 * object with the specified coordinates.
 * @param x coordinate that represents position
 * @param y coordinate that represents position 
 */
public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
/**
 * The public int xCoord() method returns the x coordinate of this Location
 * @return int x coordinate of a location
 */
public int xCoord(){
	return this.x;
}
/**
 * The public int yCoord() method returns the y coordinate of this Location.
 * @return int y coordinate of a location.
 */
public int yCoord(){
	return this.y;
}
/**
 * The public int compareTo (Location p) method compares is used  to compare a location with p using column order
 * @param p
 * @return 1 is location greater that p, 0 if equal to p and -1 if less than p.
 */
public int compareTo (Location p){
	if (this.x > p.x){
		return 1;
	}else if(this.x < p.x){
		return -1;
	}else{
		if (this.y < p.y) {
			return -1;
		}else if (this.y > p.y){
			return 1;
		}else {
			return 0;
		}
	}
}
}
