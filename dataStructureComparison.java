//Compares the times of common operations (add, contains, remove, etc) on x elements in y data structures, where x and y are chosen by the user

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.util.Stack;
import java.util.Queue;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Hashtable;

public class dataStructureComparison {
    public static void main(String[] args) {
        // creates timer
        Timer timer = new Timer();
        timer.end();
        // creates empty data structures
        Stack<Double> stack = new Stack<Double>();
        ArrayList<Double> arraylist = new ArrayList<Double>();
        LinkedList<Double> linkedlist = new LinkedList<Double>();
        Hashtable<Double, Integer> hashtable = new Hashtable<Double, Integer>();
        binarySearchTree bst = new binarySearchTree();
        // value for number of elements
        long elementNum;
        // used for input from scanner
        String input;
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> structureList = new ArrayList<Integer>();
        ArrayList<Double> numsForStructs = new ArrayList<Double>();
        ArrayList<Double> numsForContains = new ArrayList<Double>();
        // prompts the user to enter values corresponding to the data strucures they
        // would like to compare
        System.out.println(
                "First, enter the numbers that correspond with the data structures you would like to compare. Add a space between each number.");
        System.out.println("1. Stack\n2. Array\n3. Array List\n4. Linked List\n5. Binary Search Tree\n6. Hash Table");
        // gets user input and adds to array list with a while loop
        input = in.nextLine();
        in = new Scanner(input);
        while (in.hasNextInt()) {
            int toAdd = Integer.parseInt(in.next());
            if (structureList.contains(toAdd))
                continue;
            structureList.add(toAdd);
        }
        // prompts user to enter number of elements to operate on
        System.out.println("Now enter the number of elements to operate on in each data structure. (Under 50,000)");
        in = new Scanner(System.in);
        elementNum = in.nextLong();
        double[] arr = new double[(int) elementNum];
        // adds elements to a list to be added to the structures, so all structures are
        // operating on the same data set
        for (int i = 0; i < elementNum; i++) {
            numsForStructs.add(Math.random());
        }
        // adds different random numbers to use for contains testing
        for (int i = 0; i < elementNum; i++) {
            numsForContains.add(Math.random());
        }
        // times operations for the add operation in the chosen structures
        System.out.println("\nADD OPERATIONS:");
        for (int i : structureList) {
            switch (i) {
                case 1:
                    timer = new Timer();
                    for (double j : numsForStructs) {
                        stack.add(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the stack add operation is - ");
                    System.out.println(timer);
                    break;
                case 2:
                    timer = new Timer();
                    for (int j = 0; j < numsForStructs.size(); j++) {
                        arr[j] = numsForStructs.get(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the array add operation is - ");
                    System.out.println(timer);
                    break;
                case 3:
                    timer = new Timer();
                    for (double j : numsForStructs) {
                        arraylist.add(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the array list add operation is - ");
                    System.out.println(timer);
                    break;
                case 4:
                    timer = new Timer();
                    for (double j : numsForStructs) {
                        linkedlist.add(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the linked list add operation is - ");
                    System.out.println(timer);
                    break;
                case 5:
                    timer = new Timer();
                    for (double j : numsForStructs) {
                        bst.insert(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the binary search tree add operation is - ");
                    System.out.println(timer);
                    break;
                case 6:
                    timer = new Timer();
                    int idx = 0;
                    for (double j : numsForStructs) {
                        hashtable.put(j, idx);
                        idx++;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the hash table add operation is - ");
                    System.out.println(timer);
                    break;
            }
        }
        // timed operations for the contains operation of chosen structures
        System.out.println("\nCONTAINS OPERATIONS:");
        for (int i : structureList) {
            switch (i) {
                case 1:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        if (stack.contains(j))
                            continue;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the stack contains operation is - ");
                    System.out.println(timer);
                    break;
                case 2:
                    timer = new Timer();
                    for (int j = 0; j < numsForContains.size(); j++) {
                        // continues out of loop if the value is contained, usually a bool variable
                        // would be marked but that is not necessary here
                        if (arr[j] == numsForContains.get(j))
                            continue;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the array contains operation is - ");
                    System.out.println(timer);
                    break;
                case 3:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        if (arraylist.contains(j))
                            continue;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the array list contains operation is - ");
                    System.out.println(timer);
                    break;
                case 4:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        if (linkedlist.contains(j))
                            continue;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the linked list contains operation is - ");
                    System.out.println(timer);
                    break;
                case 5:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        if (bst.find(j))
                            continue;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the binary search tree contains operation is - ");
                    System.out.println(timer);
                    break;
                case 6:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        if (hashtable.containsKey(j))
                            continue;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the hash table contains operation is - ");
                    System.out.println(timer);
                    break;
            }
        }
        // timed operations for the remove operations of selected structures
        System.out.println("\nREMOVE OPERATIONS:");
        for (int i : structureList) {
            switch (i) {
                case 1:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        stack.remove(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the stack remove operation is - ");
                    System.out.println(timer);
                    break;
                case 2:
                    timer = new Timer();
                    for (int j = 0; j < numsForContains.size(); j++) {
                        // continues out of loop if the value is contained, usually a bool variable
                        // would be marked but that is not necessary here
                        if (arr[j] == numsForContains.get(j))
                            arr[j] = Double.NaN;
                    }
                    timer.end();
                    System.out.print("The time/memory used for the array remove operation is - ");
                    System.out.println(timer);
                    break;
                case 3:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        arraylist.remove(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the array list remove operation is - ");
                    System.out.println(timer);
                    break;
                case 4:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        linkedlist.remove(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the linked list remove operation is - ");
                    System.out.println(timer);
                    break;
                case 5:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        bst.delete(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the binary search tree remove operation is - ");
                    System.out.println(timer);
                    break;
                case 6:
                    timer = new Timer();
                    for (double j : numsForContains) {
                        if (hashtable.containsKey(j))
                            hashtable.remove(j);
                    }
                    timer.end();
                    System.out.print("The time/memory used for the hash table remove operation is - ");
                    System.out.println(timer);
                    break;
            }
        }
    }

    // timer class
    public static class Timer {
        long startTime, endTime, elapsedTime, memAvailable, memUsed;

        public Timer() {
            startTime = System.currentTimeMillis();
        }

        public void start() {
            startTime = System.currentTimeMillis();
        }

        public Timer end() {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            memAvailable = Runtime.getRuntime().totalMemory();
            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
            return this;
        }

        public String toString() {
            return "Time: " + elapsedTime + " ms. " + "Memory: " + (memUsed / 1048576) + " MB / "
                    + (memAvailable / 1048576) + " MB.";
        }
    }

    // bst class
    public static class binarySearchTree {
        public Node root;

        public binarySearchTree() {
            this.root = null;
        }

        // method to find certain element in tree, returns true if found
        public boolean find(double id) {
            Node current = root;
            while (current != null) {
                if (current.data == id) {
                    return true;
                } else if (current.data > id) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return false;
        }

        // method to delete a certain element in tree, return true if found
        public boolean delete(double id) {
            Node parent = root;
            Node current = root;
            boolean isLeftChild = false;
            while (current.data != id) {
                parent = current;
                if (current.data > id) {
                    isLeftChild = true;
                    current = current.left;
                } else {
                    isLeftChild = false;
                    current = current.right;
                }
                if (current == null) {
                    return false;
                }
            }
            // runs if node is found and is child
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                }
                if (isLeftChild == true) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            // runs if node to be deleted has only one child
            else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else if (current.left != null && current.right != null) {

                // now we have found the minimum element in the right sub tree
                Node successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
            return true;
        }

        // helper method that gets the successor of node to be deleted
        public Node getSuccessor(Node deleteNode) {
            Node successsor = null;
            Node successsorParent = null;
            Node current = deleteNode.right;
            while (current != null) {
                successsorParent = successsor;
                successsor = current;
                current = current.left;
            }
            // check if successor has the right child, it cannot have left child for sure
            // if it does have the right child, add it to the left of successorParent
            if (successsor != deleteNode.right) {
                successsorParent.left = successsor.right;
                successsor.right = deleteNode.right;
            }
            return successsor;
        }

        // method to insert node into tree
        public void insert(double id) {
            Node newNode = new Node(id);
            if (root == null) {
                root = newNode;
                return;
            }
            Node current = root;
            Node parent = null;
            while (true) {
                parent = current;
                if (id < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    // nested node class
    static class Node {
        double data;
        Node left;
        Node right;

        public Node(double data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

}
