
package util;

import java.util.*;

/**
 * @author SE150402_Nguyễn Lê Phương Hà_Void
 */

public class Menu 
{
    private List<String> arr = new ArrayList();
    private String titleMenu;
    private String subTitle;

    public Menu(String titleMenu, String subTitle) 
    {
        this.titleMenu = titleMenu;
        this.subTitle = subTitle;
    }

    public String getTitleMenu() 
    {
        return titleMenu;
    }

    public void setTitleMenu(String titleMenu) 
    {
        this.titleMenu = titleMenu;
    }

    public String getSubTitle() 
    {
        return subTitle;
    }

    public void setSubTitle(String subTitle) 
    {
        this.subTitle = subTitle;
    }
    
    public void addANewChoice(String s)
    {
        arr.add(s);
    }
    
    public int getSize()
    {
        return arr.size();
    }
    
    public int getChoice(int startPoint, int endPoint)
    {
        String s = ">>> Your Choice ["+ startPoint + "..." + endPoint +"] is ";
        int choice = MyToys.getAnInteger(s, "False Format. Your Choice Must Be From " 
                    + startPoint + " To " + endPoint + ". Input Agian!", startPoint, endPoint);
        return choice;
    }
    
    public void showMainMenu()
    {
        MyToys.lineBorder();
        System.out.println(titleMenu);
        System.out.println(subTitle);
        System.out.println("");
        arr.forEach((s) -> { System.out.println(s);});
        MyToys.lineBorder();
    }
    
    public void showSubMenu()
    {
        System.out.println(titleMenu);
        arr.forEach((s) -> { System.out.print(s);});
    }
}
