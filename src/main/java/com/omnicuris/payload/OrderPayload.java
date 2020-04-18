package com.omnicuris.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class OrderPayload {
    private Long id = 0L;
    @NotNull(message = "Item Id is required!")
    private Long itemId;
    @NotNull(message = "Number of items is required!")
    private Long numberOfItems;
    @NotBlank(message = "Email id is required!")
    @Email(message = "Provide valid email id!")
    private String emailId;

    private boolean active = true;
}
