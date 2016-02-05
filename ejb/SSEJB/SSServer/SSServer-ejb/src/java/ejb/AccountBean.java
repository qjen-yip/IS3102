package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class AccountBean implements AccountBeanRemote {

 @PersistenceContext
    private EntityManager em;

    public AccountBean() {
    }

    public Account findAccount(String staffID) {
        Account account = new Account();
        try {
            Query q = em.createQuery("SELECT a FROM Account AS a WHERE a.staffID=:staffID");
            q.setParameter("staffID", staffID);
            account = (Account) q.getSingleResult();
        } catch (EntityNotFoundException enfe) {
            System.out.println("Staff ID not found error: " + enfe.getMessage());
        } catch (NonUniqueResultException nure) {
            System.out.println("Non Unique Result error: " + nure.getMessage());
        }
        return account;
    }


    @Override
    public ArrayList checkAccount(String staffID, String password) {
        ArrayList infoList = new ArrayList();
        try {
            Account account = findAccount(staffID);
            if (password.equals(account.getPassword())) {
                infoList.add(0, "success"); // if sucesss
                infoList.add(1, account.getId());
                infoList.add(2, account.getName());
                infoList.add(3, account.getStaffID());
                infoList.add(4, account.getEmail());
            } else {
                infoList.add(0, "wrongPw"); //password wrong
            }
        } catch (Exception ex) {
            infoList.add(0, "wrongID"); //no student
        }
        return infoList;
    }
   
    //check validation of update profile
    //return -1 wrong pw; -2 inconsistent;-3 no student; 1 success
    @Override
    public int checkUpdate(String staffID, String oldPassword, String newPassword, String new2Password) {
        Account account = findAccount(staffID);
        try {
            if (!oldPassword.equals(account.getPassword())) {
                return -1; //wrong pw
            } else if (!newPassword.equals(new2Password)) {
                return -2; //inconsistent
            } else {
                account.setPassword(newPassword);
                return 1; //success
            }
        } catch (Exception ex) {
            return -3; //no student
        }
    }
    
     public Account findStaff(String staffID) {
        Account account = new Account();
        try {
            Query q = em.createQuery("SELECT a FROM Account AS a WHERE a.staffID=:staffID");
            q.setParameter("staffID", staffID);
            account = (Account) q.getSingleResult();
        } catch (EntityNotFoundException enfe) {
            System.out.println("Staff not found error: " + enfe.getMessage());
        } catch (NonUniqueResultException nure) {
            System.out.println("Non Unique Result error: " + nure.getMessage());
        }
        return account;
    }
 
    @Override
    public List<String> listStaff() {
        try {
            List<String> infoList = new ArrayList<String>();
            List<Account> accounts = em.createNamedQuery("Account.findAll").getResultList();
            String infoString = "";
            for (Account a : accounts) {
                infoString = a.getStaffID();
                infoList.add(infoString);
            }
            return infoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     //@return 1 success; -1 student exist
    @Override
    public int addStaff(String staffID, String name, String password, String email) {
        try {
            Account tempstaff = findStaff(staffID);
            //student exist
            return -1;
        } catch (Exception e) {
            Account account = new Account();
            account.createAccount(staffID, name, password, email);
            em.persist(account);
            return 1;
        }
    }

    //@return 0 deleted; -1 no Student; -2 have module; -3 have appeal; -4 have tutorial
    @Override
    public int removeStaff (String staffID) {
        try {
            Account account = findStaff(staffID);
           
            em.remove(account);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }
}