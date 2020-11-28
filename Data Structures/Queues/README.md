# Queues

Similar to stacks, Queues follow the principle of having some internal structure to store information, with the difference being that if we have an object enter the queue, then it will exit the queue before all objects added after it. In other words, the structure is of type *FIFO*, that meaning first-in, first-out. Building this structure using an internal ArrayList would be the easiest way to build this, but lets suppose we are working with a language like C, where we don't have structure like this. We again will consider using either an array or a linked-list as the internal structure.

## Array Implementation

### Adding an element
Once again, the big principle to consider is memory, that being the *doubling principle* for how we want to add information. Queues add information to the end of the list, meaning we leave data where it is, and then look for the first available index for the internal array, then add an item to the end of the queue. If need be, then we double the size of the array. We'll call this process either *adding* or *pushing*.

![//] <> (add image for adding items)

### Removing an element
Removal of an item is the exact same as a stack, where we remove the first item, and then shift all the information forward, known as either *removing* or *popping*

![//] <> (removal for a queue)

### Searching and Runtime
Searching simply requires that we go through said internal array, and then find if an item is present or not. Searching is an **O(n)** operation, because we iterate through the queue to find the item, making up to **n** comparisons. Addition is best case **O(1)** because we simply add an item, and worst case **O(n)** for when we add something and the internal array is already full, meaning we need to double the size. Removal is **O(n)**, because we remove an item, then shift all the items over, and if need be we truncate the size of the array by half.


