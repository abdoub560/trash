package dz.trash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "Administrateur")
public class Admin extends User {

    private int admin_id;
    private String email;
    
    public Admin(int admin_id, String lastname, String firstname, String username, String pass, Date birthday, String email){
       super(lastname,firstname,username,pass,birthday);
        this.email = email;
        this.admin_id=admin_id;
    }
    public Admin(){

    }
    public Admin( String lastname, String firstname, String username, String pass, Date birthday, String email){
        super(lastname,firstname,username,pass,birthday);
        this.email = email;
    }
    
    private void deleteClient(int client_id){}
    private void disableChallenge(int challenge_id){}


    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return admin_id == admin.admin_id &&
                Objects.equals(email, admin.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), admin_id, email);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", email='" + email + '\'' +
                '}';
    }
}
