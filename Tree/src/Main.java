
public class Main {
	private static void print( int[] values ){
		System.out.print( "values: " );
		if( values == null ) {
			System.out.println( "null" );
		} else {
			for( int value : values ){
				System.out.print( value + " " );
			}
			System.out.println();
		}		
	}
	private static void testTree( int[] values ){
		print( values );
		Tree tree = new Tree( values );
		tree.printInOrder();
		tree.printPreOrder();
		tree.printPostOrder();
		tree.printLevelOrder();
		assert tree.isValid();
		System.out.println();
	}
	public static void main(String[] args){
		testTree( null );

		int[] test2 = new int[] { 1 };
		testTree( test2 );
		
		int[] test3 = new int[] { 4,3,2,1 };
		testTree( test3 );
		
		int[] test4 = new int[] { 5,6,7,8 };
		testTree( test4 );
		
		int[] test5 = new int[] { 5,3,7,43,6,8,0 };
		testTree( test5 );

		int[] test6 = new int[] { 3,2,-5,-6,43,3,-6,4,2 };
		testTree( test6 );
	}

}
