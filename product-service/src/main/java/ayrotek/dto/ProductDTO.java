package ayrotek.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private String productName;
    private BigDecimal price;
    private String barcode;
    private BigDecimal taxRate;
}
