# Union-Find

Union-Find is an interpretation of disjoint sets. That is, we intend to take a series of sets, and try to merge them to get as close to a line as possible. The overarching principle is that we have parents pointing to children, that allows us to quickly traverse through sets and find elements as fast as possible. We will go about building this structure, with an array of fixed size **n** as our base internal data structure. 

## Overview of a Set
For the purpose of a union-find, we consider a set to be some **Ω** number of items. Lets pretend we have some array of 5 integers, with each of the values equal to the index. In other words, at index 0, we have a value of 0, index 1 has a value of 1, etc. Values within the array represent the location, and the indices will represent the value of the item (black is location, blue is value).

![alternativetext](https://github.com/varunGannavarapu/Algorithms/blob/main/Data%20Structures/imgs/arr_5_items_orig_uf.png)

Now suppose we had elements 0 and 1 in our array of 5 integers to be in the same set. This is how we might depict it:

![alternativetext](https://github.com/varunGannavarapu/Algorithms/blob/main/Data%20Structures/imgs/arr_5_items_uf.png)

Notice how at indexes 0 and 1, they both have the same value of 0? The idea is that every item should point to the smallest value within the said. This is what we'll denote as pointing to the *head* of a set. The actual values, that is the 0 and 1, remain the same, as denoted along the blue values. Its just that the set it belongs to, that is the black and red values, now show that 0 and 1 belong to the same set, as reference by a pointer to the value **0**.

## Finding Parents
To find the parent of a set, the idea is that we keep searching until we get to the *head* of a given item. Lets look at the example below:
![alternativetext](https://github.com/varunGannavarapu/Algorithms/blob/main/Data%20Structures/imgs/find_example_uf.png)

Lets say we want to find the parent of 4. We look at 4, and notice that the pointer inside 4 is not the same as the value of the item, meaning that we aren't at the head. As such, lets check what 4 points to, that is index 2. At index 2, the value is 2, but the pointer points to 0, so we check 0. At 0, the pointer equals the value, meaning we found the head of our set as **0**.

## Union of Sets
Suppose we have trees, denoted A and B. Let A have some m items, and B have some n items, the actual size of each set does not really matter. We intend to combine these two sets into one, meaning that if we want to search for any item in either of these two sets, we'll return a parent to one of the sets. In order to merge two different sets, we obviously need two different sets, so lets assume that A and B are different sets. First, we should compare the sizes. If A is of greater or equal size to B, then this should be our parent set. That way, we have to parse through fewer comparisons to find anything in the combined set AB. This helps optimize runtime by minimizing comparisons. To do this, we shall alter the pointer for the *head* of set B, to point to the *head* of set A. 
However, the other items within set B shall still remain pointing to the *head* of set B. Below we'll draw out for combining two sets

![alternativetext](https://github.com/varunGannavarapu/Algorithms/blob/main/Data%20Structures/imgs/union_original_uf.png)
![alternativetext](https://github.com/varunGannavarapu/Algorithms/blob/main/Data%20Structures/imgs/union_update_uf.png)

In this set of 9 items, lets see what changed. If we follow set B, that is set 2, we merged it with set 0. Because both sets are of the same size, we'll just assume that we merge the second set to the first set. Notice how the *head* for set 2, which is **2**, now updates to the *head* of set 0, which is **0**. The other values in set 2 however, still point to the original pointer, so in essence we have at most moving throw two steps to find the head of the set. 

## Expansion and Runtime
The drawback of the example explained above is that we can't just add/remove values from this. To allow for custom input, we would have to adjust the array where each index corresponds to some implementation of a set, and then allow for either a resizing array, or an arraylist to house said values. However, this can severely impact runtime. Because we are connecting sets and doing so in a manner that minimizes the number of comparisons, our building algorithm will follow approximately an **O(n^2)** runtime, but each of our other methods will be as close to constant runtime as possible. The implementation of custom input, means that we must traverse each index, from which we must traverse each set, to find a value, meaning that any operation that isn't the building algorithm may also approach **O(n^2)** runtime, which is clearly less efficient than our previous implementation.
