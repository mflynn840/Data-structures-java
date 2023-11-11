public class Heap {
    
}


/*a heap is a specialized tree-based data structure

    Added thing to be a heap: maintain the heap property
         ->In a max heap, for any given node C, if P is a parent node of C, 
         then the key (the value) of P is greater than or equal to the key of C.
         
         ->In a min heap, the key of P is less than or equal to the key of C.
         
        the node at the "top" of the heap (with no parents) is called the root node.

The heap is one maximally efficient implementation of an abstract data type called a priority queue,
and in fact, priority queues are often referred to as "heaps", regardless of how they may be implemented. 

In a heap, the highest (or lowest) priority element is always stored at the root. 
However, a heap is not a sorted structure; it can be regarded as being partially ordered. 
A heap is a useful data structure when it is necessary to repeatedly remove the object with the highest (or lowest) priority,
or when insertions need to be interspersed with removals of the root node.


Implements the heapsort sorting algorithm.


NOTE: Heaps are also crucial in several efficient graph algorithms such as Dijkstra's algorithm. 


Note that, as shown in the graphic, there is no implied ordering between siblings or cousins and no implied sequence for an in-order traversal 
(as there would be in, e.g., a binary search tree). 
The heap relation mentioned above applies only between nodes and their parents, grandparents, etc. 
The maximum number of children each node can have depends on the type of heap.


Heaps are usually implemented with an array, as follows:

Each element in the array represents a node of the heap, and
The parent / child relationship is defined implicitly by the elements' indices in the array.

Example of a complete binary max-heap with node keys being integers from 1 to 100 and how it would be stored in an array.
For a binary heap, in the array, the first index contains the root element. The next two indices of the array contain the root's children. The next four indices contain the four children of the root's two child nodes, and so on. Therefore, given a node at index i, its children are at indices 
2
�
+
1
2i+1 and 
2
�
+
2
{\displaystyle 2i+2}, and its parent is at index ⌊(i−1)/2⌋. This simple indexing scheme makes it efficient to move "up" or "down" the tree.

Balancing a heap is done by sift-up or sift-down operations (swapping elements which are out of order). As we can build a heap from an array without requiring extra memory (for the nodes, for example), heapsort can be used to sort an array in-place.

After an element is inserted into or deleted from a heap, the heap property may be violated, and the heap must be re-balanced by swapping elements within the array.

Although different type of heaps implement the operations differently, the most common way is as follows:

Insertion: Add the new element at the end of the heap, in the first available free space. If this will violate the heap property, sift up the new element (swim operation) until the heap property has been reestablished.
Extraction: Remove the root and insert the last element of the heap in the root. If this will violate the heap property, sift down the new root (sink operation) to reestablish the heap property.
Replacement: Remove the root and put the new element in the root and sift down. When compared to extraction followed by insertion, this avoids a sift up step.
Construction of a binary (or d-ary) heap out of a given array of elements may be performed in linear time using the classic Floyd algorithm, with the worst-case number of comparisons equal to 2N − 2s2(N) − e2(N) (for a binary heap), where s2(N) is the sum of all digits of the binary representation of N and e2(N) is the exponent of 2 in the prime factorization of N.[7] This is faster than a sequence of consecutive insertions into an originally empty heap, which is log-linear.[a]







Further work:
In computer science, a min-max heap is a complete binary tree data structure which combines the usefulness of both a min-heap and a max-heap, that is, it provides constant time retrieval and logarithmic time removal of both the minimum and maximum elements in it.[2] This makes the min-max heap a very useful data structure to implement a double-ended priority queue. Like binary min-heaps and max-heaps, min-max heaps support logarithmic insertion and deletion and can be built in linear time.[3] Min-max heaps are often represented implicitly in an array;[4] hence it's referred to as an implicit data structure.

The min-max heap property is: each node at an even level in the tree is less than all of its descendants, while each node at an odd level in the tree is greater than all of its descendants.[4]

The structure can also be generalized to support other order-statistics operations efficiently, such as find-median, delete-median,[2]find(k) (determine the kth smallest value in the structure) and the operation delete(k) (delete the kth smallest value in the structure), for any fixed value (or set of values) of k. These last two operations can be implemented in constant and logarithmic time, respectively. The notion of min-max ordering can be extended to other structures based on the max- or min-ordering, such as leftist trees, generating a new (and more powerful) class of data structures.[4] A min-max heap can also be useful when implementing an external quicksort.[5]


Operations*/