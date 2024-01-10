
# Concurrent Process Management with Threading
This Java project demonstrates concurrent process management through a server-client architecture, utilizing threading for efficient communication. The system encompasses a server-side component, ProcessServer, and client-side components, ConsumerClient and ProducerClient. These clients interact with a shared buffer, implemented in the Buffer class, allowing the concurrent production and consumption of items.

## Threading Implementation
The project employs Java threads to achieve parallelism and efficient process handling. The Main class orchestrates two threads, t1 and t2, to showcase the concurrent execution of item production and consumption within the shared buffer.

## Client-Side 

The client side of the code involves two Java classes, namely ConsumerClient and ProducerClient. These classes establish socket connections with a server, in this case, the ProcessServer. The ConsumerClient initiates communication by sending a "RUN" signal to the server and receives information about the number of items to consume. It then iteratively retrieves and prints the items. On the other hand, the ProducerClient obtains an ID from the server, signals readiness by sending "RUN," and proceeds to either request the number of items to produce or terminate based on server responses. These clients interact with the server, exchanging messages and participating in the concurrent process management system through multithreading.

## Server-Side

The server side of the code is primarily represented by the ProcessServer, OSSimulator, and Process classes. The ProcessServer class acts as the main server, listening for incoming client connections and creating an instance of the OSSimulator to handle concurrent processes. The OSSimulator class manages the scheduling of processes, creating and terminating instances of the Process class. The Process class, in turn, represents an individual process and communicates with the client through socket connections. It executes various instructions, such as obtaining the number of items, getting the next item position, and producing or consuming items in coordination with the shared buffer. The server side orchestrates the overall process management system, handling communication and coordination among clients and processes.
