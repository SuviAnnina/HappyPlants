package omaprojekti.happyplants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import omaprojekti.happyplants.Domain.Cutting;
import omaprojekti.happyplants.Domain.CuttingRepository;
import omaprojekti.happyplants.Domain.Plant;
import omaprojekti.happyplants.Domain.PlantRepository;
import omaprojekti.happyplants.Domain.Species;
import omaprojekti.happyplants.Domain.SpeciesRepository;

@SpringBootApplication
public class HappyplantsApplication {

	private static final Logger log = LoggerFactory.getLogger(HappyplantsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HappyplantsApplication.class, args);
	}

	@Bean
	public CommandLineRunner happyPlantsDemo(CuttingRepository cuttingRepository, PlantRepository plantRepository,
			SpeciesRepository speciesRepository) {
		return (args) -> {
			log.info("Save some species");
			Species species1 = new Species("Monstera deliciosa", "Hardy and easy to care, large leaves");
			speciesRepository.save(species1);

			Species species2 = new Species("Coleus scutellarioides",
					"Popular ornamental plant, stunning and colorful foliage");
			speciesRepository.save(species2);

			log.info("Save some plants");
			Plant plant1 = new Plant("Yellow kakariki", "Kaunis vihreäkeltainen värinokkonen", species2);
			plantRepository.save(plant1);

			Plant plant2 = new Plant("Monstera Variegata", "vihreävalkoinen muunnos", species1);
			plantRepository.save(plant2);

			log.info("Fetch all plants");
			for (Plant plant : plantRepository.findAll()) {
				log.info(plant.toString());
			}

			log.info("Save some cuttings");
			Cutting cutting1 = new Cutting("Värinokkonen", "30cm pitkä pistokas", "26.10.2023", plant1);
			cuttingRepository.save(cutting1);

			Cutting cutting2 = new Cutting("Peikonlehti", "40cm pitkä pistokas", "20.10.2023", plant2);
			cuttingRepository.save(cutting2);

			log.info("Fetch all cuttings");
			for (Cutting cutting : cuttingRepository.findAll()) {
				log.info(cutting.toString());
			}

			/*
			 * log.info("Save some users");
			 * 
			 * // Hertta / queen0Fhearts
			 * User user1 = new User("Hertta",
			 * "$2a$10$uZyuzJuxKK394drd2JxS1ubkfBvAQdlGhEEoVUTzcgkJxEYXWUbSC", "USER",
			 * "hertta@hertta.com");
			 * 
			 * // Tessa / mlemTILLn0END
			 * User user2 = new User("Tessa",
			 * "$2a$10$5mKSQ1Zq8PxA2S9l9PcjaOzWcojaM47XLmZtzVBEZOPFLfHACE9.e", "USER",
			 * "tessa@tessa.fi");
			 * 
			 * // Admin / adminsGONNA_adm1N
			 * User user3 = new User("Admin",
			 * "$2a$10$4CqqaxPe5SRF6K//Qq4zP.vsa3DS4T/VYX9rzWPq0yg2y7qsjbEOu", "ADMIN",
			 * "admin@admin.net");
			 * 
			 * userRepository.save(user1);
			 * userRepository.save(user2);
			 * userRepository.save(user3);
			 * 
			 * log.info("we have users!");
			 */

		};
	}

}
