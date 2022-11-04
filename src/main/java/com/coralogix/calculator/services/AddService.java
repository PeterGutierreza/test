package com.coralogix.calculator.services;

import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.repository.AddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AddService {

    private final static Logger LOGGER = Logger.getLogger("AddService");
    @Autowired
    AddRepository addRepository;

    public Result add(int a, int b) {
        int sum = a + b;
        Result result = new Result(a+b);
        addRepository.save(result);
        return result;
    }

    public List<Result> listResults() {
        return addRepository.findAll();
    }

    public Result factorial(int a) throws Exception{
        if (a<0) {
            String msg = "No se puede calcular el factorial de un número negativo. Valor ingresado: ";
            LOGGER.log(Level.SEVERE, msg);
            throw new Exception(msg+a);
        }

        return addRepository.save(new Result(fact(a)));
    }

    private int fact(int value) {
        if (value == 0) {
            return 1;
        } else {
            return value*fact(value-1);
        }
    }
}
