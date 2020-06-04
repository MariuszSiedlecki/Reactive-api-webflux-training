package mario.reactiveapiwebfluxtraining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonClient {
    Logger logger = LoggerFactory.getLogger(PersonClient.class);

    @EventListener(ApplicationReadyEvent.class)
    public void getDataFromApi() {
        Flux<Person> personFlux = WebClient.create()
                .get()
                .uri("http://localhost:8080")
                .retrieve()
                .bodyToFlux(Person.class);
        personFlux.subscribe(element -> logger.info(element.toString()));
    }

    //    @EventListener(ApplicationReadyEvent.class)
    public void createPerson() {
        Flux<Person> personFlux = WebClient.create()
                .post()
                .uri("http://localhost:8080")
                .body(Mono.just(new Person("Alicja", "Czarująca")), Person.class)
                .retrieve()
                .bodyToFlux(Person.class);
        personFlux.subscribe(element -> logger.info(element.toString()));
    }
}
