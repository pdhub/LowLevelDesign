package linkedIn.design.maxstack;

/*
A great candidate will ask the API use pattern first and pick a best fit algorithm based on that
It is acceptable to provide starting solution with O(n) for popMax and constant time for other APIs including peekMax or faster than O(n) for all APIs
If asked, we can say popMax will be called less than other APIs. Candidate should propose 2 stacks solution because it can achieve constant time for all other APIs but popMax() will be O(n) time and space
If the candidate directly goes with Two Stacks solution, as follow-up we can ask the candidate to optimize if popMax() will be called more frequently than other APIs.
If the candidate goes with LinkedList+TreeMap solution, we can ask the candidate to optimize if popMax() is rarely called to check if candidate can propose 2 stacks solution


Arrays are generally bad news, because finding max element as well as deletion from the middle is an O(n) operation
LinkedList and Heap
This can satisfy functional requirements, but remove(object) from both the LinkedList and the Heap are O(n) operations because of the difficulty of finding an element in the middle. This is usually not an acceptable solution and you should ask the candidate to achieve better than O(n) complexity.
LinkedList and BST
This is perhaps easier, since a 'standard' BST can be used. Each BST element can point to its element in the list, and deleting a known node from a LinkedList is easy. They will have to write their own List, though, to get access to the nodes themselves. They will also need to keep track of the maximum element in the BST through whatever means to support O(1) peekMax.
Custom objects
These are objects that function as both list elements and tree elements, and thus will typically have at least 5 pointers on them (next, prev, parent, left, right). Some may have 7 (next, prev, larger, smaller, parent, left, right) to support the three types of lookups that are needed (binary search into sorted list, find max, find top). While this approach generally indicates that the candidate has understood what needs to be done well, actual implementation tends to be complex and spend a lot of time on 'peripheral' functions like the binary search. If the candidate suggests this, feel free to tell them to assume the existence of the helper functions that they need (such as the tree traversal and balancing code), rather than spending time writing those. Keep the interview focused on keeping the structures in sync, not implementing a BST.
Another approach is to build an object with a 'deleted' flag and a reference to it's partner object, and just flipping that on removal. This means that peek() and pop() need to dig to find the first 'real' element, but avoids modifying the middle of the stack/heap at the expense of some memory. It's also a good solution for synchronization issues, since it makes the areas that need to be held under lock simpler but is a bad approach in general as the memory usage will grow overtime and can lead to performance issues or even trigger out of memory exception.
There are also tradeoffs to (potentially) be made around the speed of different methods. The suggested solution gives O(log('n)) for push, pop, and popMax, but there are also few easier and slower solutions. We are looking for a solution that provides faster than O(n) solution. Easy but slow solutions:
A pair of linked lists can give O('n) push, O(1) pop and popMax. One list stores elements in insertion order, the other stores in sorted order (and does a linear scan on insertion), but removing the top of one and linking that to the element in the other is constant time, good for situations where quick removal is more important.
One linked list can provide O(1) push and pop, O('n) popMax by scanning for the largest element. Generally discouraged, but some candidates may mention that it is worthwhile if popMax is expected to be rare
Follow-Up Questions
What needs to be done to make this structure thread-safe?
How do you handle duplicate elements? If the stack is {5,3,5} and popMax is called, what should the new state of the stack be?
Scoring Guidelines (Under evaluation)
This score guidelines are under evaluation, so use your own judgment to give scores. If you override the guidance, please leave feedbacks and your interview hirein link, so that team could improve the questions (remove this line after Final Yes Approval)
Staff+ criteria (? min):
A great candidate will: (>3.5)
Provides the alternatives with convincing evaluation (communication is a key)
Able to describe multiple solutions (3+) and clearly articulate the tradeoffs before starting implementation
Fluent in comparing complexities for different data structures
Choose efficient implementation (O(1) for peeks and no worse that O(log(n)) for pop operations)
Have enough time to discuss all follow up questions including thread safety
Modify the solution to be thread-safe
Show good coding practice: good variable names, structured code

* */

public interface MaxStack<T extends Comparable<T>> {

    // The standard three Stack methods:

    /** Add an element to the stack. */
    public void push(T toPush);

    /** Return the top value on the stack. */
    public T peek();

    /** Remove and return the top value from the stack. */
    public T pop();

    // Two special methods, so this isn't just 'implement a stack':

    /** Return the largest value in the stack. (Remember that T must implement Comparable.) */
    public T peekMax();

    /** Remove and return the largest value from the stack. */
    public T popMax();
}
