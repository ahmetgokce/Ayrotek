package ayrotek.response;

import ayrotek.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TaxCalculatorResponse {
    private String message;
    private Boolean status;
    private BigDecimal tax;
    private String productName;
    private String barcode;

    public TaxCalculatorResponse(boolean status, BigDecimal tax, Product product) {
        this.status = status;
        if (status){
            this.tax = tax;
            this.message = "success";
            this.productName = product.getProductName();
            this.barcode = product.getBarcode();
        }else {
            this.message = "failed";
        }
    }
}
