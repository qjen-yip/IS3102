package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
@NamedQuery(name = "Account.findAll",
query = "SELECT a FROM Account a")
})

@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String staffID;
    private String name;
    private String password;
    private String email;
   
    public Account() {
        setId(System.nanoTime());
    }
    
    public void createAccount(String staffID, String name, String password, String email) {
        this.staffID = staffID;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStaffID() {
        return staffID;
    }
    
    public void setstaffID(String staffID) {
        this.staffID = staffID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ejb.AccountEntity[ id=" + id + " ]";
    }
}