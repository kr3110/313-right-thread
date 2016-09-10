/*******************************************************
 * 			Project2.Java			 							
 * 		CSCI 313-Data Structures							 
 * @author Kevin Reinoso		 
 * @version 1.0					 
 * @since 	2016-08-01			 
 * 		
 * 		Summary	
 *	Reads a file from args.
 *	Create a tree and insert the elements. 
 *	Right thread the tree.
 *	Print the tree as inOrder without using Recursive function.
 *	Keep doing these until the file is empty. 
 *			 
 ********************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
public class project2 {
	public static void main(String[] args) {
		FileReader file;
		BufferedReader infile;
		String line;
		BinaryTree t;		
			try	{	
				file=new FileReader(args[0]);
				infile=new BufferedReader(file);
				int i=1;
				while((line=infile.readLine())!=null)	{
					System.out.println("Set "+ i+" of numbers");
					String number[]=line.split(" ");
					t=new BinaryTree(Integer.parseInt(number[0]));
					for(int j=1;j<number.length; j++)
					{
						BinaryTree.insert(t, Integer.parseInt(number[j]));
					}
					BinaryTree.RightThread(t, null);// right thread
					System.out.println("Inorder Traversal");
					BinaryTree.traversal(t);//traversal loop
					t.makeEmpty();
					i++;
					System.out.println();
				}
			}
			catch(Exception e)	{	 System.out.println(e);	}
			}	
}
