package com.springboot.inception.assignments.module1.config;

import com.springboot.inception.assignments.module1.frosting.Frosting;
import com.springboot.inception.assignments.module1.frosting.impl.ChocolateFrosting;
import com.springboot.inception.assignments.module1.frosting.impl.StrawberryFrosting;
import com.springboot.inception.assignments.module1.syrup.Syrup;
import com.springboot.inception.assignments.module1.syrup.impl.ChocolateSyrup;
import com.springboot.inception.assignments.module1.syrup.impl.StrawberrySyrup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    @ConditionalOnProperty(name = "frosting", havingValue = "strawberry")
    public Frosting strawberryFrosting() {
        return new StrawberryFrosting();
    }

    @Bean
    @ConditionalOnProperty(name = "frosting", havingValue = "chocolate")
    public Frosting chocolateFrosting() {
        return new ChocolateFrosting();
    }

    @Bean
    @ConditionalOnProperty(name = "syrup", havingValue = "strawberry")
    public Syrup strawberrySyrup() {
        return new StrawberrySyrup();
    }

    @Bean
    @ConditionalOnProperty(name = "syrup", havingValue = "chocolate")
    public Syrup chocolateSyrup() {
        return new ChocolateSyrup();
    }
}
