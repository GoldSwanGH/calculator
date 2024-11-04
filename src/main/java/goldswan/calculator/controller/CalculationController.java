package goldswan.calculator.controller;

import goldswan.calculator.dto.CalculationRequest;
import goldswan.calculator.dto.CalculationResponse;
import goldswan.calculator.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculate")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(@RequestBody CalculationRequest request) {
        double result = calculationService.add(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtract(@RequestBody CalculationRequest request) {
        double result = calculationService.subtract(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiply(@RequestBody CalculationRequest request) {
        double result = calculationService.multiply(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculationResponse> divide(@RequestBody CalculationRequest request) {
        double result = calculationService.divide(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new CalculationResponse(result));
    }
}


