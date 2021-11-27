
package data.file;

import data.Injection;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class FileInjection 
{
    
    public static void writeInjectionFile(String fileName, List<Injection> listInjection)
    {
        try 
        {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);
            
            for (Injection x : listInjection)
                objectOutputStream.writeObject(x);
               
            objectOutputStream.close();
            file.close();
        } 
        catch (Exception e) 
        { 
        } 
    }
    
    public static List<Injection> readInjectionFile(String fileName) 
    {
        List<Injection> listInjection = new ArrayList();
        
        try 
        {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            Injection x = null;
            // dùng objectInputStream đọc theo Object, ép kiểu trả về Injection
            while((x = (Injection) objectInputStream.readObject()) != null)
                listInjection.add(x);
            
            fileInputStream.close();
            objectInputStream.close();
        } 
        catch (Exception e)
        {
        }
        
        return listInjection;
    }
    
}
