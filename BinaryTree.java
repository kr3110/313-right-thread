
/*******************************************************
 * 			BinaryTree.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-08-01			 
 * 								 
 *	 Constructor Summary:
 *public BinaryTree()	
 * 		Default constructor.		
 * public BinaryTree(int x)
 * 		pass an integer and create a new Binary Node.
 * 
 *	  Methods Summary:
 *public Boolean IsEmpty()
 *		return true if the tree is empty, otherwise false.
 *public void makeEmpty()
 * 		empty the tree.
 *public int nodeCount()
 *		Return the node Count of the tree
 *public int height() 
 *		Return the height of the tree
 *public int getRootObj() 
 *		return the element of the root
 *public void setRootObj(int x)
 *		pass an int an set it as the root element
 *public BinaryTree getLeft()
 *		return a tree of the left child and his child respectively.
 *public BinaryTree getRight()
 *		return a tree of the right child and his child respectively.
 *public static void InOrder(BinaryTree t)
 *		pass a BinaryTree and print it using InOrder traversal recursively.
 *public static int sum(BinaryTree t)
 *		pass a BinaryTree and sum it's element and return an int with the total sum.
 *public static void RightThread(BinaryTree t)
 *		pass a BinaryTree and Right thread,  
 *public static void traversal(BinaryTree t)
 *		pass a Binary Tree and traverse it using its right child when is a right thread.
 *public static BinaryTree insert(BinaryTree t,int x)
 *		Pass a BinaryTree and an int, insert the int in the tree an return the tree with the element inserted.
 *******************************************************/
public class BinaryTree {
	private BinaryNode root;
	public BinaryTree()		{
		root =null;
	}	
	public BinaryTree(int x)		{
		root= new BinaryNode(x);
	}
	public Boolean IsEmpty() {return root==null;}
	public void makeEmpty() {root=null;}
	public int nodeCount()     {return BinaryNode.nodeCount(root);}
	public int height() 	     {return BinaryNode.height(root);}
	
	public int getRootObj() throws BinaryTreeException{
		if(root==null) throw new BinaryTreeException("Empty tree");
		else
		    return root.element; 
	}			
		
	public void setRootObj(int x) throws BinaryTreeException{
		if(root==null) throw new BinaryTreeException("Empty tree");
		else
			root.element=x;	
	}

	public BinaryTree getLeft() throws BinaryTreeException{
		if(root==null) throw new BinaryTreeException("Empty tree");
		else 	{
			BinaryTree t=new BinaryTree();
			t.root=root.left;
			return t;
		}
	}
		
	public BinaryTree getRight() throws BinaryTreeException{
		if(root==null) throw new BinaryTreeException("Empty tree");
		else 	{
			BinaryTree t=new BinaryTree();
			t.root=root.right;
			return t;
		}
	}
		
	public void setLeft(BinaryTree t) throws BinaryTreeException{
		if(root == null) throw new BinaryTreeException ("Empty Tree");
		else 
		  root.left=t.root;
	} 

	public void setRight (BinaryTree r) throws BinaryTreeException	{ 
		if(root == null) throw new BinaryTreeException ("Empty Tree");
		else 
		  root.right=r.root;
	} 
		
	public static void InOrder( BinaryTree t) throws BinaryTreeException{
		if (!t.IsEmpty())
		{
			InOrder(t.getLeft());
			System.out.println(t.getRootObj());
			InOrder(t.getRight());
			}
	}

	public static int sum(BinaryTree t) throws BinaryTreeException	{
		if(t.IsEmpty()) return 0;
		return((Integer) t.getRootObj()).intValue()+ sum(t.getLeft()) + sum(t.getRight());
	}

	public static void RightThread(BinaryTree t, BinaryNode p)	{
		if(t==null) 
			return;
		if(t.root.left!=null)			
			RightThread(t.getLeft(),t.root);
		if(t.root.right!=null)		
			RightThread(t.getRight(),p);
			else	{
			t.root.rightthread=true;
			t.root.right=p;
			if(p!=null)
				System.out.println(t.getRootObj()+" --> "+p.element);	
			else
				System.out.println(t.getRootObj()+" --> \u2205" );//\u2205 is empty set 
			}
	}
	public static void traversal(BinaryTree t)	{
		BinaryNode i=t.root;
		while(i.left!=null)
			i=i.left;
		while(i!=null)	{
			System.out.print(i.element+ " -- ");									
			if(!i.rightthread)	{
				i=i.right;									
				if(i!=null)							
					while(i.left!=null)							
						i=i.left;						
			}
			else
				i=i.right;	
			}
		System.out.print("\u2205 \n");
		}
	public static BinaryTree insert(BinaryTree t,int x)	{
		if(t.IsEmpty())	{
			return new BinaryTree (x);
		}
		else	{
			if(t.getRootObj()<x)
				t.setRight(insert(t.getRight(),x));
			else 
				t.setLeft(insert(t.getLeft(),x));
			return t;
		}
	}
	

public class BinaryTreeException extends RuntimeException
{
	BinaryTreeException(String Err)
	{
		super(Err);
	}
}

}

