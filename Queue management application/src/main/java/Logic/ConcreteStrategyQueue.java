package Logic;



import Model.Server;
import Model.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task newTask) {
            int min=servers.get(0).getTasks().size();
            int k=0;
              for(Server i: servers) {
                  if (i.getTasks().size() < min) {
                      min = i.getTasks().size();
                      k = servers.indexOf(i);
                  }
              }

              servers.get(k).addTask(newTask);
    }
}
