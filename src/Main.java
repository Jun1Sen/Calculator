import org.w3c.dom.ranges.RangeException;

import java.io.Console;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Calculator Calculator = new Calculator(0,0,SysChisl.DEC,Operations.Addition);
        double result = 0;
        while (true)
        {
           try
           {
               System.out.println(String.format("\nВыбранная система счисления: %s\n\n",Calculator.getSysChisl()));
               System.out.println("1. Выбрать систему счисления");
               System.out.println("2. Показать ответ");
               System.out.println("3. Выполнить операцию над числами");

               Scanner in = new Scanner(System.in);
               int num = in.nextInt();


               System.out.println(String.format("Выбран пункт: %s",num));
               switch (num)
               {
                   case 1:
                   {
                       System.out.println("Введите номер пункта меню.");
                       System.out.println("1. DEC");
                       System.out.println("2. HEX");
                       System.out.println("3. OCT");
                       System.out.println("4. BIN");
                       Scanner inin = new Scanner(System.in);
                       int numMenu = inin.nextInt();
                       Calculator.setSysChisl(SysChisl.values()[numMenu-1]);
                       break;
                   }
                   case 2:
                   {
                       System.out.println(SysChisl.PrintResult((int)result));
                       break;
                   }
                   case 3:
                   {
                       Scanner inin = new Scanner(System.in);

                       String first = inin.next();
                       if (!SysChisl.IsCorrectSysChislNum(Calculator.getSysChisl(), first))
                       {
                           System.out.println("Данное число не подходит для выбранной системы счисления.");
                           break;
                       }
                       Calculator.setA(SysChisl.ParseToDec(Calculator.getSysChisl(),first));

                       String Operation = inin.next();
                       Operations op = Operations.valueOfString(Operation);

                       Calculator.setOperation(op);

                       String second = inin.next();
                       if (!SysChisl.IsCorrectSysChislNum(Calculator.getSysChisl(), second))
                       {
                           System.out.println("Данное число не подходит для выбранной системы счисления.");
                           break;
                       }
                       Calculator.setB(SysChisl.ParseToDec(Calculator.getSysChisl(),second));

                       result = Calculator.Calculate();
                       System.out.println(SysChisl.PrintResult((int)result));
                       break;
                   }
                   default:
                   {
                       System.out.println("Такого пункта не существует.");
                       break;
                   }
               }
           }
           catch (InputMismatchException e)
           {
                System.out.println("Введите существующий пункт меню.");
           }
           catch (RangeException e)
           {
               System.out.println("Введите число в диапазоне типа int");
           }
           catch (IllegalArgumentException e)
           {
                System.out.println(e.getMessage());
           }

            TimeUnit.SECONDS.sleep(3);



        }

    }




}

