/**
 * 2019年7月18日
 * Administrator
 */
/**
* @author Brady
* @version 2019年7月18日 下午3:04:11
*/
public class _07重建二叉树 {

	public static void main(String[] args) {
		
	}
	
	public static Node conTree(int[] pre, int[] in) {
		Node root = new Node(pre[0]);
		if(pre.length == 0 && in.length == 0)
			return null;
		return null;
	}
}

class Node {
	int value;
	Node LNode;
	Node RNode;
	
	public Node(int value) {
		this.value = value;
		LNode = null;
		RNode = null;
	}
	public Node(int value, Node n, String dir) {
		if(dir.equals("R") || dir.equals("r"))
			this.RNode = n;
		else if(dir.equals("L") || dir.equals("l")) {
			this.LNode = n;
		}
		else {
			System.out.println(new IllegalArgumentException("Illegal input!"));
		}
	}
}
