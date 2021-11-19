package com.MarvelAPI.Marvel;

import com.MarvelAPI.Marvel.Controllers.Service;
import com.MarvelAPI.Marvel.Logic.Exceptions.NotFoundException;
import com.MarvelAPI.Marvel.Logic.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@SpringBootTest
class MarvelApplicationTests {

	Service service = new Service();

	@Test
	void contextLoads() {
	}

	@Test
	void heroSearch() {
		try {
			Hero hero = service.getID("1009368"); // Iron Man
			Hero heroExpected = expectedHero();
			assertTrue(hero.Compare(heroExpected));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void InvalidID() {
		try {
			Hero hero = service.getID("HGYgff");
		} catch (Exception e) {e.printStackTrace();
			assertTrue(e instanceof NotFoundException);
		}
	}


	public Hero expectedHero(){
		Hero heroExpected = new Hero();
		heroExpected.setId("1009368");
		heroExpected.setName("Iron Man");
		heroExpected.setDescription("Wounded, captured and forced to build a weapon by his enemies, billionaire industrialist Tony Stark instead created an advanced suit of armor to save his life and escape captivity. Now with a new outlook on life, Tony uses his money and intelligence to make the world a safer, better place as Iron Man.");
		ArrayList<String> comics = new ArrayList<>();
		comics.add("A+X (2012) #2");
		comics.add("A+X (2012) #7");
		comics.add("Adam: Legend of the Blue Marvel (2008) #1");
		comics.add("Adam: Legend of the Blue Marvel (2008) #2");
		comics.add("Adam: Legend of the Blue Marvel (2008) #5");
		comics.add("Aero (2019) #11");
		comics.add("Aero (2019) #12");
		comics.add("Age of Heroes (2010) #1");
		comics.add("Age of Heroes (2010) #2");
		comics.add("Age of Heroes (2010) #3");
		comics.add("Age of Heroes (2010) #4");
		comics.add("Age of Innocence: The Rebirth of Iron Man (1996) #1");
		comics.add("Age of X: Universe (2011) #1");
		comics.add("Age of X: Universe (2011) #2");
		comics.add("All-New Iron Manual (2008) #1");
		comics.add("All-New, All-Different Avengers (2015) #10");
		comics.add("All-New, All-Different Avengers (2015) #11");
		comics.add("Alpha Flight (1983) #113");
		comics.add("Alpha Flight (1983) #127");
		comics.add("The Amazing Spider-Man (2015) #13");
		heroExpected.setComics(comics);
		return heroExpected;
	}

}
