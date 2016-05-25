package io.michaelcarroll;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by michaelcarroll on 5/25/16.
 */
public class TypeInfoTest {

    TypeInfo typeInfo;
    Human human;

    @Before
    public void setUp() throws Exception {
        typeInfo = new TypeInfo();
        human = new Human();
    }

    @Test
    public void doesObjectImplementSpeakable() throws Exception {
        assertTrue(typeInfo.classImplementsInterface(human, "io.michaelcarroll.Speakable"));
    }

    @Test
    public void listAllMembers() {
        Field[] i = Human.class.getDeclaredFields();
        for (Field field : i) {
            System.out.println(field);
        }
        String expectedValue = "private java.lang.String io.michaelcarroll.Human.name\npublic java.lang.String io.michaelcarroll.Human.address\n";
        String actualValue = typeInfo.listAllMembers(human);
        assertEquals("The expected value is private java.lang.String io.michaelcarroll.Human.name\npublic java.lang.String io.michaelcarroll.Human.address\n",expectedValue, actualValue);
    }

    @Test
    public void getClassHierarchy() {
        String expectedValue = "io.michaelcarroll.Human\njava.lang.Object\n\t";
        String actualValue = typeInfo.getClassHierarchy(human);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void instantiateClassHierarchy(){
        assertTrue(typeInfo.instantiateClassHierarchy(human).get(0) instanceof Human);
        assertTrue(typeInfo.instantiateClassHierarchy(human).get(1) instanceof Object);
    }

}