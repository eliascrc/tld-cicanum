package cr.ac.ucr.cicanum.tld.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

    private String message;

    public TestBean(){}

    public TestBean(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Value("This is a Test Bean!")
    public void setMessage(String message) {
        this.message = message;
    }

}
