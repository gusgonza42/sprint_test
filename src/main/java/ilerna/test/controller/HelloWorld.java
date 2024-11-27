package ilerna.test.controller;

import ilerna.test.model.HelloModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public ResponseEntity<Object> getHello() {
        HelloModel hello = new HelloModel(1,"Hello World");
        return ResponseEntity.ok(hello);
    }

    @PostMapping("/hello")
    public ResponseEntity<Object> postHello(@RequestBody HelloModel hello) {
        System.out.println(hello);
        return ResponseEntity.status(201).body(hello);
    }


}