package GUI;

import GUI.Controller;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame  {
    private JPanel contentPanel;
    private JPanel bPanel;
    private JPanel textPanel;
    private JLabel nrClientsLabel;
    private JTextField nrClientsTextField;
    private JLabel nrQueuesLabel;
    private JTextField nrQueuesTextField;
    private JLabel simIntLabel;
    private JTextField simIntTextField;
    private JLabel minArrivalLabel;
    private JTextField minArrivalTextField;
    private JLabel maxArrivalLabel;
    private JTextField maxArrivalTextField;
    private JLabel minServiceLabel;
    private JTextField minServiceTextField;
    private JLabel maxServiceLabel;
    private JTextField maxServiceTextField;
    private JButton timeButton;
    private JButton queueButton;



    Controller controller = new Controller(this);

    public View(String name) {
        super(name);
        this.openInterface();
    }

    public void openInterface(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPanel = new JPanel(new GridLayout(2, 2));
        this.openText();
        this.openButons();
        this.setContentPane(this.contentPanel);
    }
    public void openText(){
        this.textPanel= new JPanel();
        this.textPanel.setLayout(new GridLayout(7,2));
        textPanel.setBackground(Color.getHSBColor(500, 70, 65));
        this.nrClientsLabel=new JLabel("NUMBER OF CLIENTS",JLabel.CENTER);
        this.textPanel.add(nrClientsLabel);
        this.nrClientsTextField=new JTextField();
        this.textPanel.add(nrClientsTextField);
        this.nrQueuesLabel=new JLabel("NUMBER OF QUEUES",JLabel.CENTER);
        this.textPanel.add(this.nrQueuesLabel);
        this.nrQueuesTextField=new JTextField();
        this.textPanel.add(this.nrQueuesTextField);
        this.simIntLabel=new JLabel("SIMULATION INTERVAL",JLabel.CENTER);
        this.textPanel.add(this.simIntLabel);
        this.simIntTextField=new JTextField();
        this.textPanel.add(this.simIntTextField);
        this.minArrivalLabel=new JLabel("MINIMUM ARRIVAL TIME",JLabel.CENTER);
        this.textPanel.add(this.minArrivalLabel);
        this.minArrivalTextField=new JTextField();
        this.textPanel.add(this.minArrivalTextField);
        this.maxArrivalLabel=new JLabel("MAXIMUM ARRIVAL TIME",JLabel.CENTER);
        this.textPanel.add(this.maxArrivalLabel);
        this.maxArrivalTextField=new JTextField();
        this.textPanel.add(this.maxArrivalTextField);
        this.minServiceLabel=new JLabel("MINIMUM SERVICE TIME",JLabel.CENTER);
        this.textPanel.add(this.minServiceLabel);
        this.minServiceTextField=new JTextField();
        this.textPanel.add(this.minServiceTextField);
        this.maxServiceLabel=new JLabel("MAXIMUM SERVICE TIME",JLabel.CENTER);
        this.textPanel.add(this.maxServiceLabel);
        this.maxServiceTextField=new JTextField();
        this.textPanel.add(this.maxServiceTextField);
        this.contentPanel.add(textPanel);
    }
    public void openButons(){

        this.bPanel= new JPanel();
        this.bPanel.setLayout(new GridLayout(4,2));
        bPanel.setBackground(Color.getHSBColor(210, 70, 65));
        this.timeButton=new JButton("SHORTEST TIME");
        this.bPanel.add(this.timeButton);
        this.queueButton=new JButton("SHORTEST QUEUE");
        this.bPanel.add(this.queueButton);
        this.contentPanel.add(bPanel);


        timeButton.addActionListener(controller);
        queueButton.addActionListener(controller);

    }

    public JTextField getNrClientsTextField() {
        return nrClientsTextField;
    }

    public JTextField getNrQueuesTextField() {
        return nrQueuesTextField;
    }

    public JTextField getSimIntTextField() {
        return simIntTextField;
    }

    public JTextField getMinArrivalTextField() {
        return minArrivalTextField;
    }

    public JTextField getMaxArrivalTextField() {
        return maxArrivalTextField;
    }

    public JTextField getMinServiceTextField() {
        return minServiceTextField;
    }

    public JTextField getMaxServiceTextField() {
        return maxServiceTextField;
    }

    public JButton getTimeButton() {
        return timeButton;
    }

    public JButton getQueueButton() {
        return queueButton;
    }
}
