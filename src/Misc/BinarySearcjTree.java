package Misc;

public class BinarySearcjTree<Data extends Comparable<Data>> {

	TreeNode<Data> root;
	
	/*public BinarySearcjTree(TreeNode root){
		
		this.root = root;
	}
	*/
	public BinarySearcjTree() {
	}

	public static void main(String []args){
		BinarySearcjTree<Integer> tree = new BinarySearcjTree<>();
		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
		tree.insert(1);
		tree.insert(11);
		tree.insert(16);
		tree.insert(12);
		tree.insert(15);
		
		tree.inOrderTraversal();
		
		Integer n = tree.inorderSuccessor(11);
		System.out.println("n = "+n);
		
	}
	
	public void insert(Data data){
		if(data == null){
			return;
		}
		
		TreeNode<Data> node = new TreeNode<>(data);
		if(root == null){
			root = new TreeNode<Data>(data);
			
		}
	
		else{
			TreeNode<Data> newRoot = root;
			TreeNode<Data> oldRoot = newRoot;

			while(newRoot != null){
				oldRoot = newRoot;
				if(newRoot.compareTo(node) > 0){
					newRoot = newRoot.leftChild;
					
				}
				
				else if(newRoot.compareTo(node) <= 0){
				
					newRoot = newRoot.reightChild;
					
				}
				
			}
			
			if(oldRoot.compareTo(node) > 0){
				oldRoot.leftChild = node;
			}
			else{
				oldRoot.reightChild = node;
			}
			
		}
	}
	
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	
	public void inOrderTraversal(TreeNode<Data> node){
		if(node == null){
			return ;
		}
		inOrderTraversal(node.leftChild);
		visit(node);
		inOrderTraversal(node.reightChild);	
		
	}
	
	public TreeNode<Data> inOrderSuccessor(TreeNode<Data> treeNode, Data key){
		
		if(treeNode == null){
			return  null;
		}
		
		System.out.println("On Node : "+treeNode.data);
		
		if(treeNode.data.compareTo(key) == 0){
			while(treeNode.reightChild != null){
				treeNode = treeNode.reightChild;
			}
			
			while(treeNode.leftChild != null){
				treeNode = treeNode.leftChild;
			}
			
			return treeNode;
		}
					
		TreeNode<Data> node1= inOrderSuccessor(treeNode.leftChild, key);
		visit(treeNode);
		TreeNode<Data> node2=  inOrderSuccessor(treeNode.reightChild, key);
			
		return (node1 == null) ? node2:node1;

		
			
		
	}
	public Data inorderSuccessor(Data key){
		
		return inOrderSuccessor(root,key).data;
				
		
	}
	
	public void visit(TreeNode node){
		if(node == null){
			return;
		}
		System.out.println(node.getData());
	}
}
