package ayrotek.service;

import ayrotek.entity.Log;
import ayrotek.entity.Product;
import ayrotek.repository.LogRepository;
import ayrotek.repository.ProductRepository;
import ayrotek.request.TaxCalculatorRequest;
import ayrotek.response.TaxCalculatorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class TaxService {
    private final ProductRepository productRepository;
    private final LogRepository logRepository;

    public TaxCalculatorResponse calculateTax(TaxCalculatorRequest taxCalculatorRequest) {
        try {
            Product product = productRepository.findById(taxCalculatorRequest.getProductId()).get();
            BigDecimal tax = product.getPrice().multiply(product.getTaxRate()).divide(new BigDecimal(100),2, RoundingMode.HALF_UP);
            Log log = new Log(null, " Tax is " + tax + " for the product : " + product.getProductName());
            logRepository.save(log);
            return new TaxCalculatorResponse(true, tax, product);
        } catch (Exception e) {
            Log log = new Log(null, e.getMessage());
            logRepository.save(log);
            return new TaxCalculatorResponse(false, null, null);
        }
    }
}

