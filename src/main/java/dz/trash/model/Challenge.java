package dz.trash.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.security.acl.Owner;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Challenge {
    @Id
    @GeneratedValue
    private int challenge_id;
    private Date creation_date;
    private Date starting_date;
    private Date ending_date;
    private int state;
    @ManyToOne
    @JoinColumn(name = "owner_id")

    private Client owner;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private Address address;
    @OneToMany (targetEntity =Note.class , mappedBy = "challenge",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Note> notes;
    @OneToMany (targetEntity =Photo.class , mappedBy = "challenge",cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private Set<Photo> photos;
    @OneToMany (targetEntity =Comment.class , mappedBy = "challenge",cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private Set<Comment> comments;

    public Challenge() {
    }

    public Challenge(Date creation_date, Date starting_date,
                     Date ending_date, int state,Client owner){
        this.creation_date = creation_date;
        this.starting_date = starting_date;
        this.ending_date = ending_date;
        this.state=state;
        photos=new HashSet<>();
        this.notes=new HashSet<>();
        this.comments=new HashSet<>();
        this.addOwner(owner);


    }

    public void addOwner(Client owner){
        if (!owner.getOwnedChallenges().contains(this)){
            if (getOwner()!=null){removeOwner();}
            setOwner(owner);
            owner.addOwnerChallenges(this);
        }
    }
    public void removeOwner(){
        getOwner().removeOwnerChallenge(this);
        setOwner(null);
    }

    ////////////////////////////////////////
    public void addPhoto(Photo photo){
        if(!this.getPhotos().contains(photo)) {
            if (photo.getChallenge()!=null){ photo.removeChallenge(); }
            photo.setChallenge(this);
            this.getPhotos().add(photo);
        }

    }
    public void removePhoto(Photo photo){
        if(this.getPhotos().contains(photo)) {
            this.getPhotos().remove(photo);
            photo.setChallenge(null);
        }
    }////////////////////////////
    public void addNote(Note note){
        if(!this.getNotes().contains(note)) {
            if (note.getChallenge()!=null){note.removeChallenge();}
            note.setChallenge(this);
            getNotes().add(note);
        }
    }
    public void removeNote(Note note){
        if(this.getNotes().contains(note)){
            this.getNotes().remove(note);
            note.setChallenge(null);
        }
    }
    

    ////////////////////////


    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
    //////////////////
    public void addComment(Comment comment){
        if(!this.getComments().contains(comment)) {
            if (comment.getChallenge()!=null){comment.removeChallenge();}
            comment.setChallenge(this);
            getComments().add(comment);
        }
    }
    public void removeComment(Comment comment){
        if(this.getComments().contains(comment)){
            this.getComments().remove(comment);
            comment.setChallenge(null);
        }
    }
    //////////////////


    public int getChallenge_id() {
        return challenge_id;
    }

    public int getState() {
        return state;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public Date getEnding_date() {
        return ending_date;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setEnding_date(Date ending_date) {
        this.ending_date = ending_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Address getAddress(){return this.address;}
    public void setAddress(Address address){this.address = address;}



    public Set<Photo> getPhotos(){return this.photos;}
    public void setPhotos(Set<Photo> photos){this.photos = photos;}

    public Set<Comment> getComments(){return this.comments;}
    public void setComments(Set<Comment> comments){this.comments = comments;}
    



    //---------------------------------------------------------------------------------------------------------

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
