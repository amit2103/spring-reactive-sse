package com.baeldung.reactive.sse.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Foo {
    private String id;
    private String date;
}
