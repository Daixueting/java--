package dewu.scan;

import dewu.Duck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfiguraton {

    @Bean
    public Duck duck3(){
        return new Duck();
    }

    @Bean("duck4")
    public Duck duck444444(){
        return new Duck();
    }
}
