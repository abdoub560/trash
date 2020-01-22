package dz.trash.model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table (name = "Utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue
    private int user_id ;
    protected String lastname;
    protected String firstname;
    protected String username;
    protected String pass;
    protected Date birthday;

    public User(int user_id, String lastname, String firstname, String username, String pass, Date birthday) {
        this.user_id = user_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.username = username;
        this.pass = pass;
        this.birthday = birthday;
    }

    public User() {
    }

    public User(String lastname, String firstname, String username, String pass, Date birthday) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.username = username;
        this.pass = pass;
        this.birthday = birthday;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(username, user.username) &&
                Objects.equals(pass, user.pass) &&
                Objects.equals(birthday, user.birthday);
    }


}
