/**
 * 
 * @author Fatima Hasan
 * This class represents graphical objects. The types of graphical objects are: fixed, user, computer, and target
 *
 */
public class GraphicalObject implements GraphicalObjectADT {
//Declaring variables
	private int id;
	private int width;
	private int height;
	private String type;
	private Location pos;
	private BinarySearchTree tree;
/**
 * This is the constructor of the class, it creates an empty binary search tree, where the pixels of 
 * the graphical object will be stored.
 * @param id identifier of this graphical object
 * @param width which is the width of the enclosing rectangle for this graphical object
 * @param height which is the height of the enclosing rectangle for this graphical object
 * @param type which is type of the graphical object
 * @param pos which is the offset of the object 
 */
	public GraphicalObject(int id, int width, int height, String type, Location pos) {
		tree = new BinarySearchTree();
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
	}

/**
 * The public int getWidth() method returns the width of the enclosing rectangle for this graphical object
 * @return width for the rectangle for the graphical object
 */
	public int getWidth() {
		return this.width;
	}

/**
 * The public int getHeight() method returns the height of the enclosing rectangle for this graphical object
 * @return height for the enclosing rectangle for this graphical object
 */
	public int getHeight() {
		return this.height;
	}

/**
 * The public String getType() method returns the type of this graphical object
 * @return the type of the graphical object
 */
	public String getType() {
		return this.type;
	}
/**
 * The public int getId() method returns the identifier of this graphical object.
 * @return id of the graphical object
 */
	public int getId() {
		return this.id;
	}
/**
 * The public Location getOffset() method returns the offset of this graphical object
 * @return pos of the graphical object 
 */
	public Location getOffset() {
		return this.pos;
	}
/**
 * The public void settOffset(Location value) method changes the offset of this graphical object to the value specified
 * @param value which the offset value to be.
 */
	public void setOffset(Location value) {
		this.pos = value;
	}
/**
 * The public void setType(String t) method sets the type of this graphical object to the specified value
 * @param type of the graphical object
 */
	public void setType(String type) {
		this.type = type;
		
	}
/**
 * The public void addPixel(Pixel pix) inserts pix into the binary search tree associated with this graphical object.
 * It throws a DuplicatedKeyException if an error occurs when inserting the Pixel in the tree.
 * @param pix which is the pixel to be inserted into the tree.
 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		try{
			tree.put(tree.getRoot(), pix);
		} catch (DuplicatedKeyException e){
			throw new DuplicatedKeyException("Pixel already exists in the binary search tree");
		}
		
	}
/**
 * public boolean intersects(GraphicalObject gobj)  method returns true if this graphical object intersects 
 * the one specified one in the parameter, and false otherwise.
 * @param gobj 
 * @return true if intersects and false otherwise
 */
	public boolean intersects(GraphicalObject gobj) {
		//declaring and initializing variable of this graphical object
		int top = this.getOffset().yCoord();
		int bottom = this.getOffset().yCoord() + this.getHeight();
		int left = this.getOffset().xCoord();
		int right = this.getOffset().xCoord() + this.getWidth();
		//declaring and initializing variables of the specified graphical object
		int gobjtop = gobj.getOffset().yCoord();
		int gobjbottom = gobj.getOffset().yCoord() + gobj.getHeight();
		int gobjRight = gobj.getOffset().xCoord() + gobj.getWidth();
		int gobjLeft = gobj.getOffset().xCoord();
		//checking x coordinates
		if (left > gobjRight || right < gobjLeft){
			return false;
		}else{// checking y coordinates
			if(top > gobjbottom || bottom < gobjtop){
				return false;
			} return true;
		}
	}

}
