// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.controller;

import goldswan.calculator.dto.CalculationRequest;
import goldswan.calculator.dto.CalculationResponse;
import goldswan.calculator.service.CalculationService;
import goldswan.calculator.vulnerabilities.CommandInjection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculate")
@Slf4j
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(@RequestBody CalculationRequest request) {
        String val = request.getParam();
        try {
            int value = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            log.info("Failed to parse val = " + val);
        }
        double result = calculationService.add(request.getNumber1(), request.getNumber2());
        return ResponseEntity.ok(new CalculationResponse(result));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtract(@RequestBody CalculationRequest request) {
        CommandInjection.coordinateTransformLatLonToUTM("12.34 -56.78 & echo boo");

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


