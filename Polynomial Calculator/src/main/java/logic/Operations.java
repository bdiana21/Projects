package logic;

import model.Polynomial;


import javax.swing.*;
import java.util.Map;

public class Operations {
    public static Polynomial add(Polynomial p1, Polynomial p2){
        Polynomial newP=new Polynomial();
        for (Map.Entry<Integer,Double>entry1: p1.getP().entrySet()){
            newP.addMonomial(entry1.getKey(),entry1.getValue());
        }
        for (Map.Entry<Integer,Double>entry2: p2.getP().entrySet()){
            if(newP.getP().containsKey(entry2.getKey())){
                double sum = entry2.getValue() + newP.getP().get(entry2.getKey());
                newP.addMonomial(entry2.getKey(),sum);
                }
            else{
                newP.addMonomial(entry2.getKey(),entry2.getValue());
            }
        }
        return newP;
    }
    public static Polynomial substract(Polynomial p1, Polynomial p2){
        Polynomial newP=new Polynomial();
        for (Map.Entry<Integer,Double>entry1: p1.getP().entrySet()){
            newP.addMonomial(entry1.getKey(),entry1.getValue());
        }
        for (Map.Entry<Integer,Double>entry2: p2.getP().entrySet()){
            if(newP.getP().containsKey(entry2.getKey())){
                double dif = newP.getP().get(entry2.getKey())-entry2.getValue();
                if(dif==0){
                    newP.getP().remove(entry2.getKey());
                }
                else{
                    newP.addMonomial(entry2.getKey(),dif);
                }
            }
            else{
                newP.addMonomial(entry2.getKey(),(-entry2.getValue()));
            }
        }
        return newP;
    }
    public static Polynomial multiply(Polynomial p1, Polynomial p2){
        Polynomial newP=new Polynomial();
        for (Map.Entry<Integer,Double>entry1: p1.getP().entrySet()){
            for (Map.Entry<Integer,Double>entry2: p2.getP().entrySet()){
                int degNou=entry1.getKey()+entry2.getKey();
                double coefNou= entry1.getValue()*entry2.getValue();
                if(newP.getP().containsKey(degNou)){
                    coefNou += newP.getP().get(degNou);
                }
                newP.addMonomial(degNou,coefNou);
            }
        }
        return newP;
    }
    public static Polynomial[] divide(Polynomial p1, Polynomial p2){
        Polynomial[] rezultat = new Polynomial[2];
        rezultat[0]=new Polynomial();
        rezultat[1]=new Polynomial();
        Polynomial remainder = new Polynomial();
        Polynomial quotient = new Polynomial();
        if(p2.getP().isEmpty() || p1.getP().isEmpty()){
               JOptionPane.showMessageDialog(null,"Nu se poate impartii la 0","Eroare",JOptionPane.WARNING_MESSAGE);
            return null;
        }
        int deg1= p1.getP().firstKey();
        int deg2= p2.getP().firstKey();
        if(deg1<deg2){
            Polynomial auxP=p1;
            p1=p2;
            p2=auxP; }
        int divisorDeg= p2.getP().firstEntry().getKey();
        double divisorCoef= p2.getP().firstEntry().getValue();
        while ((!p1.getP().isEmpty()) && (p1.getP().firstKey()>=divisorDeg)){
            remainder.getP().clear();
            int degNou= p1.getP().firstEntry().getKey()-divisorDeg;
            double coefNou= p1.getP().firstEntry().getValue()/divisorCoef;
            quotient.addMonomial(degNou,coefNou);
            for(Integer deg: p2.getP().keySet()){
                double coef = p2.getP().get(deg);
                remainder.addMonomial(degNou + deg,coefNou* coef);
            }
            p1= substract(p1,remainder);
        }
        rezultat[0]=quotient;
        if(!p1.getP().isEmpty()) rezultat[1]=p1;
        else rezultat[1].addMonomial(0,0);
        return rezultat;
    }
    public static Polynomial derivative(Polynomial p1){
        Polynomial newP=new Polynomial();
        for (Map.Entry<Integer,Double>entry1: p1.getP().entrySet()){
            if(entry1.getKey()!=0){
                double coefNou= entry1.getValue()*entry1.getKey();
                int degNou=entry1.getKey()-1;
                newP.addMonomial(degNou,coefNou);
            }
        }
        return newP;
    }
    public static Polynomial integral(Polynomial p1){
        Polynomial newP=new Polynomial();
        for (Map.Entry<Integer,Double>entry1: p1.getP().entrySet()){
            int degNou=entry1.getKey()+1;
            double coefNou= entry1.getValue()/degNou;
            newP.addMonomial(degNou,coefNou);
        }
        return newP;
    }
}
