
package data.file;

import data.Vaccine;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class FileVaccine 
{
    
    public static void createVaccineFile(String fileName)
    {
        try 
        {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            List<Vaccine> listVaccine = new ArrayList();
            listVaccine.add(new Vaccine("Covid-V001", "AstraZeneca"));
            listVaccine.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            listVaccine.add(new Vaccine("Covid-V003", "Vero Cell"));
            listVaccine.add(new Vaccine("Covid-V004", "Pfizer"));
            listVaccine.add(new Vaccine("Covid-V005", "Moderna"));
            
            //ghi file object
            for (Vaccine x : listVaccine) 
                objectOutputStream.writeObject(x);
            
            objectOutputStream.close();
            fileOutputStream.close();

        } 
        catch (Exception e) 
        {
        }
    }
    
    public static List<Vaccine> readVaccineFile(String fileName) 
    {
        List<Vaccine> listVaccine = new ArrayList();
        
        try 
        {
            FileInputStream fileInputStream = new FileInputStream(fileName); 
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Vaccine x;
            // dùng objectInputStream đọc theo Object, ép kiểu trả về Vaccine
            //chưa null cứ đọc tiếp
            while ((x = (Vaccine) objectInputStream.readObject()) != null) 
                listVaccine.add(x);
                
            fileInputStream.close();
            objectInputStream.close();  
        } 
        catch (Exception e)
        {
        }
        
        return listVaccine;
    }
}
