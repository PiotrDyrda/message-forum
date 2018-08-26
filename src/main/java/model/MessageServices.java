package model;

import java.util.Collections;
import java.util.List;

public class MessageServices {

    private MessageRepository repository = new MessageRepository();

    public List<Message> getMessage(){
        return repository.getAll();
    }

    public Message addMessage (String content){
        Message message = new Message(content);
        return repository.save(message);
    }
}
