package io.michaelcarroll;

/**
 * Created by michaelcarroll on 5/25/16.
 */
public class Human implements Speakable {

    private String name;
    public String address;

    public void sayHello() {
        System.out.println("I am a human");
    }

}
