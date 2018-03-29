package com.baeldung.reactive.sse.controller;

import com.baeldung.reactive.sse.domain.Foo;
import com.baeldung.reactive.sse.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/foo/")
class FooController {
    @Autowired
    private FooService service;

    /**
     * This method is responsible for sending a stream of server sent events to all connected clients.
     * @return a stream of Foo
     */
    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Foo> stockTransactionEvents(){
        return service.getFoos();
    }
}