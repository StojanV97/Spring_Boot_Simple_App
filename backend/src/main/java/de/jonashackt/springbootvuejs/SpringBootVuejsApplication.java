package de.jonashackt.springbootvuejs;

import de.jonashackt.springbootvuejs.domain.Art;
import de.jonashackt.springbootvuejs.domain.PAINTER_ART;
import de.jonashackt.springbootvuejs.domain.Painter;
import de.jonashackt.springbootvuejs.repository.ArtRepository;
import de.jonashackt.springbootvuejs.repository.PainterArtReposiroty;
import de.jonashackt.springbootvuejs.repository.PainterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
public class SpringBootVuejsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVuejsApplication.class, args);

	}
	@Bean
	CommandLineRunner runner(PainterRepository painterRepository, ArtRepository artRepository, PainterArtReposiroty painterArtReposiroty){
		return args -> {
			System.out.println("CommandLineRunner running in the UnsplashApplication class...");

			Painter p = new Painter(1, "ime","prezime","2002-12-12","2003-13-12","srbin","Kubizam","asdas");
			Art a = new Art(1,"ada",1,"asda","asda","adda","asda","asdad","asda");
			Art a1 = new Art(2,"ada",1,"asda","asda","adda","asda","asdad","asda");
			Art a2 = new Art(3,"ada",1,"asda","asda","adda","asda","asdad","asda");

			painterRepository.save(p);
			artRepository.save(a);
			artRepository.save(a1);
			artRepository.save(a2);
			PAINTER_ART pa = new PAINTER_ART(1,1);
			PAINTER_ART pa1 = new PAINTER_ART(1,3);

			painterArtReposiroty.save(pa);
			painterArtReposiroty.save(pa1);



			Collection<Painter> slikari = (Collection<Painter>) painterRepository.findAll();
			for(Painter pp : slikari){
				for(Art arr : pp.getArts()){
					System.out.println(arr);
				}
			}
		};
	}
}

