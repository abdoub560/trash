package dz.trash.Controllers;

import dz.trash.DAO.*;
import dz.trash.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("challenge")
public class ChallengeController {
    @Autowired
    PhotoRep photoRep;

    @Autowired
    ChallengeRep challengeRep;
    @Autowired
    ClientRep clientRep;

    @Autowired
    NoteRep noteRep;

    @Autowired
    ChallengeDao challengeDao;
    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "start";
        Client owner=new Client("sennai","abderezak","Atelier","1234", ConfigDate.configure(null,null,null)
                ,"07949499","6.1");
        Client client1=new Client("sennai","abderezak","Atelier","1234", ConfigDate.configure(null,null,null)
                ,"07949499","6.1");
        Client client2=new Client("sennai","abderezak","Atelier","1234", ConfigDate.configure(null,null,null)
                ,"07949499","6.1");
        Challenge challenge=new Challenge(ConfigDate.configure(null,null,null),
                ConfigDate.configure(null,null,null),ConfigDate.configure(null,null,
                null),5,owner);

        Photo photo = new Photo();
        String extention=imageFile.getOriginalFilename().split("\\.")[1];
        photo.setPhoto_path(Long.toString(System.currentTimeMillis())+"."+extention);
        returnValue=photo.getPhoto_path();
        photo.addChallenge(challenge);
        photo.setCreateDate(Date.valueOf(LocalDate.of(2015,10,5)));
        Address address=new Address(5f,6f,"litor mellouk","bouira","algeria");
        challenge.setAddress(address);
        Note note=new Note(10,null,null);
        Note note2=new Note(10,null,null);
        note.addChallenge(challenge);
        note.addClient(client1);
        note2.addChallenge(challenge);
        note2.addClient(client2);

        try {
            savePhotoImage(photo,imageFile);
            clientRep.save(client1);
            clientRep.save(client2);
            clientRep.save(owner);




        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            returnValue = "error";
        }

        return returnValue;
    }

    public void savePhotoImage(Photo photoDTO, MultipartFile imageFile) throws Exception {
        // this gets us to src/main/resources without knowing the full path (hardcoding)
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(absolutePath + "/src/main/resources/static/photos/challenges" + photoDTO.getPhoto_path());
        Files.write(path, bytes);
    }

    @GetMapping(value = "/challenges",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Challenge> getAllChallenges(){
        List<Challenge> challenges= challengeDao.findAll();


        return challenges;
    }
}
