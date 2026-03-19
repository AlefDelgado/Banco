package FILES;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author alefdelgado
 */
public class Users
{
    public static final String FILE = "cuentas.txt";
    
    public void saveAcount(ArrayList<account> accounts)
    {
        
    }
    
    public ArrayList<account> loadUsers()
    {
        ArrayList<account> accounts= new ArrayList<>();
        File file = new File(FILE);
        
        
        
        return accounts;
    }
    
}
