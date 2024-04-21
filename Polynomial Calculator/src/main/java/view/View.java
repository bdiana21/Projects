package view;
import javax.swing.*;
import java.awt.*;

import static java.lang.Boolean.FALSE;

public class View extends JFrame  {
    private JPanel contentPanel;
    private JPanel nrPanel;
    private JPanel opPanel;
    private JLabel number1Label;
    private JTextField number1TextField;
    private JLabel number2Label;
    private JTextField number2TextField;
    private JLabel resultLabel;
    private JTextField resultTextField;
    private JLabel resultLabel2;
    private JTextField resultTextField2;
    private JButton addButton;
    private JButton substractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton derivativeButton;
    private JButton integralButton;


    Controller controller = new Controller(this);

    public View(String name) {
        super(name);
        this.openInterface();
    }

    public void openInterface(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPanel = new JPanel(new GridLayout(2, 2));
        this.openNumbers();
        this.openOperations();
        this.setContentPane(this.contentPanel);
    }
    public void openNumbers(){
            this.nrPanel= new JPanel();
            this.nrPanel.setLayout(new GridLayout(5,2));
            nrPanel.setBackground(Color.getHSBColor(210, 70, 65));
            this.number1Label=new JLabel("FIRST NUMBER",JLabel.CENTER);
            this.nrPanel.add(number1Label);
            this.number1TextField=new JTextField();
            this.nrPanel.add(number1TextField);
            this.number2Label=new JLabel("SECOND NUMBER",JLabel.CENTER);
            this.nrPanel.add(this.number2Label);
            this.number2TextField=new JTextField();
            this.nrPanel.add(this.number2TextField);
            this.resultLabel=new JLabel("RESULT",JLabel.CENTER);
            this.nrPanel.add(this.resultLabel);
            this.resultTextField=new JTextField();
            this.nrPanel.add(this.resultTextField);
        this.resultLabel2=new JLabel("RESULT OPT",JLabel.CENTER);
        this.nrPanel.add(this.resultLabel2);
        this.resultTextField2=new JTextField();
        this.nrPanel.add(this.resultTextField2);
            this.resultTextField.setEnabled(FALSE);
            this.resultTextField2.setEnabled(FALSE);
            this.contentPanel.add(nrPanel);
    }
    public void openOperations(){

        this.opPanel= new JPanel();
        this.opPanel.setLayout(new GridLayout(5,2));
        opPanel.setBackground(Color.getHSBColor(210, 70, 65));
        this.addButton=new JButton("ADD");
        this.opPanel.add(this.addButton);
        this.substractButton=new JButton("SUBSTRACT");
        this.opPanel.add(this.substractButton);
        this.multiplyButton=new JButton("MULTIPLY");
        this.opPanel.add(this.multiplyButton);
        this.divideButton=new JButton("DIVIDE");
        this.opPanel.add(this.divideButton);
        this.derivativeButton=new JButton("DERIVATIVE");
        this.opPanel.add(this.derivativeButton);
        this.integralButton=new JButton("INTEGRAL");
        this.opPanel.add(this.integralButton);
        this.contentPanel.add(opPanel);


        addButton.addActionListener(controller);
        substractButton.addActionListener(controller);
        multiplyButton.addActionListener(controller);
        divideButton.addActionListener(controller);
        derivativeButton.addActionListener(controller);
        integralButton.addActionListener(controller);
    }

    public JTextField getNumber1TextField() {
        return number1TextField;
    }

    public JTextField getNumber2TextField() {
        return number2TextField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubstractButton() {
        return substractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getDerivativeButton() {
        return derivativeButton;
    }

    public JButton getIntegralButton() {
        return integralButton;
    }

    public void setResultTextField(String result) {
        this.resultTextField.setText(result);
    }

    public JTextField getResultTextField() {
        return resultTextField;
    }
    public void setResultTextField2(String result) {
        this.resultTextField2.setText(result);
    }

    public JTextField getResultTextField2() {
        return resultTextField2;
    }

}
