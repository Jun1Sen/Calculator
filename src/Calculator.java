import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements Calculation {

    private double a;
    private double b;
    private SysChisl Syschisl;
    private Operations Operation;
    public Calculator(double a, double b, SysChisl Syschisl, Operations Operation) {
        this.a = a;
        this.b = b;
        setOperation(Operation);
        setSysChisl(Syschisl);
    }

    public Operations getOperation() {
        return Operation;
    }
    public SysChisl getSysChisl() {
        return Syschisl;
    }

    public void setOperation(Operations operation) {
        Operation = operation;
    }

    public void setSysChisl(SysChisl sysChisl) {
        Syschisl = sysChisl;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double Calculate()
    {
        double result = 0;

        switch (Operation)
        {
            case Addition:
            {
                result = a + b;
                break;
            }
            case Substraction:
            {
                result = a - b;
                break;
            }
            case Multiplication:
            {
                result = a * b;
                break;
            }
            case Division:
            {
                result = a / b;
                break;
            }
            default:
            {
                break;
            }
        }

        return result;
    }


}
