package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.*;
import de.jonashackt.springbootvuejs.domain.Painter;
import de.jonashackt.springbootvuejs.exception.UserNotFoundException;
import de.jonashackt.springbootvuejs.repository.ArtRepository;
import de.jonashackt.springbootvuejs.repository.PainterArtReposiroty;
import de.jonashackt.springbootvuejs.repository.PainterRepository;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import org.hibernate.annotations.GeneratorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Random;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @Autowired
    private ArtRepository artRepository;
    @Autowired
    private PainterRepository painterRepository;
    @Autowired
    PainterArtReposiroty painterArtReposiroty;

    @RequestMapping(path = "/hello")
    public String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }
    @GetMapping(value = "/get-all-paintnings",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPaintings(){
        Collection<Art> artCollection = (Collection<Art>) artRepository.findAll();
        ArrayList<Art> a = new ArrayList<Art>(artCollection);
        return new ResponseEntity<Collection<Art>>(a,HttpStatus.OK);

    }
    @GetMapping(value = "/get-painter/{painterId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPainter(@PathVariable long painterId){
        Optional<Painter> p = painterRepository.findById(painterId);
        if(p.isPresent()){
            Painter painter = p.get();
            return new ResponseEntity<Painter>(painter,HttpStatus.OK);
        }
        return new ResponseEntity<String>("Not found!",HttpStatus.OK);
    }
    @GetMapping(value = "/get-all-painters",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPainter(){
        Collection<Painter> p = (Collection<Painter>) painterRepository.findAll();
        return new ResponseEntity< Collection<Painter>>(p,HttpStatus.OK);
    }

    @PostMapping (path = "/painter/add/{firstName}/{lastName}/{dateOfBirth}/{dateOfDeath}/{nationality}/{artPeriod}/{iconPath}")
    public String addPainter(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String dateOfBirth, @PathVariable String dateOfDeath, @PathVariable String nationality, @PathVariable String artPeriod, @PathVariable String iconPath )
    {
        Random r = new Random();
        Collection<Painter> pa = (Collection<Painter>) painterRepository.findAll();
        boolean flag = false;
        long id = 999999l;
        while(!flag){
            boolean flag2 = false;
            id = r.nextInt(1000);
            for(Painter painter : pa){
                if(painter.getId() == id){
                    flag2 = true;
                    break;
                }
            }
            if(!flag2){
                flag = true;
            }
        }
        painterRepository.save(new Painter(id,firstName,lastName,dateOfBirth,dateOfDeath,nationality,artPeriod,iconPath));
        return "ADDED";
    }

    @PostMapping (path = "/painter/edit/{id}/{firstName}/{lastName}/{dateOfBirth}/{dateOfDeath}/{nationality}/{artPeriod}/{iconPath}")
    public String editPainter(@PathVariable long id ,@PathVariable String firstName, @PathVariable String lastName, @PathVariable String dateOfBirth, @PathVariable String dateOfDeath, @PathVariable String nationality, @PathVariable String artPeriod, @PathVariable String iconPath )
    {
        Optional<Painter> p = painterRepository.findById(id);
        Painter painter = new Painter();
        if(p.isPresent())
        {
            painter = p.get();

        }

        painter.setArtPeriod(artPeriod);
        painter.setFirstName(firstName);
        painter.setDateOfBirth(dateOfBirth);
        painter.setDateOfDeath(dateOfDeath);
        painter.setLastName(lastName);
        painter.setNationality(nationality);


        painterRepository.save(painter);
        return "UPDATED";
    }
    @PostMapping (path="/painter/delete/{id}")
    public String deletePainter(@PathVariable long id){

        Optional<Painter> painter = painterRepository.findById(id);
        Painter p= new Painter();
        if(painter.isPresent())
        {
             p = painter.get();
        }
        painterRepository.delete(p);

        return "DELETED";
    }

    @PostMapping (path="/art/delete/{id}")
    public String deleteArt(@PathVariable long id){

        painterArtReposiroty.deleteById(id);
        artRepository.deleteById(id);
   //     Optional<Art> art = artRepository.findById(id);
   //     Art a= new Art();
   //     if(art.isPresent())
   //     {
   //         a = art.get();
   //     }
   //     artRepository.delete(a);

        return "DELETED";
    }

    @PostMapping (path = "/art/add")
    public String add(@RequestBody Art art)
    {
        System.out.println("SASDASDASDASDAS");
        Random r = new Random();
        Collection<Art> pa = (Collection<Art>) artRepository.findAll();
        boolean flag = false;
        long id = 999999l;
        while(!flag){
            boolean flag2 = false;
            id = r.nextInt(1000);
            for(Art painter : pa){
                if(painter.getId() == id){
                    flag2 = true;
                    break;
                }
            }
            if(!flag2){
                flag = true;
            }
        }
        art.setId(id);
        System.out.println(art);
        artRepository.save(art);

        return "ADDED";
    }

    @PostMapping (path = "/art/add/{name}/{painterID}/{creationDate}/{currentLocation}/{technique}/{description}/{artPeriod}/{iconPath}")
    public String addPainting(@PathVariable String name, @PathVariable long painterID,@PathVariable String creationDate, @PathVariable String currentLocation, @PathVariable String technique, @PathVariable String description, @PathVariable String artPeriod, @PathVariable String iconPath )
    {

        System.out.println("SASDASDASDASDAS");
        Random r = new Random();
        Collection<Art> pa = (Collection<Art>) artRepository.findAll();
        boolean flag = false;
        long id = 999999l;
        while(!flag){
            boolean flag2 = false;
            id = r.nextInt(1000);
            for(Art painter : pa){
                if(painter.getId() == id){
                    flag2 = true;
                    break;
                }
            }
            if(!flag2){
                flag = true;
            }
        }
        Art art =new Art(id,name,painterID,creationDate,currentLocation,technique,description,artPeriod,iconPath);
        System.out.println(art);
        artRepository.save(art);
        PAINTER_ART paas = new PAINTER_ART(painterID,id);
        painterArtReposiroty.save(paas);

        return "ADDED";
    }



    @PostMapping (path = "/painting/update/{name}/{painterID}/{creationDate}/{currentLocation}/{technique}/{description}/{artPeriod}/{iconPath}/{artID}")
    public String updatePainting(@PathVariable String name, @PathVariable long painterID,@PathVariable String creationDate, @PathVariable String currentLocation, @PathVariable String technique, @PathVariable String description, @PathVariable String artPeriod, @PathVariable String iconPath, @PathVariable long artID )
    {
        Art art = new Art();
        Optional<Art> a = artRepository.findById(artID);
        if(a.isPresent())
        {
            art = a.get();
        }
        art.setArtPeriod(artPeriod);
        art.setCreationDate(creationDate);
        art.setCurrentLocation(currentLocation);
        art.setIconPath(iconPath);
        art.setDescription(description);
        art.setName(name);
        art.setPainterId(painterID);
        art.setTechnique(technique);
        artRepository.save(art);
        return "UPDATED";
    }


    @GetMapping(value = "/get-paintning/{id}")
    public ResponseEntity<?> getPainting(@PathVariable long id){
        Optional<Art> a =  artRepository.findById(id);
        Art art = new Art();
        if(a.isPresent()){
            art = a.get();
        }

        return new ResponseEntity<Art>(art,HttpStatus.OK );

    }

}
