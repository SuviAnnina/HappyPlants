package omaprojekti.happyplants;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import omaprojekti.happyplants.Domain.User;
import omaprojekti.happyplants.Domain.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /* Testataan että uusi käyttäjä saadaan lisättyä */
    @Test
    public void createNewUser() {
        User user = new User("userTest1", "passwordtest", "USER", "user@test.fi");
        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    /* Testataan että käyttäjä saadaan poistettua */
    @Test
    public void deleteUserTest() {
        User user = new User("userTest1", "passwordtest", "USER", "user@test.fi");
        userRepository.save(user);
        userRepository.deleteById(user.getId());
        boolean userExists = userRepository.existsById(user.getId());
        assertThat(userExists).isFalse();
    }
}