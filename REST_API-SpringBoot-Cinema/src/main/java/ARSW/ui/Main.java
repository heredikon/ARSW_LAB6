package ARSW.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ARSW.entities.Cinema;
import ARSW.entities.CinemaFunction;
import ARSW.entities.Movie;
import ARSW.Persistence.CinemaException;
import ARSW.Persistence.CinemaPersistenceException;
import ARSW.services.CinemaServices;

public class Main {

	public static void main(String[] args) throws CinemaException, CinemaPersistenceException {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		CinemaServices sc = ac.getBean(CinemaServices.class);
		String functionDate = "2018-12-18 15:30";
		List<CinemaFunction> functions = new ArrayList<>();
		CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie", "Horror"), functionDate);
		CinemaFunction funct2 = new CinemaFunction(new Movie("The Night", "Horror"), functionDate);
		functions.add(funct1);
		functions.add(funct2);
		Cinema c = new Cinema("cinemaX", functions);
		try {
			System.out.println(sc.getCinemaByName("cinemaX").getName());
		} catch (CinemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.buyTicket(2, 3, "cinemaX", functionDate, "The Night");
		System.out.println("Se a comprado un tiquete");
		for(CinemaFunction cf: sc.getFunctionsbyCinemaAndDate("cinemaX", "2018-12-18 15:30")) {
			System.out.println(cf.getMovie().getName());
		}
	}

}
