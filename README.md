#!/bin/bash

# Function to echo bold text
bold() {
  echo -e "\e[1m$1\e[0m"
}

# Project Title and Description
bold "Concurrent Process Management with Threading"

echo "This Java project demonstrates concurrent process management through a server-client architecture, utilizing threading for efficient communication. The system encompasses a server-side component, \`ProcessServer\`, and client-side components, \`ConsumerClient\` and \`ProducerClient\`. These clients interact with a shared buffer, implemented in the \`Buffer\` class, allowing the concurrent production and consumption of items."

echo

# Threading Implementation
bold "## Threading Implementation"

echo "The project employs Java threads to achieve parallelism and efficient process handling. The \`Main\` class orchestrates two threads, \`t1\` and \`t2\`, to showcase the concurrent execution of item production and consumption within the shared buffer."

echo

# Client-Side Overview
bold "### Client-Side Overview"

echo

# ConsumerClient
bold "#### \`ConsumerClient\`"

echo "- Connects to the server and receives a signal to start processing."
echo "- If the signal is \"RUN,\" it consumes items from the server according to the specified scenario."

echo

# ProducerClient
bold "#### \`ProducerClient\`"

echo "- Connects to the server and receives a signal to start processing."
echo "- If the signal is \"RUN,\" it sends requests to the server for item production and receives the produced items."

echo

# Server-Side Overview
bold "### Server-Side Overview"

echo

# ProcessServer
bold "#### \`ProcessServer\`"

echo "- Acts as the server, waiting for incoming client connections."
echo "- Utilizes the \`OSSimulator\` to create and manage concurrent processes."
echo "- Coordinates communication between clients and manages the shared buffer."

echo

# OSSimulator
bold "#### \`OSSimulator\`"

echo "- Simulates an operating system environment with threaded process scheduling."
echo "- Creates and manages processes using the \`Process\` class."

echo

# Buffer
bold "#### \`Buffer\`"

echo "- Implements a buffer with methods for item production (\`produce\`) and consumption (\`consume\`)."
echo "- Ensures synchronization using locks and conditions for thread safety."

echo

# Process
bold "#### \`Process\`"

echo "- Represents an individual process with communication methods."
echo "- Communicates with the buffer and performs actions based on received instructions."

echo

# Running the Code
bold "### Running the Code"

echo "The \`Main\` class serves as the entry point, orchestrating the concurrent execution of producer and consumer threads. The project showcases how threading enhances the efficiency of process management and communication in a simulated operating system environment."
