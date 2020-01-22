package dz.trash.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table (name = "clientele")
public class Client extends User {

    private int client_id;
    private String phoneNumber;
    private String androidVersion;
    @OneToMany(targetEntity =Note.class , mappedBy = "client",fetch = FetchType.LAZY)
    private Set<Note> notes;
    @OneToMany (targetEntity =Comment.class , mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private Set<Comment> comments;
    @OneToMany (targetEntity =Challenge.class , mappedBy = "owner",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

    private Set<Challenge> ownedChallenges;

    
    public Client(int client_id, String lastname, String firstname, String username, String pass, Date birthday, String phoneNumber, String androidVersion){
        super(lastname,firstname,username,pass,birthday);
        this.client_id=client_id;
        this.phoneNumber = phoneNumber;
        this.androidVersion = androidVersion;
        ownedChallenges=new HashSet<>();
        this.notes = new HashSet<>();
        this.comments=new HashSet<>();


    }

    public Client(String lastname, String firstname, String username, String pass, Date birthday, String phoneNumber, String androidVersion){
        super(lastname,firstname,username,pass,birthday);
        this.phoneNumber = phoneNumber;
        this.androidVersion = androidVersion;
        ownedChallenges=new HashSet<>();

        this.notes = new HashSet<>();
        this.comments=new HashSet<>();

    }
    public Client(){

    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public void addComment(Comment comment){
        if(!this.getComments().contains(comment)) {
            if (comment.getClient()!=null){comment.removeClient();}
            comment.setClient(this);
            getComments().add(comment);
        }
    }
    public void removeComment(Comment comment){
        if(this.getComments().contains(comment)){
            this.getComments().remove(comment);
            comment.setClient(null);
        }
    }
    public void addNote(Note note){
        if(!this.getNotes().contains(note)) {
            if (note.getClient()!=null){note.removeClient();}
            note.setClient(this);
            getNotes().add(note);
        }
    }
    public void removeNote(Note note){
        if(this.getNotes().contains(note)){
            this.getNotes().remove(note);
            note.setClient(null);
        }
    }



    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }
   


    @Override
    public String toString() {
        return "ClientRep{" +
                "client_id=" + client_id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", androidVersion='" + androidVersion + '\'' +
                ", notes=" + notes.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return client_id == client.client_id &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(androidVersion, client.androidVersion) &&
                Objects.equals(notes, client.notes);
    }




    public void addOwnerChallenges(Challenge challenge){
        if(!this.getOwnedChallenges().contains(challenge)) {
            if (challenge.getOwner()!=null){ challenge.removeOwner(); }
            challenge.setOwner(this);
            this.getOwnedChallenges().add(challenge);
        }

    }
    public void removeOwnerChallenge(Challenge challenge){
        if(this.getOwnedChallenges().contains(challenge)) {
            this.getOwnedChallenges().remove(challenge);
            challenge.setOwner(null);
        }
    }////////////////////////////

    @JsonManagedReference
    public Set<Challenge> getOwnedChallenges() {
        return ownedChallenges;
    }

    public void setOwnedChallenges(Set<Challenge> ownedChallenges) {
        this.ownedChallenges = ownedChallenges;
    }
}
