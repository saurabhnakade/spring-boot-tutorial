package com.springboot.inception.assignments.module1.syrup.impl;

import com.springboot.inception.assignments.module1.syrup.Syrup;

public class ChocolateSyrup implements Syrup {

    @Override
    public void getSyrupType() {
        System.out.println("Chocolate Syrup");
    }
}
