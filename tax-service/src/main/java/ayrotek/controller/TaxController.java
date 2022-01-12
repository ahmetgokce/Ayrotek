package ayrotek.controller;

import ayrotek.request.TaxCalculatorRequest;
import ayrotek.response.TaxCalculatorResponse;
import ayrotek.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/tax")
@RequiredArgsConstructor
public class TaxController {
    private final TaxService taxService;
    @PostMapping("/calculateTax")
    public ResponseEntity<TaxCalculatorResponse> calculateTax(@RequestBody TaxCalculatorRequest taxCalculatorRequest){
        return ResponseEntity.ok(taxService.calculateTax(taxCalculatorRequest));
    }
}
