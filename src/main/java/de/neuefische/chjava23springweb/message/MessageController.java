package de.neuefische.chjava23springweb.message;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private List<Message> messages = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message addMessage(@RequestBody Message message){
        messages.add(message);
        return message;
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return messages;
    }

    @DeleteMapping("/{id}")
    public List<Message> deleteMessageById(@PathVariable String id){
        for(Message message : messages){
            if(message.id().equals(id)){
                messages.remove(message);
                return messages;
            }
        }
        throw new RuntimeException("Message with id " + id + " not found!");
    }

}
