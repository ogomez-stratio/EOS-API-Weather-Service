package com.stratio.apiweatherservice.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public final class ResponseUtil {
    private ResponseUtil() {
    }

    public static ResponseEntity wrapOrNotFound(Optional<Object> maybeResponse) {
        return wrapOrNotFound(maybeResponse, (HttpHeaders)null);
    }

    public static ResponseEntity wrapOrNotFound(Optional<Object> maybeResponse, HttpHeaders header) {
        return maybeResponse.map((response) -> {
            return (ResponseEntity.ok().headers(header)).body(response);
        }).orElse((ResponseEntity.notFound().build()));
    }
}