package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Server implements Runnable{
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private static int idCoada=0;

    public Server() {
        tasks=new LinkedBlockingQueue<Task>();
        waitingPeriod =new AtomicInteger();
        idCoada++;
    }

    public void addTask(Task newTask) {

        tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());

    }

    public void run() {
        while (true) {
            if(!tasks.isEmpty()){
                Task client =tasks.peek();
                if(client != null){
                    int timpClient=client.getServiceTime();
                    for(int i=0;i<timpClient;i++){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        client.scadereTimp();
                    }
                }
            }
       }
    }

    public static int getIdCoada() {
        return idCoada;
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public String dateServer() {
        StringBuilder text = new StringBuilder(" ");
        if(tasks.isEmpty()){
            text = new StringBuilder("closed");
        }
        for(Task i:tasks){
            text.append("( ").append(i.getID()).append(", ").append(i.getArrivalTime()).append(", ").append(i.getServiceTime()).append(") ;");
        }
        return text.toString();
    }
}