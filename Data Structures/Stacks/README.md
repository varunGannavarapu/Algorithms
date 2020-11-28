# Stacks
Stacks are a data structure that intends to store information in a FILO manner, that is first-in, last-out. The manner in which this is done, is that we take individual items, and *push* them into our strucutre, such that new items will sit on top of old items. To remove items, we *pop* them, meaning that whatever is on top will be returned.

## Array Representation
Lets suppose we wanted to build our stack using an array. The first thing to consider is allocation and deallocation of memory. Because we intend to use an array, we must always be able to increase the size of said array, and then add/remove objects from said implementation. The manner in which we do this, is going to be the *doubling principle*. What we mean is, that everytime we intend to add an object, we check how much space for the array has been taken up. If the array is full, then we shall create a new array that is twice the size of the old one, copy all the information from the old one to the new one, then delete the old one. In this manner, the new array will be our stack, and we will not have duplicated memory because we freed the old memory. Another principle to consider, is what is the minimum size of our array? We may consider the minimum size to be some arbitrary value, denoted as **n**. We could in theory just set the minimum size to **1**, and double the size of the array each time we add information as well. This value for **n** will depend on the application of the stack, where we might have an idea for a general minimum value.

### Pushing

When adding to the stack, we want the newest item that is added to be in the first index. This means that all future items should be shifted over by one index. We call this concept *pushing*. Consider the example below, where we add a new item into the stack.

[//]: <> (Add example)

As we can see, we have added an element to the stack, and every item has shifted over by one. Now lets consider a new example, where we will use the aformentioned *doubling principle* for our array. When we add an element, the size of the array should now double from size **n** to size **2n**.

[//]: <> (Add doubling example)

### Popping

To remove an item from the stack, we will *pop* an element. What this means, is that we shall be removing the first element of the stack, and returning the value, while also moving all the elements forward. 

[//]: <> (Add popping example)

As we can see below, we have a situation where we removed the first element from our list, and all our items shifted forward. One thing to consider however, is what we might want to do with our *doubling principle*. Suppose we remove an element, and now all the elements take up half the space in the array. There is no reason for us to allocate the excess memory, so we could do the inverse of our *doubling principle*, which we'll call the *halving principle*. Consider the example below.

[//]: <> (add popping and halving example)

### Searching

Not all stack representations may allow for individuals to look and see what all is in the stack. We could allow this, simply by writing a method that traverses through the internal array and returns if the item exists in the array or not. What is standard however, is the principle of a *peek* method. This *peek* method is the same as *popping*, with the exception that we don't actually remove the item. We simply return the value of what is on top of the stack, but keep said item in the stack.

## Linked List or ArrayList Representation
An alternative approach to represent our stack using an internal linked list. On one hand, adding/removing elements is a lot easier to do, because we simply have to connect two pointers, those being the node we are adding and the current list. On the other hand, we may have issues with searching if an item is in the stack, getting a count of the number of items in our stack, and the amount of memory allocated, because we will never know the exact amount of memory allocated without counting how many nodes we have.

In languages such as Java, having the internal item be an ArrayList may be more beneficial, because it allows for the benefits of indexing that arrays provide, namely the ability to search for items immediately. In addition, array lists will take care of the *doubling principle* in regards to their size as need be. On the other hand, they also allow for us to be able to quickly add/remove elements from our stack, and shift other elements accordingly.

## Runtime Considerations
When working with a stack, consider that any addition/removal will depend on what the internal structure is. Linked-List variations have a **O(1)** runtime for addition/removal, but an **O(n)** runtime for searching. Array representations will follow the opposite for each of these functions.
