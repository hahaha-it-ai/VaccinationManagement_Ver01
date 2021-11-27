
package data;

import java.util.List;
import util.Menu;
import util.MyToys;

/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class InformationCabinet 
{
    List<Student> listStudent; 
    List<Vaccine> listVaccine; 
    List<Injection> listInjection;
    
    public InformationCabinet(List<Student> listStudent, List<Vaccine> listVaccine,
                              List<Injection> listInjection)
    {
        this.listStudent = listStudent;
        this.listVaccine = listVaccine;
        this.listInjection = listInjection;
    }
    
    //show all infor
    public void showStudentList()
    {
        MyToys.lineBorder();
        System.out.println(">>> Show Student List.");
        if (listStudent.isEmpty())
            System.out.println("List is Empty Now.");
        else
        {
            System.out.println("+------------+--------------------------------+");
            System.out.println("| Student ID |          Student Name          |");
            System.out.println("+------------+--------------------------------+");
            for (int i = 0; i < listStudent.size(); i++)
            {
                listStudent.get(i).showStudentInfor();
                System.out.println("+------------+--------------------------------+");
            }    
        }
        MyToys.lineBorder();
    }
    
    //show all infor
    public void showAllInjections()
    {
        MyToys.lineBorder();
        System.out.println(">>> Show All Injection Information.");
        if (listInjection.isEmpty())
            System.out.println("List is Empty Now.");
        else
        {
            MyToys.headTable();
            for (int i = 0; i < listInjection.size(); i++)
            {
                //tìm kiếm theo studentID --> tên
                //tìm kiếm theo vaccineID --> tên vaccine
                Student x = findStudentID(listInjection.get(i).getStudentID());
                Vaccine y = findVaccineID(listInjection.get(i).getVaccineID());
           
                listInjection.get(i).showInjectionInfor(x.getStudentName(), y.getVaccineName());
                MyToys.lineTable();
            }    
        }
        MyToys.lineBorder();
    }
    
    //tìm kiếm studentID trong listStudent
    private Student findStudentID(String studentID)
    {
        for (int i = 0; i < listStudent.size(); i++) 
            if (listStudent.get(i).getStudentID().equalsIgnoreCase(studentID)) 
                return listStudent.get(i);
        return null;
    }
    
    //tìm kiếm vaccineID trong listVaccine
    private Vaccine findVaccineID(String vaccineID)
    {
        for (int i = 0; i < listVaccine.size(); i++) 
            if (listVaccine.get(i).getVaccineID().equalsIgnoreCase(vaccineID)) 
                return listVaccine.get(i);
        return null;
    }
    
    //tìm kiếm injectionID trong listInjection
    private Injection findInjectionID(String injectionID)
    {
        for (int i = 0; i < listInjection.size(); i++) 
            if (listInjection.get(i).getInjectionID().equalsIgnoreCase(injectionID)) 
                return listInjection.get(i);
        return null;
    }
    
    //tìm kiếm studentID trong listInjection
    private Injection findStudentID_ListInjection(String studentID)
    {
        for (int i = 0; i < listInjection.size(); i++) 
            if (listInjection.get(i).getStudentID().equalsIgnoreCase(studentID)) 
                return listInjection.get(i);
        return null;
    }
    
    private String inputStudentID()
    {
        String studentID;
        while (true)
        {
            studentID = MyToys.getString("Input Student ID: ", "Empty! Input Again.");
            Student x = findStudentID(studentID);
            
            //ko tìm thấy trong listStudent
            if (x == null)
                System.out.println("This Student did Not Exist In Student List! Input Again.");
            else
            {
                //tìm kiếm trong listInjection
                Injection y = findStudentID_ListInjection(studentID);
                
                //ko tìm thấy
                if (y == null)
                    return studentID;
                else
                    System.out.println("This Student Injected Already! Input Again.");
            }
        }
    }
    
    private String inputInjectionID()
    {
        String injectionID;
        while (true)
        {
            injectionID = MyToys.getString("Input Injection ID: ", "Empty! Input Again.");
            Injection x = findInjectionID(injectionID);
            
            //tìm thấy trong listInjection
            if (x != null)
            {
                System.out.println("Injection ID Existed Already. Input Again.");
            }
            else
                return injectionID;
        }
    }
    
    private String inputVaccineID()
    {
        int choice = getChoiceVaccine();
        String vaccineID = listVaccine.get(choice - 1).getVaccineID();
        return vaccineID;
    }
    
    private int getChoiceVaccine()
    {
        Menu menuVaccine = new Menu("Choose Vaccine.", "");
        for (int i = 0; i < listVaccine.size(); i++) 
            menuVaccine.addANewChoice("| " + (i+1) + " " + listVaccine.get(i).toString());
        
        menuVaccine.showSubMenu();
        int choice = menuVaccine.getChoice(1, listVaccine.size());
        return choice;
    }
    
    private String inputDate1st(String messg)
    {
        String day;
        boolean match1, match2;
        while (true) 
        {            
            System.out.print(messg);
            day = MyToys.sc.nextLine().trim();
            
            //khớp chuỗi dd/MM/yyyy
            match1 = day.matches(MyToys.FORMAT_DMY);
            
            //ngày valid?
            match2 = MyToys.isValidDate(day);
            
            if (day.isEmpty() || match1 == false || match2 == false)
            {
                System.out.println("False Format! Input Again.");
                System.out.println(">> Hint: Please Follow Format dd/MM/yyyy.");
                System.out.println("Day, Month Must Be \"Real\". Year Must Be Greater Than 2020.");
            }
            else
                return day;           
        }
    }
    
    private String inputDate2st(String messg, String injectionDate1st)
    {
        String day2;
        while (true)
        {
            day2 = inputDate1st(messg);
            if (MyToys.isInRangeDate(injectionDate1st, day2))
                return day2;
            else
            {
                System.out.println("The 2ND Injection Must Be \"From 4 to 12 Weeks\" After the 1ST Injection.");
                System.out.println("This Time is Invalid! Input Again.");
            }      
        }
    }
    
    public Injection inputInjection()
    {
        String studentID = inputStudentID();
        String injectionID = inputInjectionID();
        String vaccineID = inputVaccineID();
        String injectionPlace1st = MyToys.getString("Input 1ST Injection Place: ", "Empty! Input Again.");
        String injectionDate1st = inputDate1st("Input 1ST Injection Date(dd/MM/yyyy): ");
        
        return new Injection(injectionID, studentID, vaccineID, 
                              injectionPlace1st, injectionDate1st);
    }
    
    public void addANewInjection()
    {
        MyToys.lineBorder();
        System.out.println(">>> Add A New Injection.");
        System.out.println("");
        listInjection.add(inputInjection());
        System.out.println("Adding Sucessfully!");
        MyToys.lineBorder();
        System.out.println("Do You Continue to Add A New Injection?");
        int i = MyToys.getAnInteger("Choose 1: Yes. 0: No, Turn to Menu. Your Choice is ",
                "False Format. Your Choice Must Be 0 or 1. Input Again.", 0, 1);
        if (i == 1)
            addANewInjection();
    }
    
    public void updateInjection()
    {
        MyToys.lineBorder();
        System.out.println(">>> Update A Injection Information by InjectionID.");
        System.out.println("");
        String injectionID = MyToys.getString("Input Updating InjectionID: ", "Empty! Input Again.");
        
        Injection x = findInjectionID(injectionID);
        if (x == null)
        {
            System.out.println("InjectionID did Not Exist!");
            System.out.println("Updating Unsucessfully!");
        }
        else
        {
            System.out.println("");
            if (!x.getInjectionDate2nd().isEmpty())
            {    
                MyToys.headTable();
                x.showInjectionInfor(findStudentID(x.getStudentID()).getStudentName(),
                                 findVaccineID(x.getVaccineID()).getVaccineName());
                MyToys.lineTable();
                System.out.println("Student has completed 2 injections!");
                System.out.println("Updating Unsucessfully!");
            }    
            else
            {
                String injectionPlace2nd = MyToys.getString("Input 2ND Injection Place: ", "Empty! Input Again.");
                String injectionDate2nd = inputDate2st("Input 2ND Injection Date(dd/MM/yyyy): ", x.getInjectionDate1st());
                x.setInjectionPlace2nd(injectionPlace2nd);
                x.setInjectionDate2nd(injectionDate2nd);
                MyToys.headTable();
                x.showInjectionInfor(findStudentID(x.getStudentID()).getStudentName(),
                                     findVaccineID(x.getVaccineID()).getVaccineName());
                MyToys.lineTable();
                System.out.println("Student Has Completed 2 Injections!");
                System.out.println("Updating Sucessfully!");         
            }
        }
        MyToys.lineBorder();
    }
    
    public void searchInjection()
    {
        MyToys.lineBorder();
        System.out.println(">>> Search A Injection Information by StudentID.");
        System.out.println("");
        String studentID = MyToys.getString("Input Student ID: ", "Empty! Input Again.");
        Injection x = findStudentID_ListInjection(studentID);
        if (x != null)
        {
            MyToys.headTable();
            x.showInjectionInfor(findStudentID(x.getStudentID()).getStudentName(),
                             findVaccineID(x.getVaccineID()).getVaccineName());
            MyToys.lineTable();
            System.out.println("Searching Sucessfully!");
        }
        else
            System.out.println("StudentID is Not Found In Injection List!");
        MyToys.lineBorder();
    }
    
    public void deleteInjection()
    {
        MyToys.lineBorder();
        System.out.println(">>> Delete A Injection Information by InjectionID.");
        System.out.println("");
        String injectionID = MyToys.getString("Input Deleting InjectionID: ", "Empty! Input Again.");
        Injection x = findInjectionID(injectionID);
        if (x == null)
        {
            System.out.println("InjectionID is Not Found to Delete.");
            System.out.println("Deleting Unsucessfully!");
        }
        else
        {
            MyToys.headTable();
            x.showInjectionInfor(findStudentID(x.getStudentID()).getStudentName(),
                                 findVaccineID(x.getVaccineID()).getVaccineName());
            MyToys.lineTable();
            System.out.println("Do You Want to Delete It? ");
            int i = MyToys.getAnInteger("Choose 1: Yes. 0: No, Turn to Menu. Your Choice is ",
                "False Format. Your Choice Must Be 0 or 1. Input Again.", 0, 1);
            if (i == 1)
            {
                listInjection.remove(x);
                System.out.println("Deleting Sucessfully!");
            }
            else
                System.out.println("Deleting Unsucessfully!");
        }   
        MyToys.lineBorder();
    }
}