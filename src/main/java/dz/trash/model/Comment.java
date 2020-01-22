package dz.trash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table (name = "Commentaire")
public class Comment {
    @Id
    @GeneratedValue
    private int comment_id;
    private String comment_content;
    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    @JsonIgnore
    private Challenge challenge;
    Timestamp creationDate;
    boolean isEnabled;


    public  Comment (){

    }
    public Comment(String comment_content,Timestamp creationDate,boolean isEnabled){
        this.creationDate=creationDate;
        this.isEnabled=isEnabled;
        this.comment_content = comment_content;
    }
    public void addChallenge(Challenge challenge){
        if (!challenge.getComments().contains(this)){
            if (getChallenge()!=null){removeChallenge();}
            setChallenge(challenge);
            challenge.addComment(this);
        }
    }

    public void removeChallenge(){
        getChallenge().removeComment(this);setChallenge(null);
    }
    public void addClient(Client client){
        if (!client.getComments().contains(this)){
            if (getClient()!=null){removeClient();}
            setClient(client);
            client.addComment(this);
        }
    }
    public void removeClient(){
        getClient().removeComment(this);setClient(null);
    }
    
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    


    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Challenge getChallenge() {
        return challenge;
    }


    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String toString(){
        return this.comment_id+"";
    }
}
