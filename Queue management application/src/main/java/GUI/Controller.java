package GUI;

import Logic.SimulationManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener {

    private View view;
    private View2 view2;

    private int nrCInt;
    private int nrQInt;
    private int simInt;
    private int minAInt;
    private int maxAInt;
    private int minSInt;
    private int maxSInt;
    private int strategie;


    public Controller(View v){
        this.view = v;
    }

    public int getNrCInt() {
        return nrCInt;
    }

    public int getNrQInt() {
        return nrQInt;
    }

    public int getSimInt() {
        return simInt;
    }

    public int getMinAInt() {
        return minAInt;
    }

    public int getMaxAInt() {
        return maxAInt;
    }

    public int getMinSInt() {
        return minSInt;
    }

    public int getMaxSInt() {
        return maxSInt;
    }

    public int getStrategie() {
        return strategie;
    }


    public boolean validareInput(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        String nrC= view.getNrClientsTextField().getText();
        String nrQ= view.getNrQueuesTextField().getText();
        String sim= view.getSimIntTextField().getText();
        String minA= view.getMinArrivalTextField().getText();
        String maxA= view.getMaxArrivalTextField().getText();
        String minS= view.getMinServiceTextField().getText();
        String maxS= view.getMaxServiceTextField().getText();

        if(!validareInput(nrC)||!validareInput(nrQ)||!validareInput(minA)||!validareInput(maxA)|| !validareInput(minS)
                ||!validareInput(maxS) ){
            JOptionPane.showMessageDialog(null,"Date de intrare invalide","Intrare invalida",JOptionPane.WARNING_MESSAGE);
        }
        else{
            nrCInt=Integer.parseInt(nrC);
            nrQInt=Integer.parseInt(nrQ);
            simInt=Integer.parseInt(sim);
            minAInt=Integer.parseInt(minA);
            maxAInt=Integer.parseInt(maxA);
            minSInt=Integer.parseInt(minS);
            maxSInt=Integer.parseInt(maxS);
        }

        if (e.getSource() == view.getQueueButton()) {
                strategie=0;
                SimulationManager simulation= new SimulationManager(this);

        }
        if (e.getSource() == view.getTimeButton()) {
                strategie=1;
                SimulationManager simulation= new SimulationManager(this);
        }



    }
}
