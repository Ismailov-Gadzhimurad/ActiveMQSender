package com.wamm.wamm_2.mqactive;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/active")
public class ActiveMQController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @GetMapping(value = "/send/{phoneNumber}/{message}")
    public ResponseEntity<MessageRequest> sendMessage(@RequestBody MessageRequest request) {
        try {
            // Сериализация объекта MessageRequest в JSON-строку
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonMessage = objectMapper.writeValueAsString(request);

            // Отправка JSON-сообщения в очередь
            jmsTemplate.convertAndSend("new_queue", jsonMessage);

            return ResponseEntity.status(HttpStatus.OK).body(request);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }




    }
}
