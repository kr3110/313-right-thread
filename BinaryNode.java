/********************************************************
 * 			BinaryNode.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-08-01			 
 * 								 
 *	 Constructor Summary:
 *BinaryNode(int e) 
 * 		Pass an integer an set it to element field, with null for the other members.		
 * BinaryNode(int e, BinaryNode ln, BinaryNode rn)
 * 		pass an integer and 2 nodes, ln and rn, and set it to the fields members.
 * 
 *	  Methods Summary:
 *int nodeCount(BinaryNode n)
 *		Pass a BinaryNode an return an integer representing how many nodes has 
 *int height(BinaryNode n)
 * 		Pass a BinaryNode an return an integer with the height.
 *	
 *******************************************************/
public class BinaryNode 
{
	int element;
	BinaryNode left;
	BinaryNode right;
	boolean rightthread=false;
		 
	BinaryNode(int e) 								{this(e,null,null);	}
	BinaryNode(int e, BinaryNode ln, BinaryNode rn)	{element=e; left=ln;; right=rn;}
		
	static int nodeCount(BinaryNode n)	{
		if(n==null) return 0;
		return 1+nodeCount(n.left)+nodeCount(n.right);
	}
	static int height(BinaryNode n)	{
		if(n==null) return -1;
		return 1+Math.max(height(n.left), height(n.right));
	}	
}
