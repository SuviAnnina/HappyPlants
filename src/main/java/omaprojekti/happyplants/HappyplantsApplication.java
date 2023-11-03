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
import omaprojekti.happyplants.Domain.User;
import omaprojekti.happyplants.Domain.UserRepository;

@SpringBootApplication
public class HappyplantsApplication {

	private static final Logger log = LoggerFactory.getLogger(HappyplantsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HappyplantsApplication.class, args);
	}

	@Bean
	public CommandLineRunner happyPlantsDemo(CuttingRepository cuttingRepository, PlantRepository plantRepository,
			SpeciesRepository speciesRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("Save some species");
			Species species1 = new Species("Monstera deliciosa", "Hardy and easy to care, large leaves");
			speciesRepository.save(species1);

			Species species2 = new Species("Coleus scutellarioides",
					"Delicate and finicky, very ornamental plant, stunning and colorful foliage");
			speciesRepository.save(species2);

			Species species3 = new Species("Tradescantia",
					"Attractive and distinctive foliage, color varies, cascading growth");
			speciesRepository.save(species3);

			Species species4 = new Species("Aglaonema",
					"Hardy and easy to care, large, leathery and usually oval or lance-shaped leaves");
			speciesRepository.save(species4);

			log.info("Save some plants");
			Plant plant1 = new Plant("Yellow kakariki", "Indirect, bright", "Green-yellow ornamental leaves",
					species2);
			plantRepository.save(plant1);

			Plant plant2 = new Plant("Monstera variegata", "Indirect, low",
					"Green leaves with varying amounts of white",
					species1);
			plantRepository.save(plant2);

			Plant plant3 = new Plant("Anyamanee Tricolor", "Indirect, low", "3 colored-leaves: red, white, green",
					species4);
			plantRepository.save(plant3);

			Plant plant4 = new Plant("Army red", "Indirect, low", "Pink-green leaves", species4);
			plantRepository.save(plant4);

			Plant plant5 = new Plant("Zebrina", "Direct, bright",
					"Purple-green leaves, color is deeper if exposed to sun", species3);
			plantRepository.save(plant5);

			Plant plant6 = new Plant("Fluminensis variegata", "Direct, bright", "Green-white leaves", species3);
			plantRepository.save(plant6);

			log.info("Fetch all plants");
			for (Plant plant : plantRepository.findAll()) {
				log.info(plant.toString());
			}

			log.info("Save some cuttings");
			Cutting cutting1 = new Cutting("Värinokkonen", "30cm tall cutting", "26.10.2023", plant1,
					"Grows roots within 1 week");
			cuttingRepository.save(cutting1);

			Cutting cutting2 = new Cutting("Peikonlehti", "40cm tall cutting", "20.10.2023", plant2,
					"New roots are growing");
			cuttingRepository.save(cutting2);

			Cutting cutting3 = new Cutting("Juoru", "20cm tall, 4 leafpairs", "1.11.2023", plant5,
					"Grows roots in 5 days");
			cuttingRepository.save(cutting3);

			Cutting cutting4 = new Cutting("Juoru variegata", "30cm tall, 5 leafpairs", "29.10.2023", plant6,
					"Has roots");
			cuttingRepository.save(cutting4);

			Cutting cutting5 = new Cutting("Juoru", "30cm tall, 6 leafpairs", "2.11.2023", plant5, "Has roots");
			cuttingRepository.save(cutting5);

			log.info("Fetch all cuttings");
			for (Cutting cutting : cuttingRepository.findAll()) {
				log.info(cutting.toString());
			}

			log.info("Save some users");

			// BasicUser / plantsRhappy
			User user1 = new User("BasicUser",
					"$2a$10$TvoDqVsajsGjdu5A3fEkjuOD0R2qQ4OqfEnTcu4rr4vG0ZR77i8Jq", "USER",
					"user@happyplants.com");

			// Admin / adminsRhappy
			User user2 = new User("Admin",
					"$2a$10$sVegLIZSi8GJkUSDtrVhwOZLY.cb6Re0JyVW9CAlpucZJNRjN7xDC", "ADMIN",
					"admin@happyplants.net");

			userRepository.save(user1);
			userRepository.save(user2);

			log.info("we have users!");

		};
	}

}
