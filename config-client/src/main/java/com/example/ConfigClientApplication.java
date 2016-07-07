package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${my.message1}")
	private String message1;
	@Value("${my.message2}")
	private String message2;
	@Value("${my.message3}")
	private String message3;

	@RequestMapping("/message")
	MyMessages getMyMessages() {
		return new MyMessages(message1, message2, message3);
	}
}

class MyMessages {
    private String message1;
    private String message2;
    private String message3;

    public MyMessages(String message1, String message2, String message3) {
        this.setMessage1(message1);
        this.setMessage2(message2);
        this.setMessage3(message3);
    }


    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }
}