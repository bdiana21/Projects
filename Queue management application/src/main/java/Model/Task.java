package Model;

public class Task {
    private int arrivalTime;
    private int serviceTime;
    private int serviceTimeInit;
    private int ID;

    public Task(int ID, int arrivalTime, int serviceTime) {
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.serviceTimeInit=serviceTime;
        this.ID=ID;
    }

    public int getServiceTimeInit() {
        return serviceTimeInit;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void scadereTimp() {
        if(serviceTime>0){
            serviceTime = serviceTime -1;
        }
    }

    public int getID() {
        return ID;
    }
}

