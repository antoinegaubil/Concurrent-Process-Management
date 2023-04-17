package ca.concordia.coen346.server;

import java.io.IOException;
import java.net.Socket;

public class OSSimulator extends Thread{

    private final static int MAX_PROCESSES = 2;
    private static LinkedList<String> pidTask = new LinkedList<task>;
    public static LinkedList<Integer> priority = new LinkedList<Integer>();
    public static LinkedList<String> task = new LinkedList<String>();
    public static LinkedList<Integer> burst = new LinkedList<Integer>();
    private static int currentBurst = 0;
    private static LinkedList<Integer> turnaroundTime = new LinkedList<>();
    private static LinkedList<Integer> waitingTime = new LinkedList<>();


    private Process[] clients = new Process[MAX_PROCESSES];

    private Buffer buffer = new Buffer();
    private int numClients = 0;


    private int currClient = 0;

    public OSSimulator (){

    }

    public int createProcess(Socket client) throws Exception {
        if(numClients == MAX_PROCESSES){
            return -1;
        }
        //get id and assign to that position
        clients[numClients++] = new Process(numClients-1, client, buffer);
        //add to queue
        System.out.println("Process created" + numClients);
        return 0;
    }

    public Process schedule(){
        if (task.size() == 0) {
            int TurnaroundTime = 0;
            int WaitingTime = 0;

            for (int i = 0; i < pidTask.size(); i++) {//calculate average waiting and turnaround times
                int taskTurnaroundTime = turnaroundTime.get(i);
                int taskWaitingTime = waitingTime.get(i);

                TurnaroundTime += taskTurnaroundTime;//sum
                WaitingTime += taskWaitingTime;//sum
            }

            int averageTurnaroundTime = TurnaroundTime / pidTask.size();//average
            int averageWaitingTime = WaitingTime / pidTask.size();//average

            System.out.println("Average times: waiting [" + averageWaitingTime + "ms], turnaround: [" + averageTurnaroundTime + "ms]");

            return false;
        }

        int burstTime = burst.get(0);//get the first from the queue.
        System.out.println("Will run : " + task.get(0));
        System.out.println("Tid : " + pidTask.indexOf(task.get(0)));
        System.out.println("Priority : " + priority.get(0));
        System.out.println("Burst Time : " + burstTime);
        System.out.println("\n");

        if (burstTime <= 10) { //if that is the case, that means the task will be done within this loop.

            currentBurst += burstTime;//add all the burst times
            turnaroundTime.add(currentBurst); //burst time = CT - AT = CT since AT = 0
            waitingTime.add(currentBurst - burstTime);//waiting time = (CT - AT) - BT

            System.out.println("Task " +task.get(0) + " finished \n");

            task.remove(0); //remove that first value from the queue because it is done
            priority.remove(0);
            burst.remove(0);

        } else {
            currentBurst += 10; //add the burst time to the sum for calculations
            turnaroundTime.add(currentBurst); //add to the turnaroundTime list
            waitingTime.add(currentBurst - 10);//add to the WaitingTime - 10 since 10 is the quantum

            burst.set(0, burstTime - 10); //set new burst times minus the quantum
            task.add(task.get(0)); //add the task to the end of the queue
            priority.add(priority.get(0)); //add the task to the end of the queue
            burst.add(burst.get(0)); //add the task to the end of the queue

            task.remove(0); //remove of it from the front of the queue.
            priority.remove(0);
            burst.remove(0);
        }

        return ;
        //Select next process
        //currClient = 1 - currClient;
        //return clients[currClient];
    }

    public void run(){
        while(true){
            //Schedule
            //System.out.println("Scheduling");
            Process client = schedule();
            //System.out.println(client);
            if(client != null) {
                int result = client.run(1);
                if (result == -1) {
                    //delete process from queue and processes
                    clients[0] = null;
                }else{
                    System.out.println("Result: "+ result);
                }
            }
        }
    }
}
