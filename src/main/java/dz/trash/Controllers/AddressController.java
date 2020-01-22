package dz.trash.Controllers;

import dz.trash.DAO.AddressRep;
import dz.trash.DAO.ChallengeRep;
import dz.trash.DAO.PhotoRep;
import dz.trash.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    AddressRep addressRep;



    @PostMapping(path = "/create", consumes = "application/json",produces = "application/json")
    public Address createAddress(@Valid @RequestBody Address address){
        return addressRep.save(address);
    }




}
