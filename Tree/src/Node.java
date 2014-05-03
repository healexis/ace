
public class Node {
	public int value;
	public Node parent, left, right;
	public Node( int myValue, Node myParent, Node myLeft, Node myRight ){
		value = myValue;
		parent = myParent;
		left = myLeft;
		right = myRight;
	}
}
