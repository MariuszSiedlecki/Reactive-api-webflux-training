package mario.reactiveapiwebfluxtraining.optionRouting;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class PersonRouting {

    @Bean
    public RouterFunction<ServerResponse> responseRouterFunction(PersonHandler personHeandler){
        return RouterFunctions.route(RequestPredicates.GET("/get-persons"),personHeandler::serverResponseMono);
    }

}
