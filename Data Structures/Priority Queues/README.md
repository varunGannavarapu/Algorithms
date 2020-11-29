# Priority Queues
Lets suppose we took the queue structure we had earlier, and slightly alter how we store information. Suppose that each piece of information is a block, that has both the information, and some ID number. This ID number will represent a *weight* for the piece of information. Based on how we choose to organize these weights, we determine where an object is inserted when entering the queue. This is the general idea behind whats known as a priority queue.

## Inserting into the Queue
Although both interpretations are approximately the same with regard to how objects are inserted, we'll look at the linked-list implementation, where smaller weights are towards the front of the queue. We start at the *head* of our list, i.e. the beginning of our queue, and gauge the weights. If the weight of the current node is less than the weight of the object we wish to to insert, then we continue to the next node. If the weight of the current node is greater, then we wish to insert at this location. The way we do this is as follows:
1. Set the node to insert to point to the current node.

[//]: <> (include drawing)

2. If there is a previous node to the current node, set the previous node to point to the node we inserted

[//]: <> (include drawing)

3. If the node we inserted becomes the new head, update our head pointer accordingly

[//]: <> (include drawing)

When comparing two objects that have the same weight, we compare the data that is stored within each of the items, following the same idea as above when handing less thans or greater thans. If the data is also equal, we can think of this as having to come after the first occurrence of its kind, so we progress forward and insert this node in the next available slot as per our priority queue specifications.

To implement this same principle with an array representation, the array will store objects of some kind. Within said object, we store both the information and the weight, and simply shift items within said array if needed. Of course, we still account for the *doubling principle* when building the size of our array, based on how much information we end up storing.

## Removal and Searching
Consider that our queue still works the same as a traditional queue with regards to searching and removal, its just that the manner in which objects are added will change depending on weights/

## Runtime
Insertion for the queue can range anywhere between **O(1)** and **O(n)**, depending on how many comparisons are needed to be made to insert an object. Removal is still **O(1)** because we remove just the first object, and searching again is between **O(1)** and **O(n)** depending on where the object is within the queue.
