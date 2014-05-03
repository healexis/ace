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
			node = new Node( value, parent, null, null);
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
	private void printInOrderHelper( Node node ){
		if( node != null ){
			printInOrderHelper( node.left );
			System.out.print( " " + node.value + " " );
			printInOrderHelper( node.right );
		}
	}
	public void printInOrder(){
		System.out.print( "In order: " );
		printInOrderHelper( root );
		System.out.println();
	}
	private void printPreOrderHelper( Node node ){
		if( node != null ){
			System.out.print( " " + node.value + " " );
			printPreOrderHelper( node.left );
			printPreOrderHelper( node.right );
		}
	}	
	public void printPreOrder(){
		System.out.print( "Pre order: " );
		printPreOrderHelper( root );
		System.out.println();
	}
	private void printPostOrderHelper( Node node ){
		if( node != null ){
			printPostOrderHelper( node.left );
			printPostOrderHelper( node.right );
			System.out.print( " " + node.value + " " );
		}
	}	
	public void printPostOrder(){
		System.out.print( "Post order: " );
		printPostOrderHelper( root );
		System.out.println();
	}
	private int depthHelper( Node node, int depth ){
		if( node == null ){
			return depth;
		}
		return Math.max( depthHelper( node.left, depth + 1 ),
				depthHelper( node.right, depth + 1 ) );
	}
	private int depth(){
		return depthHelper( root, 0 );
	}
	private void printLevelOrderHelper( Node[] nodes, int width, int level ){
		boolean hasChildren = false;
		Node[] children = new Node[ nodes.length * 2 ];
		for( int n = 0; n < nodes.length; n++ ){
			Node node = nodes[ n ];
			int whitespaceWidth = ( int )( width * 2 / ( 1 + Math.pow( 2, level ) ) );
			for( int i=0; i < whitespaceWidth; i++ ){
				System.out.print( " " );
			}
			if( node == null ){
				System.out.print( " " );
			} else {
				System.out.print( node.value );
				children[ n * 2 ] = node.left;
				children[ n * 2 + 1 ] = node.right;
				hasChildren = true;
			}
		}
		System.out.println();
		if( hasChildren ){
			printLevelOrderHelper( children, width, level + 1 );
		}
	}
	public void printLevelOrder(){
		System.out.println( "Level order:" );
		Node[] nodes = new Node[] { root };
		// Increase the whitespace width to account for sampling issues. 
		printLevelOrderHelper( nodes, depth() * 4, 0 );
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
