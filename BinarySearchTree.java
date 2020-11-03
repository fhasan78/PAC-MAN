/**
 * 
 * @author Fatima Hasan id 250895618
 * This class implements an ordered dictionary using a binary search tree. Each nodes of the tree will 
 * store a Pixel object; the attribute Location of the Pixel will be it's key.
 */
public class BinarySearchTree implements BinarySearchTreeADT  {
	private BinaryNode r;
/**
 * public BinarySearchTree() is the constructor of the class, that creates a tree whose root is a leaf node.
 */
	public BinarySearchTree(){
		this.r = null;
	}
/**
 * public BinaryNode getRoot() returns the root of the binary search tree
 * @return the root of the binary search tree
 */
	public BinaryNode getRoot() {
		return this.r;
	}

/**
 * The public Pixel get(BinaryNode r, Location key)  method returns the pixel storing the given key, if the key is stored
 * in the tree, otherwise returns null
 * @return the pixel storing the given key if found, null otherwise
 */
	public Pixel get(BinaryNode r, Location key) {
		if (r == null) return null;
		else{
			 if( r.getData().getLocation().compareTo(key) == 0){// root location is equal to the keys location
				return r.getData();
			}else if(r.getData().getLocation().compareTo(key) == 1){// root location is larger than the keys location
				return get(r.getLeft(), key);
			}else {
				return get(r.getRight(), key);//root location is smaller than key
			}
		}
	}
/**
 * The public void put (BinaryNode r, Pixel data) throws DuplicatedKeyException method inserts the given data in the tree if no data item with the same key is already there.
 *  If a node already stores the same key, the algorithm throws a DuplicatedKeyException.
 *  @param r the root of the binary search tree
 *  @param data the pixel data object to be stored in the node
 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
		BinaryNode node = new BinaryNode(data,null,null,r);
		if (r == null) {
			this.setRoot(node);
			node.setData(data);
			return;
		} if (r.getData().getLocation().compareTo(data.getLocation()) == 0){
			throw new DuplicatedKeyException("This pixel value already exists in the binary search tree.");
		}else if ((r.getData().getLocation().compareTo(data.getLocation()) == 1)){
			if (r.getLeft() == null) {
				r.setLeft(node);
				node.setParent(r);
			} else {
				put(r.getLeft(), data);					
			}
		}else {	
			if (r.getRight() == null) {
				r.setRight(node);
				node.setParent(r);
			} else {
				put(r.getRight(), data);			
			}
		}	
	}
/**
 * The private void setRoot(BinaryNode node) method sets the node as the root of the binary search tree
 * @param node the root to be
 */
	private void setRoot(BinaryNode r) {
		this.r = r;
	
}
/**
 * The public void remove(BinaryNode r, Location key) method removes the data item with the given key, if the key is stored in the tree
 * and throws an InexistentKeyException if the given key doesn't exist
 * @param r which is the root of the tree
 * @param key which is the key to the data item to be removed
 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		Pixel toRemove = get(r, key);
		if (toRemove == null)
			throw new InexistentKeyException("the node with the key's location not exist");
		this.setRoot(removeHelper(r, key));
	}

/**
 * The public BinaryNode removeHelper(BinaryNode r, Location key)  method is a helper method to the remove method,
 * @param r
 * @param key
 * @return BinaryNode
 */
	public BinaryNode removeHelper(BinaryNode r, Location key) {
	    if(r == null){
	        return null;
	    }
		
		// root's location greater than key
	    if(r.getData().getLocation().compareTo(key) == 1){	
	        r.setLeft(removeHelper(r.getLeft(), key));
	    }
		// root's location smaller than key
	    else if(r.getData().getLocation().compareTo(key) == -1){
	        r.setRight(removeHelper(r.getRight(), key));
	    }
	    // root's location is key
	    else{
	        if(r.getLeft() == null){
	            return r.getRight();
	        }else if(r.getRight() == null){
	            return r.getLeft();
	        }
	        //both nodes of the node to be removed node are internal nodes
	        BinaryNode smallest = smallestNode(r.getRight());
	        r.setData(smallest.getData());
	        r.setRight(removeHelper(r.getRight(), r.getData().getLocation()));
	    }
	    return r;
	}
/**
 * The private BinaryNode smallestNode(BinaryNode node) method is the same as the smallest method except it returns a binary node 
 * instead of a pixel.
 * @param root of the binary search tree
 * @return the smallest binary node in the tree.
 */
	private BinaryNode smallestNode(BinaryNode root){
	    while(root.getLeft() != null){
	        root = root.getLeft();
	    }
	    return root;
	}
/**
 * The public Pixel successor(BinaryNode r, Location key) method returns the pixel with the smallest key larger than
 * the given one
 * @param r which is the root of the tree
 * @param key which is the specified key to get it's successor
 * @return Pixel which is the successor of the key
 */
	public Pixel successor(BinaryNode r, Location key) {
		if (r == null) return null;
		if (r.getData().getLocation().compareTo(key) <= 0){
			return successor(r.getRight(), key);
		}else{
			 
	    	if (successor(r.getLeft(), key) != null){
	    		return successor(r.getLeft(), key) ;
	    	} else{
	    		return r.getData();
	    	}
		}
	}
/**
 * The public Pixel predecessor(BinaryNode r, Location key) method returns the pixel with the largest key 
 * smaller than the given one
 * @param r which is the root of the tree
 * @param key which is the specified key to get its predecessor
 * @return Pixel which is the predecessor of key
 */
	public Pixel predecessor(BinaryNode r, Location key) {
		
		if (r == null) return null;
		if (r.getData().getLocation().compareTo(key) >= 0){
			return predecessor(r.getLeft(), key);
		}else{
		
	    	if (predecessor(r.getRight(), key) == null){
	    		return r.getData();
	    		
	    	} else{
	    		return predecessor(r.getRight(), key);
	    	}
		}
		
	}
/**
 * public Pixel smallest(BinaryNode r) throws EmptyTreeException method returns the Pixel with the smallest key. 
 * Throws an EmptyTreeException if the tree does not contain any data
 * @param r which is the root of the binary search tree
 * @throws EmptyTreeException
 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		if (r == null) 
			throw new EmptyTreeException("The root of the binary search tree is empty");
		while (!r.isLeaf()) {
			r = r.getLeft();
		}
		return r.getData();
	}
/**
 * public Pixel largest(BinaryNode r) throws EmptyTreeException method eturns the Pixel with the largest key. 
 * Throws an EmptyTreeException if the tree does not contain any data.
 * @param r which is the root of the binary search tree.
 * @throws EmptyTreeException
 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		if (r == null)
			throw new EmptyTreeException("The root of the binary search tree is empty");
		while (!r.isLeaf()){
			r = r.getRight();
		}
		return r.getData();
	}
}
