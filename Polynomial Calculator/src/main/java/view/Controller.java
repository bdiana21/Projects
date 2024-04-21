package view;


import logic.Operations;
import model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.TRUE;

public class Controller implements ActionListener {

    private View view;
    private Operations operations=new Operations();

    public Controller(View v){
        this.view = v;
    }

    public boolean validareInput(String text){
        for(char c: text.toCharArray()){
            if(Character.isLetter(c)){
                if(c!='x'){
                    return false;
                }
            }
            else if(!Character.isDigit(c) && c!='^' && c!='+' && c!='-' && c!=' '){
                return false;
            }
        }
        return true;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
            String text1= view.getNumber1TextField().getText();
            String text2=view.getNumber2TextField().getText();
            if(!validareInput(text1)|| !validareInput(text2)){
                JOptionPane.showMessageDialog(null,"Date de intrare invalide","Intrare invalida",JOptionPane.WARNING_MESSAGE);
            }
            Polynomial p1=new Polynomial(text1);
            Polynomial p2=new Polynomial(text2);
            Polynomial pResult=new Polynomial();
            Polynomial pResult2=new Polynomial();
            view.getResultTextField().setEnabled(TRUE);
            view.getResultTextField2().setEnabled(TRUE);
            String result2="";
             if (e.getSource() == view.getAddButton()) {
                 pResult=operations.add(p1, p2); }
             if (e.getSource() == view.getSubstractButton()) {
                 pResult=operations.substract(p1, p2); }
             if (e.getSource() == view.getMultiplyButton()) {
                 pResult=operations.multiply(p1, p2); }
             if (e.getSource() == view.getDivideButton()) {
                 if(operations.divide(p1,p2)!=null){
                     pResult=operations.divide(p1, p2)[0];
                     pResult2=operations.divide(p1, p2)[1];
                     result2=pResult2.toString();
                 }
                }
             if (e.getSource() == view.getDerivativeButton()) {
                 pResult=operations.derivative(p1);
                 pResult2=operations.derivative(p2);
                 result2=pResult2.toString(); }
             if (e.getSource() == view.getIntegralButton()) {
                 pResult=operations.integral(p1);
                 pResult2=operations.integral(p2);
                 result2=pResult2.toString(); }
             String result=pResult.toString();
             view.setResultTextField(result);
             view.setResultTextField2(result2);
    }
}
