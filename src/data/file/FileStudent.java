
package data.file;

import data.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class FileStudent 
{
    
    public static void createStudentFile(String fileName)
    {
        try 
        {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            
            List<Student> listStudent = demoStudentData(); //dữ liệu demo
            
            for (Student x : listStudent) 
                objectOutputStream.writeObject(x);
            
            objectOutputStream.close();
            file.close();
        } 
        catch (Exception e) 
        {   
        }
    }
    
    public static List<Student> readStudentFile(String fileName) 
    {
        List<Student> listStudent = new ArrayList();
        
        try 
        {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            Student x = null;
            // dùng objectInputStream đọc theo Object, ép kiểu trả về Student
            while((x = (Student) objectInputStream.readObject()) != null)
                listStudent.add(x);
            
            fileInputStream.close();
            objectInputStream.close();       
        } 
        catch (Exception e)
        {
        }
        
        return listStudent;
    }
    
    public static List<Student> demoStudentData()
    {
        List<Student> listStudent = new ArrayList();
        listStudent.add(new Student("SE150001", "NGUYỄN VĂN AN"));
        listStudent.add(new Student("SE150002", "LÊ VĂN ANH"));
        listStudent.add(new Student("SE150003", "TRẦN MỸ"));
        listStudent.add(new Student("SE150004", "VŨ MINH ĐỨC"));
        listStudent.add(new Student("SE150005", "NGÔ QUÂN"));
        listStudent.add(new Student("SE150006", "LÝ AN THIỆN"));
        listStudent.add(new Student("SE150007", "CHÂU TINH TRÌ"));
        listStudent.add(new Student("SE150008", "PHẠM NGỌC NGA"));
        listStudent.add(new Student("SE150009", "ĐOÀN VĨNH UYÊN"));
        listStudent.add(new Student("SE150010", "DƯƠNG NGÂN"));
        return listStudent;
    }  
    
    
}