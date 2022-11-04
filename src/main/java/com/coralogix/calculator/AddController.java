package com.coralogix.calculator;

import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.AddService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("add")
public class AddController {

    @Autowired
    private AddService addService;

    @GetMapping
    public Result add(@RequestParam int a, @RequestParam int b) {
        return addService.add(a, b);
    }

    @GetMapping("/results")
    public List<Result> addResult() {
        return addService.listResults();
    }

    @GetMapping("/factorial/{value}")
    public ResponseEntity<Result> factorial(@PathVariable int value) {
        try {
            return ResponseEntity.ok(addService.factorial(value));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
