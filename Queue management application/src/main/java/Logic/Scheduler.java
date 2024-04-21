package Logic;


import Model.Server;
import Model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNrOfServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNrOfServers, int maxTasksPerServer) {
        this.maxNrOfServers=maxNrOfServers;
        this.maxTasksPerServer=maxTasksPerServer;
        servers=new ArrayList<>();

        for(int i=0;i<maxNrOfServers;i++){
            Server server=new Server();
            servers.add(server);
            Thread thread= new Thread(server);
            thread.start();
        }
    }
    public void changeStrategy(SelectionPolicy policy) {
        if (policy == SelectionPolicy.SHORTEST_QUEUE) {
            strategy = new ConcreteStrategyQueue();
        }
        if (policy == SelectionPolicy.SHORTEST_TIME) {
            strategy = new ConcreteStrategyTime();
        }
    }

    public void dispathTask(Task task) {
       strategy.addTask(servers,task);
    }

    public List<Server> getServers() {
        return servers;
    }
 }