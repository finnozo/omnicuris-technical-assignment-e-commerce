package com.omnicuris.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class ItemPayload {
    private Long id = 0L;
    @NotBlank(message = "SKU is required!")
    private String sku;
    @NotBlank(message = "Name is required!")
    private String name;
    @NotBlank(message = "Description is required!")
    private String description;
    @NotNull(message = "Unit price is required!")
    private BigDecimal unitPrice;
    @NotBlank(message = "Image url is required!")
    private String imageUrl;
    @NotNull(message = "Unit in stock is required!")
    private Integer unitsInStock;

    private boolean active = true;
}
