#include <stdio.h>
#include <stdlib.h>

/* Declare a general struct that would be used */

struct uf {
  int[] tree;
  int[] nodes_per_subtree;
  int set_num;
} uf_t;

/* Method Declarations */
void build_uf(struct uf_t *, int);
int numElements(struct uf_t);
int get_num_sets(struct uf_t);
int find_parent(struct uf_t, int);
int connection(struct uf_t, int, int);
void merge(struct uf_t *, int, int);

/* Methods */

void build_uf(struct uf_t *my_uf, int size) {
  my_uf.set_num = size;
  int t[size] = {};
  int nps[size] = {};
  for (int i = 0; i < size; i++) {
    t[i] = i;
    nps[i] = 1;
  }
  my_uf.tree = t;
  my_uf.nodes_per_subtree = nps;
}

int numElements(struct uf_t my_uf) {
  return sizeof(my_uf.tree) / sizeof(int);
}

int get_num_sets(struct uf_t my_uf) {
  return my_uf.set_num;
}

int find_parent(struct uf_t my_uf, int child) {
  if (child < 0 || child >= (sizeof(my_uf.tree) / sizeof(int))) {
    return -1;
  }
  while (child != my_uf.tree[child]) {
    child = my_uf.tree[child];
  }
  return child;
}

int connection(struct uf_t my_uf, int child_one, int child_two) {
  if (find_parent(my_uf, child_one) == find_parent(my_uf, child_two)) {
    return 1;
  }
  return 0;
}

void merge(struct uf_t *my_uf, int child_one, int child_two) {
  if (connection(&my_uf, child_one, child_two) == 1) {
    return;
  }
  if ((&my_uf).nodes_per_subtree[child_one] > (&my_uf).nodes_per_subtree[child_two]) {
    (&my_uf).tree[child_two] = (&my_uf).tree[child_one];
    (&my_uf).nodes_per_subtree[child_two] += (&my_uf).nodes_per_subtree[child_one];
  } else {
    (&my_uf).tree[child_one] = (&my_uf).tree[child_two];
    (&my_uf).nodes_per_subtree[child_one] += (&my_uf).nodes_per_subtree[child_two];
  }
  (&my_uf).set_num -= 1;
}
