
##DEFINITION:- 

*Queue is data structure whose its element can be added in the last element and taken only from the first element.  
*Known as FIFO (First In First Out).

Components  of Queues:- 

• Front is a variable which refers to first position in queue 

• Rear is a variable which refers to last position in queue.  

• Element is component which has data. 

• MaxQueue is variable that describes maximum number of elements in a queue. 

OPERATION:- 

1.)Enqueue: An operation to insert an element in the queue is Enqueue (function queueEnqueue in the program). For inserting an element at the rear end, we need to first check if the queue is full. If it is full, then we cannot insert the element. If rear < n, then we insert the element in the queue. 

2.) Dequeue: The operation to delete an element from the queue is Dequeue (function queueDequeue in the program). First, we check whether the queue is empty. For dequeue operation to work, there has to be at least one element in the queue. 

3.) Front: This method returns the front of the queue. 

4.) Display: This method traverses the queue and displays the elements of the queue. 

TYPES OF QUEUES: 

1.) Simple Queue :-

A simple queue is the most basic queue. In this queue, the enqueue operation takes place at the rear, while the dequeue operation takes place at the front: 

 
Its applications are process scheduling, disk scheduling, memory management, IO buffer, pipes, call center phone systems, and interrupt handling. 

2.) Circular Queue 

A circular queue permits better memory utilization than a simple queue when the queue has a fixed size. 

In this queue, the last node points to the first node and creates a circular connection. Thus, it allows us to insert an item at the first node of the queue when the last node is full and the first node is free. 

It’s also called a ring buffer: 

It’s used to switch on and off the lights of the traffic signal systems. Apart from that, it can be also used in place of a simple queue in all the applications mentioned above. 

3.) Priority Queue:-

A priority queue is a special kind of queue in which each item has a predefined priority of service. In this queue, the enqueue operation takes place at the rear in the order of arrival of the items, while the dequeue operation takes place at the front based on the priority of the items. 

That is to say that an item with a high priority will be dequeued before an item with a low priority. 

In the case, when two or more items have the same priority, then they’ll be dequeued in the order of their arrival. Hence, it may or may not strictly follow the FIFO rule: 

It’s used in interrupt handling, Prim’s algorithm, Dijkstra’s algorithm,  A* search algorithm, heap sort, and Huffman code generation. 

4.) Double-Ended Queue (Deque) 

A deque is also a special type of queue. In this queue, the enqueue and dequeue operations take place at both front and rear. That means, we can insert an item at both the ends and can remove an item from both the ends. Thus, it may or may not adhere to the FIFO order: 

Applications :- 

• In real life scenario, Call Center phone systems uses Queues to hold people calling them in an order, until a service representative is free 

• Serving requests on a single shared resource, like a printer, CPU task scheduling etc. 

 

 
