package mario.reactiveapiwebfluxtraining;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class PersonApi {

    private PersonRepository personRepository;

    public PersonApi(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Person> get() {
        return personRepository.findAll().delayElements(Duration.ofSeconds(2));
    }

    @PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Person> post(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping(value = "/id/{personId}")
    public Mono<Person> getPersonById(@PathVariable String personId) {
        return personRepository.findById(personId);
    }

    @GetMapping(value = "/lastName/{lastName}")
    public Mono<Person> getPersonByLasName(@PathVariable String lastName) {
        return personRepository.findByLastName(lastName);
    }
//    Flux<Person> personFlux = Flux.just(
//            new Person("Anna", "Nowak"),
//            new Person("Jan", "Testowy"),
//            new Person("Piotr", "Nieznany"),
//            new Person("Paweł", "Znany")
//    );

//    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
//    public Flux<Person> get() {
//        return personFlux.delayElements(Duration.ofSeconds(2));
//    }

//    @PostMapping
//    public Flux<Person> post(@RequestBody Person person) {
//        personFlux = this.personFlux.mergeWith(Mono.just(person));
//        personFlux.subscribe(element -> logger.info(element.toString()));
//        return personFlux;
//
//    }

}
