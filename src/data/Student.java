
package data;

import java.io.Serializable;


/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class Student implements Serializable
{
    private String studentID;
    private String studentName;

    public Student(String studentID, String studentName) 
    {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }
    
    public void showStudentInfor()
    {                          
        System.out.printf("| %-10s | %-30s |\n",
                           studentID, studentName); 
    }

    @Override
    public String toString()
    {
        return String.format("| %-10s | %-30s |\n",
                              studentID, studentName);
    }

}
