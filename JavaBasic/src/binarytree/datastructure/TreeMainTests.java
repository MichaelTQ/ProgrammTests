package binarytree.datastructure;

public class TreeMainTests {
	public static void main(String[] args) {
		MyBST tree = new MyBST();
		tree.addNode(4);
		tree.addNode(2);
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(1);
		tree.addNode(3);
		tree.addNode(6);
		
		tree.traverse(ETraverseType.PRE);
		tree.traverse(ETraverseType.POST);
		tree.traverse(ETraverseType.IN);
		tree.traverse(ETraverseType.LEVEL);
		tree.myPrintTree();
	}
}
