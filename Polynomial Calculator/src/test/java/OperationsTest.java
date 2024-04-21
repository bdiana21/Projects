import logic.Operations;
import model.Polynomial;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void addTest(){
        Polynomial p1 = new Polynomial("3x^4+2x^2+3");
        Polynomial p2 = new Polynomial("2x^5+3x^2+6x+7");
        Polynomial p3 = new Polynomial("4x^5-3x^4+1x^2-8x+1");
        Polynomial p4 = new Polynomial("3x^4-1x^3+1x^2+2x-1");
        Polynomial sum = Operations.add(p1,p2);
        Polynomial sum2 = Operations.add(p3,p4);
        String result = sum.toString();
        String result2 = sum2.toString();
        assertEquals (result, "+2.0x^5+3.0x^4+5.0x^2+6.0x^1+10.0x^0");
        assertEquals (result2, "+4.0x^5-1.0x^3+2.0x^2-6.0x^1");
    }

    @Test
    public void subtractTest(){
        Polynomial p1 = new Polynomial("3x^4+2x^2+3");
        Polynomial p2 = new Polynomial("2x^5+3x^2+6x+7");
        Polynomial p3 = new Polynomial("4x^5-3x^4+1x^2-8x+1");
        Polynomial p4 = new Polynomial("3x^4-1x^3+1x^2+2x-1");
        Polynomial dif = Operations.substract(p1,p2);
        Polynomial dif2 = Operations.substract(p3,p4);
        String result = dif.toString();
        String result2 = dif2.toString();
        assertEquals (result, "-2.0x^5+3.0x^4-1.0x^2-6.0x^1-4.0x^0");
        assertEquals (result2, "+4.0x^5-6.0x^4+1.0x^3-10.0x^1+2.0x^0");
    }

    @Test
    public void multiplyTest(){
        Polynomial p1 = new Polynomial("3x^2-1x+1");
        Polynomial p2 = new Polynomial("x-2");
        Polynomial p3 = new Polynomial("3x^2+2x+1");
        Polynomial p4 = new Polynomial("4x^3-1x^2+2");
        Polynomial produs = Operations.multiply(p1,p2);
        Polynomial produs2 = Operations.multiply(p3,p4);
        String result = produs.toString();
        String result2 = produs2.toString();
        assertEquals (result, "+3.0x^3-7.0x^2+3.0x^1-2.0x^0");
        assertEquals (result2, "+12.0x^5+5.0x^4+2.0x^3+5.0x^2+4.0x^1+2.0x^0");
    }

    @Test
    public void divideTest(){
        Polynomial p1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial("x^2-1");
        Polynomial p3 = new Polynomial("4x-4");
        Polynomial p4 = new Polynomial("2x-2");
        Polynomial[] div = Operations.divide(p1,p2);
        Polynomial[] div2 = Operations.divide(p3,p4);
        String result = div[0].toString();
        String result2 = div[1].toString();
        String result3 = div2[0].toString();
        String result4 = div2[1].toString();
        assertEquals (result, "+1.0x^1-2.0x^0");
        assertEquals (result2, "+7.0x^1-7.0x^0");
        assertEquals (result3, "+2.0x^0");
        assertEquals (result4, "");
    }

    @Test
    public void derivateTest(){
        Polynomial p1 = new Polynomial("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial("3x^4-2x^3+5x^2-1x+7");
        Polynomial deriv = Operations.derivative(p1);
        Polynomial deriv2 = Operations.derivative(p2);
        String result = deriv.toString();
        String result2 = deriv2.toString();
        assertEquals (result, "+3.0x^2-4.0x^1+6.0x^0");
        assertEquals (result2, "+12.0x^3-6.0x^2+10.0x^1-1.0x^0");
    }

    @Test
    public void integrateTest(){
        Polynomial p1 = new Polynomial("x^3+6x^2+5");
        Polynomial p2 = new Polynomial("2x^3+3x^2-5x+2");
        Polynomial integral = Operations.integral(p1);
        Polynomial integral2 = Operations.integral(p2);
        String result = integral.toString();
        String result2 = integral2.toString();
        assertEquals (result, "+0.25x^4+2.0x^3+5.0x^1");
        assertEquals (result2, "+0.5x^4+1.0x^3-2.5x^2+2.0x^1");
    }


}