package mario.reactiveapiwebfluxtraining;


import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class PersonInit {
    private PersonRepository personRepository;

    public PersonInit(PersonRepository personRepository) {
        this.personRepository = personRepository;


        Flux<Person> personFlux = Flux.just(
                new Person("Maksymilian", "Miły"),
                new Person("Antoni", "Mądry")

        );

        personRepository.insert(personFlux).subscribe();
    }
}
