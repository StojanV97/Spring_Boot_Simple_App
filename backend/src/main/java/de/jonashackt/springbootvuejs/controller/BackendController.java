package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.Painter;
import de.jonashackt.springbootvuejs.domain.User;
import de.jonashackt.springbootvuejs.exception.UserNotFoundException;
import de.jonashackt.springbootvuejs.repository.ArtRepository;
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

@RestController()
@RequestMapping("/api")
public class BackendController {

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private PainterRepository painterRepository;

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(path = "/hello")
    public String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
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
        painterRepository.save(new Painter(id,firstName,lastName,dateOfBirth,dateOfDeath,nationality,artPeriod,"iconPath"));
        return "ADDED";
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
    @GetMapping(path="/painter/{id}")
    public ResponseEntity<Painter> getPainter(@PathVariable long id)
    {
        Optional<Painter> p = painterRepository.findById(id);
        Painter Painter= new Painter();
        if(p.isPresent())
        {
            Painter = p.get();
        }

        return new ResponseEntity<Painter>(Painter, HttpStatus.OK);
    }


}
