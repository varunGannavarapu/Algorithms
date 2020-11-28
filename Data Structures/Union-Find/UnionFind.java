import java.util.*;
import java.lang.*;

public class UnionFind() {

    /*
     * Define initial variables that
     * may be used throughout this process
     */
    private int[] tree;
    private int[] nodes_per_subtree;
    private int set_num;

    /*
     * General constructor. We will assume
     * for this example, that we have a defined
     * size of elements that will not change
     */
    public UnionFind(int size) {
        set_num = size;
        tree = new int[size];
        nodes_per_subtree = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = i;
            nodes_per_subtree[i] = 1;
        }
    }

    /*
     * Get num elements within our structure
     * 
     * @param return length of array
     */

    public int numElements() {
        return tree.length;
    }

    /*
     * Get the number of subsets. Over time, merging
     * should get us to one subset
     * 
     * @return num of subsets
     */

    public int get_num_sets() {
        return set_num;
    }

    /*
     * Find the parent of a given object
     * 
     * @param child element for which we want to find a parent
     * @return the parent of the child if its in the structure, else return -1
     */

    public int find_parent(int child) {
        if (child < 0 || child >= tree.length) {
            return -1;
        }
        while (child != tree[child]) {
            child = tree[child];
        }
        return child;
    }

    /*
     * Determine if two children have the same parent
     * 
     * @param child_one first element to search
     * @param child_two second element to search
     * @return a boolean if the children are connected or not
     */

    public boolean connection(int child_one, int child_two) {
        return find_parent(child_one) == find_parent(child_two);
    }

     /*
      * Connect two subtrees. First tree is parent if the size of
      * the first subtree is connected to the second.
      *
      *@param tree_one first tree
      *@param tree_two second tree
      */
    
    public void merge(int tree_one, int tree_two) {
        if connection(tree_one, tree_two) { return; }
        if (nodes_per_subtree[tree_one] > nodes_per_subtree[tree_two]) {
            tree[tree_two] = tree[tree_one];
            size[tree_one] += size[tree_two];
        } else {
            tree[tree_one] = tree[tree_two];
            size[tree_two] += size[tree_one];
        }
        set_num--;
    }
}