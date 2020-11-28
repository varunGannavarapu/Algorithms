# Queues

Similar to stacks, Queues follow the principle of having some internal structure to store information, with the difference being that if we have an object enter the queue, then it will exit the queue before all objects added after it. In other words, the structure is of type *FIFO*, that meaning first-in, first-out. Building this structure using an internal ArrayList would be the easiest way to build this, but lets suppose we are working with a language like C, where we don't have structure like this. We again will consider using either an array or a linked-list as the internal structure.

## Array Implementation

### Adding an element
Once again, the big principle to consider is memory, that being the *doubling principle* for how we want to add information. Queues add information to the end of the list, meaning we leave data where it is, and then look for the first available index for the internal array, then add an item to the end of the queue. If need be, then we double the size of the array. We'll call this process either *adding* or *pushing*.

[//]: <> (add image for adding items)

### Removing an element
Removal of an item is the exact same as a stack, where we remove the first item, and then shift all the information forward, known as either *removing* or *popping*

[//]: <> (removal for a queue)

### Searching and Runtime
Searching simply requires that we go through said internal array, and then find if an item is present or not. Searching is an **O(n)** operation, because we iterate through the queue to find the item, making up to **n** comparisons. The other operation of searching type is *peek*, where we simply look at what is at the front of our queue. This would obvious be an **O(1)** operation, because we make only one comparison. Addition is best case **O(1)** because we simply add an item, and worst case **O(n)** for when we add something and the internal array is already full, meaning we need to double the size. Removal is **O(n)**, because we remove an item, then shift all the items over, and if need be we truncate the size of the array by half.

## Linked List Representation
Lets look into how we might represent this using a linked list. Recall that linked lists are a series of nodes connected by either one or two pointers, to allow for forward or reverse traversal. In our case, we'll work with a singly-linked list, meaning we can only move forward.

### Adding an element
To add an element, we first want to create a reference to the head of our internal list, and use that refernce to iterate throughout our list. Eventually, we'll reach a point where the next element is *NULL*. At this point, we would add a new node containing the data we want to store to the end of our list. The example below may detail this principle

[//]: <> (add to a linked list queue)

### Removing an element
Removal from a linked list queue means that we want to *pop* the first element of our queue. To do this, we would want to create a temporary pointer to the hed of our queue, and then move the actual head pointer over one to point to the next element in the queue. It is ok if this is equal to *NULL*, this just means we removed the last item within our queue. Following this, we should break the connection between the temporary pointer and the head, and then either return the value that the temporary pointer points to, or set it equal to *NULL* depending on what the function requires

[//]: <> (removal from a linked list queue)

### Searching and Runtime
An easy way to search through a linked list queue, is to create a temporary pointer that points to the head of the queue, and slowly traverse through the internal linked list. At each node, check to see if we have the value we want, else continue until we get to *NULL*. This would be an operation of runtime **O(n)**, because we would have to make comparisons at up to all **n** elements within the queue. *Peeking* is of runtime **O(1)**, because we simply just return the value at the head of our linked list. Addition is of runtime **O(n)**, because we have to traverse the entire list, and then add an item at the end of the list. However, removal would be of runtime **O(1)**, because if we look at it, it always requires 2 steps: Move a pointer and then return or free the first node.
