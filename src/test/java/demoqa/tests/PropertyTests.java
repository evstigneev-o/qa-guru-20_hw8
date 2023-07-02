package demoqa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PropertyTests{
    @Test
    @Tag("check")
    void checkProperties(){
        System.out.println(System.getProperty("selenoid"));
        System.out.println(System.getProperty("baseUrl"));
        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("browserSize"));
    }
}
