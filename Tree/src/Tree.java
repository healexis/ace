public class Tree {
	/* Simple BST tree. */
	private Node root;
	public Tree( int[] values ){
		if( values == null || values.length == 0 ){
			return;
		}
		for( int value : values ){
			insert( value );
		}
	}
	private void insertHelper( int value, Node node, Node parent ){
		if( node == null){
			node = new Node( value, null, null, parent);
			if( value <= parent.value ) {
				parent.left = node;
			} else {
				parent.right = node;
			}
		} else {
			if( value <= node.value ){
				insertHelper( value, node.left, node );

			} else {
				insertHelper( value, node.right, node );
			}
		}
	}
	private void insert( int value ){
		if( root == null ){
			root = new Node( value, null, null, null);
		} else{
			insertHelper( value, root, null );
		}
	}
	private void printHelper( Node node ){
		if( node != null ){
			System.out.print( root.left );
			System.out.print( node.value );
			System.out.print( node.right );
		}
	}
	public void print(){
		printHelper( root );
	}
	private boolean isValidHelper( Node node ){
		if( node == null ){
			return true;
		}
		if ( node.parent == null ){
			return true; // we're at the root
		}
		if( node == node.parent.left ){
			assert node.value <= node.parent.value;
		}
		if( node == node.parent.right ){
			assert node.value > node.parent.value;
		}
		return isValidHelper( node.left ) && isValidHelper( node.right );
	}
	public boolean isValid(){
		return isValidHelper( root );
	}
}
