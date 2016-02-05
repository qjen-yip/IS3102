package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author yingweiliu
 */
@Remote
public interface AccountBeanRemote {
    
   public ArrayList checkAccount(String staffID, String password);

   public int checkUpdate(String staffID, String oldPassword, String newPassword, String new2Password);

    public int addStaff(String staffID, String name, String password, String email);
    
    public int removeStaff(String staffID);
    
    public List<String> listStaff();
   
}
