
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * @author SE150402_Nguyễn Lê Phương Hà_Void
 */

public class MyToys 
{
    public static Scanner sc = new Scanner(System.in);

    //file name student
    public static final String FILE_STUDENT= "student.dat";
    
    //file name Vaccine
    public static final String FILE_VACCINE = "vaccine.dat";
    
    //file name injection
    public static final String FILE_INJECTION = "injection.dat";
     
    //Regular Expression: kiểm tra ngày, dd/MM/yyyy
    public static final String FORMAT_DMY = "((0[1-9]|[12]\\d|3[0-1])/(0[1-9]|1[0-2])/(202[1-9]))";
    
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static SimpleDateFormat converter = new SimpleDateFormat(DATE_FORMAT);
    
    public static boolean isValidDate(String day)
    {
        try 
        {
            converter.setLenient(false);
            converter.parse(day);
            return true;
        } 
        catch (ParseException e)
        {
            return false;
        }
    }
    
    //kiểm tra ngày có nằm trong khoảng ko?
    public static boolean isInRangeDate(String day1st, String day2nd) 
    {
        try 
        {
            Date d1 = converter.parse(day1st);
            Date d2 = converter.parse(day2nd);
            
            //2 mốc thời gian giới hạn
            int lower = 4*7*24*60*60; //time 4 tuần:  s
            int upper = 12*7*24*60*60; //time 12 tuần:  s

            //chênh lệch thời gian, đơn vị s
            long check = (d2.getTime() - d1.getTime())/1000; 
            
            if (lower <= check && check <= upper)
                return true;   
        }
        catch (ParseException e)
        {
            return false;
        }
        return false;
    }

    public static String getString(String inputMsg, String errorMsg) 
    {
        String id;        
        while (true) 
        {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            
            //kiểm tra chuỗi rỗng
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else 
                return id;
        }
    }
    
    //nhập số nguyên trong khoảng
    public static int getAnInteger(String inputMsg, String errorMsg,
            int lowerBound, int upperBound)
    {
        int n;
        
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) 
        {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        
        while (true) 
        {
            try 
            {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
            } 
            catch (Exception e) 
            {
                System.out.println(errorMsg);
            }
        }  
    }
    
    public static void headTable()
    {
        System.out.println("+------------+------------+----------------------+------------+------------+------------+---------------------------+------------+---------------------------+");
        System.out.println("|Injection ID| Student ID |        NAME          | VACCINE ID |VACCINE NAME|  DATE 1ST  |    INJECTION PLACE 1ST    |  DATE 2ND  |    INJECTION PLACE 1ST    |");
        System.out.println("+------------+------------+----------------------+------------+------------+------------+---------------------------+------------+---------------------------+");
    }
    
    public static void lineTable()
    {
        System.out.println("+------------+------------+----------------------+------------+------------+------------+---------------------------+------------+---------------------------+");
    }
    
    public static void lineBorder()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
