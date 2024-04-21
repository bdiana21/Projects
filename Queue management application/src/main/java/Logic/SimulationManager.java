package Logic;



import GUI.View2;
import Model.LogText;
import Model.Server;
import Model.Task;
import GUI.Controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SimulationManager implements Runnable{
    public int timeLimit;
    public int maxServiceTime;
    public int minServiceTime;
    public int maxArrivalTime;
    public int minArrivalTime;
    public int numberOfServers;
    public int numberOfClients;
    public SelectionPolicy selectionPolicy;
    private Scheduler scheduler;
    private List<Task> generatedTasks;

    private int peekHour = 0;
    private int peekCount = 0;
    private int arrivalCount= 0;
    private int finishCount=0;
    private double averageWaitingTime=0;
    private double averageServiceTime=0;
    private View2 v;


    public SimulationManager( Controller c) {
         v = new View2("Simulation",c);
        JFrame frame2 = v;
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        timeLimit=c.getSimInt();
        maxServiceTime=c.getMaxSInt();
        minServiceTime=c.getMinSInt();
        maxArrivalTime=c.getMaxAInt();
        minArrivalTime=c.getMinAInt();
        numberOfClients=c.getNrCInt();
        numberOfServers=c.getNrQInt();
        if(c.getStrategie()==0){
            selectionPolicy=SelectionPolicy.SHORTEST_QUEUE;
        }
        else{
            selectionPolicy=SelectionPolicy.SHORTEST_TIME;
        }
        generateRandomTasks();
        scheduler=new Scheduler(numberOfServers,numberOfClients);
        scheduler.changeStrategy(selectionPolicy);
        Thread threadS=new Thread(this);
        threadS.start();
    }

    private void generateRandomTasks() {
        generatedTasks=new ArrayList<>();
        for(int i=0;i<numberOfClients;i++){
            Random random= new Random();
            int arrivalTime=random.nextInt(minArrivalTime,maxArrivalTime);
            int serviceTime=random.nextInt(minServiceTime,maxServiceTime);
            generatedTasks.add(new Task(i,arrivalTime,serviceTime));
            arrivalCount=arrivalCount+arrivalTime;
        }
        generatedTasks.sort(Comparator.comparingInt(Task::getArrivalTime));
    }

    @Override
    public void run() {
        StringBuilder waitingText = null;
        StringBuilder coziText = null;
        LogText.log("Clientii:\n");
        for (Task i : generatedTasks) {
            LogText.log("id: " + i.getID() + " arrival time: " +i.getArrivalTime() + " service time: " + i.getServiceTime());
        }
        int currentTime = 0;
        while (currentTime <= timeLimit) {
            LogText.log("\nTime: " + currentTime);
            v.getTimeTextField().setText(String.valueOf(currentTime));
            LogText.log("Waiting clients: ");
            waitingText=new StringBuilder();
            for (Task i : generatedTasks){
                if(i.getArrivalTime()>currentTime) {
                    LogText.log("(" + i.getID() + " " + i.getArrivalTime() + " " + i.getServiceTime() + ")");
                    waitingText.append("( ").append(i.getID()).append(", ").append(i.getArrivalTime()).append(", ").append(i.getServiceTime()).append("), ");
                    
                }
            }
            v.getWaitingTextField().setText(String.valueOf(waitingText));
            List<Task> listaClienti= new ArrayList<>(generatedTasks);
            for (Task i : listaClienti){
                if(i.getArrivalTime()==currentTime) {
                    scheduler.dispathTask(i);
                }
            }

            for (Server server : scheduler.getServers()) {
                BlockingQueue<Task> listaTasks = server.getTasks();
                for (Task i : listaTasks ){
                    if(i.getServiceTime()==0){
                        averageServiceTime=averageServiceTime+i.getServiceTimeInit();
                        finishCount=finishCount+currentTime;
                        listaTasks.remove(i);
                    }
                }
            }
            int k=0;
            for (int i = 0; i < numberOfServers; i++) {
                Server server = scheduler.getServers().get(i);
                k=k+server.getTasks().size();
                coziText=new StringBuilder();
                coziText.append("Queue ").append(i+1).append(": ").append(server.dateServer());
                v.getCoziTextField().get(i).setText(String.valueOf(coziText));
                LogText.log("Queue " + (i + 1) + ": " + server.dateServer());
            }
            if(k>peekCount){
                peekHour =currentTime;
                peekCount=k;
            }
            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int clientiN=0;
        for (Server server : scheduler.getServers()) {
            BlockingQueue<Task> listaTasks = server.getTasks();
            for (Task i : listaTasks ){
                if(i.getServiceTime()!=0){
                    finishCount=finishCount+currentTime;
                    clientiN++;
                }
            }
        }
        averageServiceTime=averageServiceTime/(numberOfClients-clientiN);
        averageWaitingTime= (double) (finishCount - arrivalCount) /numberOfClients;
        LogText.log("Average service time : " + averageServiceTime);
        LogText.log("Average waiting time : " + averageWaitingTime);
        LogText.log("Peek hour: " + peekHour);
    }

}