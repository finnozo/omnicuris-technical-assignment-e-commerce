package com.omnicuris.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.net.URI;


@AllArgsConstructor
@ToString
@Getter
public class ResponseMessage {
    private final String message;
    private final String cause;
    private final URI uri;
}
