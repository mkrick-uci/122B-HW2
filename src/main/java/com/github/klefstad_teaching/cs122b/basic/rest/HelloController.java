package com.github.klefstad_teaching.cs122b.basic.rest;

import com.github.klefstad_teaching.cs122b.basic.config.BasicServiceConfig;
import com.github.klefstad_teaching.cs122b.basic.response.HelloResponse;
import com.github.klefstad_teaching.cs122b.basic.util.Validate;
import com.github.klefstad_teaching.cs122b.core.result.BasicResults;
import com.github.klefstad_teaching.cs122b.core.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class HelloController extends BasicController{

    @Autowired
    public HelloController(BasicServiceConfig config,
                           Validate validate) {
        super(config, validate);
    }

    @GetMapping("/hello")
    public ResponseEntity<HelloResponse> hello() {

        return ResponseEntity.status(HttpStatus.OK).body(new HelloResponse(getConfig().greetingMessage()));
    }

}
