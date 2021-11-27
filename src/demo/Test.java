
package demo;

import data.InformationCabinet;
import data.Injection;
import data.Student;
import data.Vaccine;
import data.file.FileInjection;
import data.file.FileStudent;
import data.file.FileVaccine;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import util.Menu;
import util.MyToys;

/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class Test
{
        //demo tính năng
    public static void main(String[] args) 
    {
        testProgram();
    
    }
    
    public static void testProgram()
    {
        Menu menu = new Menu("Welcome to Covid-19 Vaccine Management.", "@2021 by SE150402 - NGUYỄN LÊ PHƯƠNG HÀ.");
        menu.addANewChoice("0. Show Student List.");
        menu.addANewChoice("1. Show All Injection Information."); 
        menu.addANewChoice("2. Add A New Injection Information.");
        menu.addANewChoice("3. Update A Injection Information by InjectionID."); 
        menu.addANewChoice("4. Delete A Injection Information by InjectionID.");
        menu.addANewChoice("5. Search A Injection Information by StudentID.");
        menu.addANewChoice("6. Quit."); 
        
        //khởi tạo các list
        List<Student> listStudent; 
        List<Vaccine> listVaccine; 
        List<Injection> listInjection;
        
        File file;
        file = new File(MyToys.FILE_STUDENT);
        if (!file.exists())
            FileStudent.createStudentFile(MyToys.FILE_STUDENT);
        listStudent = FileStudent.readStudentFile(MyToys.FILE_STUDENT);

        file = new File(MyToys.FILE_VACCINE);
        if (!file.exists())
            FileVaccine.createVaccineFile(MyToys.FILE_VACCINE);
        listVaccine = FileVaccine.readVaccineFile(MyToys.FILE_VACCINE);
        
        file = new File(MyToys.FILE_INJECTION);
        if (file.exists())
            listInjection = FileInjection.readInjectionFile(MyToys.FILE_INJECTION);
        else
            listInjection = new ArrayList();
                    
        InformationCabinet fpt_sago = new InformationCabinet(listStudent, listVaccine, listInjection);
        int choice;
        
        do
        {
            menu.showMainMenu();
            choice = menu.getChoice(0, menu.getSize() - 1);
            
            switch (choice)
            {
                case 0:
                    fpt_sago.showStudentList();
                    break;
                case 1:
                    fpt_sago.showAllInjections();
                    break;
                case 2:
                    fpt_sago.addANewInjection();
                    break;
                case 3:
                    fpt_sago.updateInjection();
                    break;
                case 4:
                    fpt_sago.deleteInjection();
                    break;
                case 5:
                    fpt_sago.searchInjection();
                    break;       
            }        
        }
        while(choice != 6);
        MyToys.lineBorder();
        FileInjection.writeInjectionFile(MyToys.FILE_INJECTION, listInjection);
        System.out.println(">>> Quit.");     
    }
    
}
