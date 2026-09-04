package com.springboot.inception.assignments.module1.frosting.impl;

import com.springboot.inception.assignments.module1.frosting.Frosting;

public class StrawberryFrosting implements Frosting {

    @Override
    public void getFrostingType() {
        System.out.println("Strawberry Frosting");
    }
}
