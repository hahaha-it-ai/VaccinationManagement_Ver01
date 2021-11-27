
package data;

import java.io.Serializable;


/**
 * @author Void_SE150402_Nguyễn Lê Phương Hà
 */

public class Vaccine implements Serializable
{
    private String vaccineID;
    private String vaccineName;

    public Vaccine(String vaccineID, String vaccineName)
    {
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }

    public String getVaccineID() 
    {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID)
    {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() 
    {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName)
    {
        this.vaccineName = vaccineName;
    }
    
    public void showVaccineInfor()
    {
        System.out.printf("| %-20s | %-30s |\n",
                           vaccineID, vaccineName); 
    }

    @Override
    public String toString()
    {
        return String.format("| %-20s | %-30s |\n",
                            vaccineID, vaccineName);
    }
       
}
