package Logic;



import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task newTask) {
        int min=servers.get(0).getWaitingPeriod().get();
        int k=0;
        for(Server i: servers) {
            if (i.getWaitingPeriod().get() < min) {
                min = i.getWaitingPeriod().get();
                k = servers.indexOf(i);
            }
        }
        servers.get(k).addTask(newTask);
    }


}
