# Union-Find

Union-Find is an interpretation of disjoint sets. That is, we intend to take a series of sets, and try to merge them to get as close to a line as possible. The overarching principle is that we have parents pointing to children, that allows us to quickly traverse through sets and find elements as fast as possible.

## Overview of a Set
For the purpose of a union-find, we consider a set to be some **Ω** number of items. Lets pretend we have some array of 5 integers, with each of the values equal to the index. In other words, at index 0, we have a value of 0, index 1 has a value of 1, etc.

![alternativetext](Data Structures/imgs/arr_5_items_alt_uf.png)

Now suppose we had elements 0 and 1 in our array of 5 integers to be in the same set. This is how we might depict it:

//insert drawing of two items in the same set

Notice how at indexes 0 and 1, they both have the same value of 0? The idea is that every item should point to the smallest value within the said. This is what we'll denote as pointing to the "head" of a set.

## Union of Sets
Suppose we have trees, denoted A and B. Let A have some m items, and B have some n items, the actual size of each set does not really matter. We intend to combine these two sets into one, meaning that if we want to search for any item in either of these two sets, we'll return a parent to one of the sets. In order to merge two different sets, we obviously need two different sets, so lets assume that A and B are different sets. First, we should compare the sizes. If A is of greater or equal size to B, then this should be our parent set. That way, we have to parse through fewer comparisons to find anything in the combined set AB. This helps optimize runtime by minimizing comparisons. To do this, we shall alter the pointer for the "head" of set B, to point to the "head" of set A. 
However, the other items within set B shall still remain pointing to the "head" of set B. Below we'll draw out an example using 5 items, for which items {1,2,3} are set A, and {4,5,6,7} are set B. We want to connect set A as part of set B since set B is the larger set, so we'll change the pointer for 1 to go from 1 to 4, but the other items in set A will still point to 1. The diagram below helps visualize said change.

//insert image of combined sets
