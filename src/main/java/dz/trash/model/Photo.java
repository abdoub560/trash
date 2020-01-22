package dz.trash.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
@Entity
public class Photo {
    @Id
    @GeneratedValue
    private int photo_id;
    private String photo_path;
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    @JsonIgnore
    private Challenge challenge;

    public Photo() {
    }

    public Photo(int photo_id, String photo_path, Date createDate, Challenge challenge){
        this.photo_id=photo_id;
        this.photo_path = photo_path;
        this.createDate=createDate;
        this.challenge = challenge;

    }
    public Photo(String photo_path,Date createDate,Challenge challenge){
        this.photo_id=photo_id;
        this.photo_path = photo_path;
        this.createDate=createDate;
        addChallenge(challenge);

    }


    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public Challenge getChallenge() {
        return challenge;
    }
    public void setChallenge(Challenge challenge){
        this.challenge = challenge;
    }


    public void addChallenge(Challenge challenge){
        if (!challenge.getPhotos().contains(this)){
            if (getChallenge()!=null){removeChallenge();}
            setChallenge(challenge);
            challenge.addPhoto(this);
        }
    }
    public void removeChallenge(){
        getChallenge().removePhoto(this);
        setChallenge(null);
    }


    @Override
    public String toString() {
        return "Photo{" +
                "photo_id=" + photo_id +
                ", photo_path='" + photo_path + '\'' +
                ", createDate=" + createDate +
                ", challenge=" + challenge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return photo_id == photo.photo_id &&
                Objects.equals(photo_path, photo.photo_path) &&
                Objects.equals(createDate, photo.createDate) &&
                Objects.equals(challenge, photo.challenge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photo_id, photo_path, createDate, challenge);
    }
}
