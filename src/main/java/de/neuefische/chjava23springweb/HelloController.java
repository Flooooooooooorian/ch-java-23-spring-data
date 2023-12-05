package de.neuefische.chjava23springweb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello, world!";
    }

    @GetMapping("/greeting")
    public String greetSomeOne(@RequestParam(required = false) String name){
        return "Hello " + name;
    }

    @GetMapping("/greeting/{name}")
    public String greetName(@PathVariable String name){
        return "Hello " + name;
    }

    @PostMapping("/add-something")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> addSomeThing(@RequestBody String name){
        List<String> names = new ArrayList<>();
        names.add(name);
        return names;
    }

}
