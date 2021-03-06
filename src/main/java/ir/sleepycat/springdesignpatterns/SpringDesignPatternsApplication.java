package ir.sleepycat.springdesignpatterns;

import ir.sleepycat.springdesignpatterns.designpatterns.prototype.ProtoFalse;
import ir.sleepycat.springdesignpatterns.designpatterns.prototype.ProtoTrue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringDesignPatternsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDesignPatternsApplication.class, args);
    }

    @Bean
    public ProtoFalse protoFalse() {
        return new ProtoFalse();
    }

    @Bean
    @Scope("prototype")
    public ProtoTrue protoTrue() {
        return new ProtoTrue();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
