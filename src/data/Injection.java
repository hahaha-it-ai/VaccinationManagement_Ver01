
package data;

import java.io.Serializable;

/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class Injection implements Serializable
{
    private String injectionID;
    private String injectionPlace1st;
    private String injectionPlace2nd = "";
    private String injectionDate1st;
    private String injectionDate2nd = "";
    private String studentID;
    private String vaccineID;

    public Injection(String injectionID, String studentID, String vaccineID,
                     String injectionPlace1st, String injectionDate1st)
    {
        this.injectionID = injectionID;
        this.injectionPlace1st = injectionPlace1st;
        this.injectionDate1st = injectionDate1st;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
    }

    public String getInjectionID()
    {
        return injectionID;
    }

    public void setInjectionID(String injectionID) 
    {
        this.injectionID = injectionID;
    }

    public String getInjectionPlace1st() 
    {
        return injectionPlace1st;
    }

    public void setInjectionPlace1st(String injectionPlace1st)
    {
        this.injectionPlace1st = injectionPlace1st;
    }

    public String getInjectionPlace2nd() 
    {
        return injectionPlace2nd;
    }

    public void setInjectionPlace2nd(String injectionPlace2nd) 
    {
        this.injectionPlace2nd = injectionPlace2nd;
    }

    public String getInjectionDate1st() 
    {
        return injectionDate1st;
    }

    public void setInjectionDate1st(String injectionDate1st) 
    {
        this.injectionDate1st = injectionDate1st;
    }

    public String getInjectionDate2nd() 
    {
        return injectionDate2nd;
    }

    public void setInjectionDate2nd(String injectionDate2nd) 
    {
        this.injectionDate2nd = injectionDate2nd;
    }

    public String getStudentID() 
    {
        return studentID;
    }

    public void setStudentID(String studentID) 
    {
        this.studentID = studentID;
    }

    public String getVaccineID()
    {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID)
    {
        this.vaccineID = vaccineID;
    }
    
    public void showInjectionInfor(String studentName, String vaccineName)
    {
        System.out.printf("| %-10s | %-10s | %-20s | %-10s |%-12s| %10s | %-25s | %10s | %-25s |\n",
        injectionID, studentID, studentName, vaccineID, vaccineName, injectionDate1st,
        injectionPlace1st, injectionDate2nd, injectionPlace2nd);
    }

    @Override
    public String toString() 
    {
        return String.format("| %-10s | %-10s | %-10s | %10s | %-25s |"
                + " %10s | %-25s |\n",
        injectionID, studentID, vaccineID, injectionDate1st,
        injectionPlace1st, injectionDate2nd, injectionPlace2nd);
        
    }
}
