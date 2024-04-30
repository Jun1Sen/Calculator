import java.util.HashMap;
import java.util.regex.Pattern;

public enum SysChisl {
    DEC,
    HEX,gg
    OCT,
    BIN;

    private static HashMap<SysChisl, String> regexSys = new HashMap<SysChisl,String>()
    {
        {
            put(SysChisl.DEC, "^[-+]?[1-9][0-9]+$");
            put(SysChisl.HEX, "^[-+]?[1-9A-F][0-9A-F]+$");
            put(SysChisl.OCT, "^[-+]?[1-7][0-7]+$");
            put(SysChisl.BIN, "^[-+]?[1][0-1]+$");
        }
    };

    public static boolean IsCorrectSysChislNum(SysChisl Syschisl, String num)
    {
        String pat = regexSys.get(Syschisl);
        return num.matches(pat);


    }
    public static double ParseToDec(SysChisl Syschisl,String num)
    {
        int number = 0;
        switch(Syschisl)
        {
            case DEC:
            {
                number = Integer.parseInt(num,10);
                break;
            }
            case HEX:
            {
                number = Integer.parseInt(num,16);
                break;
            }
            case OCT:
            {
                number = Integer.parseInt(num,8);
                break;
            }
            case BIN:
            {
                number = Integer.parseInt(num,2);
                break;
            }
        }
        return number;
    }
    public static String PrintResult(int result)
    {
        String BIN = "BIN: " + Integer.toBinaryString(result) + "\n";
        String OCT = "OCT: " + Integer.toOctalString(result) + "\n";
        String DEC = "DEC: " + result + "\n";
        String HEX = "HEX: " + Integer.toHexString(result) + "\n";

        return BIN + OCT + DEC + HEX;

    }
}
