package com.baeldung.reactive.sse.service;

import com.baeldung.reactive.sse.domain.Foo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.Date;

@Service
public class FooService {

    public Flux<Foo> getFoos() {
        Flux<Foo> eventFlux = Flux.generate(e -> {
            Foo foo = new Foo(UUID.randomUUID().toString(), LocalDateTime.now().toString());
            e.next(foo);
        });
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        return Flux.zip(interval, eventFlux).map(Tuple2::getT2);
    }
}