package Tree;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

public class BottomViewBinaryTree {

	public void printBottomView(Node root, int hd){
		TreeMap<Integer,ArrayList<Integer>> verticalMap = new TreeMap<>();
		verticalMap = createVerticalOrder(root, hd, verticalMap);
		if(verticalMap != null){
			 for (Entry<Integer, ArrayList<Integer>> entry : verticalMap.entrySet()) {
			            System.out.println(entry.getValue().get(entry.getValue().size() - 1));
			    }
		}
	}
	
	public static TreeMap<Integer,ArrayList<Integer>> createVerticalOrder
			(Node root, int hd,TreeMap<Integer,ArrayList<Integer>> verticalMap){
		
		if(root != null){
			if(!verticalMap.containsKey(hd))
				verticalMap.put(hd,new ArrayList<Integer>());
			verticalMap.get(hd).add(root.key);
			createVerticalOrder(root.left, hd-1,verticalMap);
			createVerticalOrder(root.right, hd+1,verticalMap);
		}
		return verticalMap;
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		
		BottomViewBinaryTree bottomViewObject = new BottomViewBinaryTree();
		bottomViewObject.printBottomView(root, 0);
	}
}
