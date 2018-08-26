package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MessageRepository {

    private static List<Message> messages = new ArrayList<>();

//    public MessageRepository(){
//        messages.add(new Message("sms 1"));
//        messages.add(new Message("sms 2"));
//        messages.add(new Message("sms 3"));
//    }

    public List<Message> getAll(){
        return Collections.unmodifiableList(messages);
    }

    public Message save(Message message){
        messages.add(message);
        return message;
    }
}
