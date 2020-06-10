package mario.reactiveapiwebfluxtraining;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    Mono<Person>findByLastName(String lastName);
}
