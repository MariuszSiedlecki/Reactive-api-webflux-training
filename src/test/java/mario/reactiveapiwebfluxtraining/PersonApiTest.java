package mario.reactiveapiwebfluxtraining;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient

class PersonApiTest {

    @Autowired
     WebTestClient webTestClient;

    @Test
    public void should_get_lastName(){
    webTestClient
            .get()
            .uri("http://www.localhost:8080/lastName/Miły")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.lastName").isEqualTo("Miły");
    }
    @Test
    public void should_get_List_Persons(){
        webTestClient.get()
                .uri("http://localhost:8080")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Person.class);
    }
    @Test
    public void should_not_get_List_Persons(){
        webTestClient.get()
                .uri("http://localhost:8080")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Person.class);
    }


}




