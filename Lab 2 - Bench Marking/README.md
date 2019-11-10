# COMP-182

<!-- HTML CODE -->

For this project, you want to wrap a linked list and not inherit it. The linked list has a lot of operations which can easily break your Queue. Giving others access to these code-breaking methods is not smart… not smart at all. You want to hide these methods from those who use your linked list and only offer the methods related to the stack and queue object.
 
 
<b>Implement a Priority Queue (6 points)</b>

A Queue is a First in First Out (FIFO) structure which translates to the processes of outputting the first item inputted into a collection. The Queue is based on the process of waiting in line to get serviced (bank or six flags), where those who arrive first get serviced first.

A priority stack orders object by their their value, so instead of storing objects based on when they were added to the structure, the object stores them based on their value.

<b>Operations to implement:</b>

<b>Enqueue(E)</b>: Add an element to the sequence

<b>Dequeue</b>: Remove an element from the start of the sequence

<b>atIndex(x)</b>: Return the element at the given index (x) Or throw an exception if it is out of bound (if you can control the user input then do that instead)

<b>Size</b>: Return the size of the Queue

<b>isEmpty</b>: Boolean, returns true if the Queue is empty

<b>Empty</b>: Empty the Queue

 

 

 <b>Providing a data structure that is a bit persistent (4 points)</b>

 

“A persistent data structure is one in which no operations result in permanent changes to the underlying structure. It's called “persistent” because as the structure goes through successive operations, all versions of the structure persist over time. The notion of a structure with no permanent changes may sound like an oxymoron:” Source (Links to an external site.) 

 

This is too expensive and messy for a comp 182, however, you are more than free to go and read more on them.

 

For your structures to be considered a little persistent in this project it will need to support a few features: (Throwing all of the benefits of a linked list out of the window)

 
<ul>
  
<li>(2 points)Your structure must be immutable (like a string)</li>
<ul>
<li>That means you will have to go back and make the linked list immutable and both your stack and queue need to be immutable as well.</li>
<li>In other words, every time you make a modification to your collection, you return a completely new one.</li>
  <ul>
<li>Hint: Think about making a .clone method  or an alternative to it for your structure</li>
  </ul>
  </ul>
<li>(1 point)Support proper value equality semantics in their implementation of equals</li>
<ul>
<li>Hint: Implement the comparator interface for your elements</li>
<li>So you can go and do: myCollection1.equals(myCollection2)</li>
  </ul>
<li>(1point) Implement Interface Iterable<T></li>
  </ul>
