package dz.trash.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Note {
    @Id
    @GeneratedValue
    private int note_id;
    private int note_value;
    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn (name = "challenge_id")
    @JsonIgnore
    private Challenge challenge;
    
    public Note(int note_id,int note_value,Client client,Challenge challenge){
        this.note_id=note_id;
        this.note_value = note_value;
        this.client = client;
        this.challenge=challenge;
    }
    public Note(int note_value,Client client,Challenge challenge){
        this.note_value = note_value;
        this.client = client;
        this.challenge=challenge;
    }

    public Note() {
    }

    public Client getClient(){return this.client;}
    public void setClient(Client client){this.client = client;}

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getNote_value() {
        return note_value;
    }

    public void setNote_value(int note_value) {
        this.note_value = note_value;
    }

    @Override
    public String toString() {
        return "NoteRep{" +
                "note_id=" + note_id +
                ", note_value=" + note_value +
                ", client=" + client +
                ", challenge=" + challenge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return note_id == note.note_id &&
                note_value == note.note_value &&
                Objects.equals(client, note.client) &&
                Objects.equals(challenge, note.challenge);
    }



    public void addChallenge(Challenge challenge){
        if (!challenge.getNotes().contains(this)){
            if (getChallenge()!=null){removeChallenge();}
            setChallenge(challenge);
            challenge.addNote(this);
        }
    }
    public void removeChallenge(){
        getChallenge().removeNote(this);setChallenge(null);
    }
    public void addClient(Client client){
        if (!client.getNotes().contains(this)){
            if (getClient()!=null){removeClient();}
            setClient(client);
            client.addNote(this);
        }
    }
    public void removeClient(){
        getClient().removeNote(this);setClient(null);
    }

}
