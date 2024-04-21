package GUI;

import GUI.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;


public class View2 extends JFrame  {
    private JPanel contentPanel;
    private JPanel timePanel;
    private JPanel coziPanel;
    private JLabel timeLabel;
    private JTextField timeTextField;
    private JLabel waitingLabel;
    private JTextField waitingTextField;
    private int nrCozi=0;
    private ArrayList<JTextField> coziTextField;


    public View2(String name, Controller c) {
        super(name);
        nrCozi=c.getNrQInt();
        coziTextField= new ArrayList<>(nrCozi);
        this.openInterface();
    }


    public void openInterface(){
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPanel = new JPanel(new BorderLayout());
        this.setContentPane(this.contentPanel);
        contentPanel.setBackground(new Color(246,176,176));
        openTime();
        openCozi();
    }
    public void openTime(){

            this.timePanel = new JPanel(new GridLayout(2, 1));
            timePanel.setBackground(Color.getHSBColor(500, 70, 65));
            JPanel timeInputPanel = new JPanel(new BorderLayout());
            timeInputPanel.setBackground(new Color(246,176,176));
            this.timeLabel = new JLabel("TIME", SwingConstants.CENTER);
            this.timeLabel.setPreferredSize(new Dimension(100, 80));
            timeInputPanel.add(timeLabel, BorderLayout.WEST);
            this.timeTextField = new JTextField();
            this.timeTextField.setPreferredSize(new Dimension(200, 80));
            timeTextField.setBackground(new Color(246,176,176));
            this.timeTextField.setEditable(FALSE);
            timeInputPanel.add(timeTextField, BorderLayout.CENTER);
            JPanel waitingInputPanel = new JPanel(new BorderLayout());
            waitingInputPanel.setBackground(new Color(246,176,176));
            this.waitingLabel = new JLabel("WAITING LINE", SwingConstants.CENTER);
            this.waitingLabel.setPreferredSize(new Dimension(100, 80));
            waitingInputPanel.add(waitingLabel, BorderLayout.WEST);
            this.waitingTextField = new JTextField();
            this.waitingTextField.setPreferredSize(new Dimension(200, 80));
            waitingTextField.setBackground(new Color(246,176,176));
            this.waitingTextField.setEditable(false);
            waitingInputPanel.add(waitingTextField, BorderLayout.CENTER);
            timePanel.add(timeInputPanel);
            timePanel.add(waitingInputPanel);
            this.contentPanel.add(timePanel, BorderLayout.NORTH);
    }
    public void openCozi(){
        this.coziPanel= new JPanel();
       this.coziPanel.setLayout(new GridLayout(nrCozi,1));
        for (int i=0;i<nrCozi;i++){
            JTextField coziTextField = new JTextField();
            coziTextField.setBackground(new Color(246,176,176));
            coziTextField.setEditable(false);
            this.coziTextField.add(coziTextField);
        }
        for (int i=0;i<nrCozi;i++){
            this.coziPanel.add(coziTextField.get(i));
        }
        this.contentPanel.add(coziPanel, BorderLayout.CENTER);
    }

    public JTextField getTimeTextField() {
        return timeTextField;
    }

    public JTextField getWaitingTextField() {
        return waitingTextField;
    }

    public ArrayList<JTextField> getCoziTextField() {
        return coziTextField;
    }
}
