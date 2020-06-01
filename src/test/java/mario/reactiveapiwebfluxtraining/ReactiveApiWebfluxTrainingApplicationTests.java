package mario.reactiveapiwebfluxtraining;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveApiWebfluxTrainingApplicationTests {

    @Test
    void should_context_loads() {

        Flux.just("Pankracy", "Gerwazy", "Piotr", "Ania")
                .map(String::toLowerCase)
                .subscribe(element -> logger.info(element));

        Mono.just("Leon")
                .map(String::toUpperCase)
                .subscribe(element -> logger.info(element));
    }
    @Test
    void should_context_load_if_its_empty() {

        Flux.just("Pankracy", "Gerwazy", "Piotr", "Ania")
                .map(String::isEmpty)
                .subscribe(element -> logger.info(element.toString()));

        Mono.just("")
                .map(String::isEmpty)
                .subscribe(element -> logger.info(element.toString()));
    }


}
