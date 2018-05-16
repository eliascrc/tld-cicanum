package cr.ac.ucr.cicanum.tld.core;

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

    public void setMessage(String message) {
        this.message = message;
    }

}