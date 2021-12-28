package com.danza.java.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LocalVariableTest {

    @Test
    void useVar() {

        var myValue = "123";

        var myList = new ArrayList<String>();
        myList.add(myValue);

        Assertions.assertEquals(1, myList.size());
    }

}
