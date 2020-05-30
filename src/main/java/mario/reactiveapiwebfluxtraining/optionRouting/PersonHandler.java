package mario.reactiveapiwebfluxtraining.optionRouting;

import mario.reactiveapiwebfluxtraining.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {

    public Mono<ServerResponse> serverResponseMono(ServerRequest serverRequest) {
        Flux<Person> personFlux = Flux.just(
                new Person("Anna", "Nowak"),
                new Person("Jan", "Testowy"),
                new Person("Piotr", "Nieznany"),
                new Person("Paweł", "Znany")
        );
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personFlux, Person.class);

    }


}
