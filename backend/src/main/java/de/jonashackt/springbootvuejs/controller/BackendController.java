package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.Art;
import de.jonashackt.springbootvuejs.domain.Painter;
import de.jonashackt.springbootvuejs.domain.User;
import de.jonashackt.springbootvuejs.exception.UserNotFoundException;
import de.jonashackt.springbootvuejs.repository.ArtRepository;
import de.jonashackt.springbootvuejs.repository.PainterRepository;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
