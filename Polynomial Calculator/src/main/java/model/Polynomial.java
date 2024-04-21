package model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

        private TreeMap<Integer,Double> p = new TreeMap<>(Comparator.reverseOrder());
        public Polynomial(){
        }
        public Polynomial(String text){
                pFromString(text);
        }
        public void addMonomial(int degree, double coefficient){
                p.put(degree,  coefficient);
        }
        public void pFromString(String text){
                String pattern ="([+-]?\\d*)(x)?\\^?(\\d*)?";
                Pattern regex=Pattern.compile(pattern);
                Matcher matcher=regex.matcher(text);
                while(matcher.find()){
                        String coef=matcher.group(1);
                        String coefX=matcher.group(2);
                        String deg= matcher.group(3);
                        double coef2;
                        int deg2;
                        if(coef==null || coef.isEmpty() ){
                                if(coefX==null || coefX.isEmpty()) coef2=0;
                                else coef2=1;
                        }
                        else if(coef=="-")      coef2=-1;
                        else if(coef=="+")      coef2=1;
                        else     coef2=Integer.parseInt(coef);
                        if(coefX==null || coefX.isEmpty())    deg2=0;
                        else if(deg==null || deg.isEmpty())   deg2=1;
                        else    deg2=Integer.parseInt(deg);
                        if(coef2!=0 || deg2!=0)   addMonomial(deg2,coef2);
                }
        }

        @Override
        public String toString() {
                String r="";
                if(p.isEmpty()){
                        r= String.valueOf('0');
                }
                else{
                        for (Map.Entry<Integer,Double>entry: p.entrySet()) {
                                if(entry.getValue()>0){
                                        r=r+"+"+String.valueOf(entry.getValue())+ "x^"+ String.valueOf(entry.getKey());
                                }
                                else if (entry.getValue()<0){
                                        r=r+String.valueOf(entry.getValue())+ "x^"+ String.valueOf(entry.getKey());
                                }

                        }
                }

                return r;
        }

        public TreeMap<Integer, Double> getP() {
                return p;
        }
}
