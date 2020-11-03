/**
 * 
 * @author Fatima Hasan 
 * This class represents the nodes of the binary search tree. Each node will store an object of the class Pixel
 * and it will have references to its left child, its right child, and its parent.
 */
public class BinaryNode {
	
//Declaring variables
	private Pixel value;
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode parent;
/**
 * The public BinaryNode (Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) is the constructor for this 
 * class. It stores the pixel in the node and sets left child, right child, and parent to the specified values.
 * @param value which is the pixel that is to be stored in the node
 * @param left which is the left child of the node
 * @param which is right right child of the node
 * @param parent which is the parent of the node
 */
	public BinaryNode (Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
/**
 * public BinaryNode() is a constructor for this class that initializes a leaf node. The data, children, and parent 
 * are set to null.
 * @param value
 */
	public BinaryNode(){
		this.value = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	} 
/**
 * The public BinaryNode getParent() method returns the parent of this node
 * @return the parent of the node 
 */
	public BinaryNode getParent() {
		return this.parent;
	}
/**
 * The public void setParent(BinaryNode parent) method sets the parent of this node to the specified value 
 * @param parent which is the new specified value to be set to the parent of the node
 */
	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}
/**
 * The public void setLeft (BinaryNode p) method sets the left child of this node to the specified value
 * @param p which will be the value of the left child.
 */
	public void setLeft (BinaryNode p) {
		this.left = p;
	}
/**
 * The public void setRight (BinaryNode p) method sets the right child of this node to the specified value
 * @param p which will be the value of the right child.
 */
	public void setRight (BinaryNode p) {
		this.right = p;
	}
/**
 * The public void setData (Pixel value) method stores the given pixel in this node
 * @param value is the given pixel to be stored in the node
 */
	public void setData (Pixel value) {
		this.value = value;
	}
/**
 * The public boolean isLeaf() method returns true if this node is a leaf and false otherwise.
 * @return true if leaf, false otherwise
 */
	public boolean isLeaf() {
		if (this.left == null && this.right == null){
			return true;
		}
		return false;
	}
/**
 * The public Pixel getData () method returns the pixel object stored in this node.
 * @return the pixel object in this node
 */
	public Pixel getData() {
		return this.value;
	}
/**
 * The public BinaryNode getLeft() method returns the left child of this node
 * @return left child of this node
 */
	public BinaryNode getLeft() {
		return this.left;
	}
/**
 * The public BinaryNode getRight() method returns the right child of this node
 * @return right child of this node
 */
	public BinaryNode getRight() {
		return this.right;
	}
}
