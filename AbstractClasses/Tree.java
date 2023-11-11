package AbstractClasses;

import java.util.Iterator;

import AbstractClasses.TreeNode;

public abstract class Tree<E> {

    
    TreeNode<E> root;
    int size;
    int height;

    //add/remove elements
    public abstract void insert(int data);
    public abstract void delete(int data);
    abstract TreeNode<E> deleteNode(TreeNode<E> root, int data); // Helper method for deleting a node.


    //traverse the structure
    public Iterator<E> DFSIterator(){

        class DFSTraverser implements Iterator<E>{
        
            Tree<E> t;
            boolean[] iterated;
            
            public DFSTraverser(Tree<E> x){
                
            }

            @Override
            public boolean hasNext() {
                return this.peekNext() != null;
            }

            public E peekNext(){

            }

            @Override
            public E next() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'next'");
            }
        }
    }
    public abstract Iterator<E> preOrderTraversal();
    public abstract Iterator<E> postOrderTraversal();
    public abstract Iterator<E> BFSTraversal();


    //general information
    public int size(){
        return this.size;
    }

    public int height(){
        return this.height;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int countLeaves(){

    }


    public int diameter(); // Find the diameter (longest path between two leaf nodes) of the binary tree.
    public boolean isBalanced(); // Check if the binary tree is balanced.
    private boolean isBalancedUtil(TreeNode node); // Helper method for checking balance.


    //binary search
    public boolean contains(int data);
    

    //node objects
    public int getData(); // Get the data of a node.
    public void setData(int data); // Set the data of a node.
    public boolean isLeaf(); // Check if a node is a leaf.
    public int getDepth(int data); // Get the depth of a node with the given data.


    //conversions
    public int[] toArray();
    public List<Integer> toList();

    //maintain treee balance
    public void balance();
    private TreeNode rotateRight(TreeNode y); // Right rotation for balancing.
    private TreeNode rotateLeft(TreeNode x); // Left rotation for balancing.


    //Searching and Finding:
    public int findMin(); // : Find the minimum value in the binary tree.
    public int findMax(); //: Find the maximum value in the binary tree.
    public int findLCA(int node1, int node2); //: Find the Lowest Common Ancestor of two nodes.


    //Clone and Copy:
    public BinaryTree clone(); // Create a deep copy of the binary tree.
    private TreeNode clone(TreeNode node); // Helper method for cloning a node.

    //Serialization and Deserialization:
    public String serialize()//: Serialize the binary tree to a string.
    public static BinaryTree deserialize(String data); //: Deserialize a string to reconstruct the binary tree.


    //Check Properties:
    public boolean isBinarySearchTree(); //: Check if the binary tree is a binary search tree.
    private boolean isBSTUtil(TreeNode node, int min, int max) //: Helper method for checking BST property.


    //Path Finding:
    public List<Integer> getPath(int data); //: Find the path from the root to a node with the given data.

    //Additional Functions:
    //public void mirror(): Convert the binary tree into its mirror image.

}
