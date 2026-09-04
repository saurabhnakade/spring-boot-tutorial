package com.springboot.inception.assignments.module1;

import com.springboot.inception.assignments.module1.frosting.Frosting;
import com.springboot.inception.assignments.module1.syrup.Syrup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    public void bakeCake() {
        System.out.println("Baking cake with:");
        frosting.getFrostingType();
        syrup.getSyrupType();
    }
}
