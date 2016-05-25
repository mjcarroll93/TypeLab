package io.michaelcarroll;


import java.lang.reflect.Field;
import java.util.ArrayList;

public class TypeInfo {

    public boolean classImplementsInterface(Object obj, String name) {

        Class inter = null;

        try {
            inter = Class.forName(name);
        } catch (ClassNotFoundException e) {

        }
        if (inter.isInstance(obj))
            return true;
        else
            return false;
    }

    public String listAllMembers(Object obj) {
        String allMembers = "";
        Field[] members = obj.getClass().getDeclaredFields();
        for (Field field : members) {
            allMembers += field+ "\n";
        }
        return allMembers;
    }

    public String getClassHierarchy(Object obj){
        ArrayList<String> hierarchies = new ArrayList<String>();
        String output = "";
        Class cls = obj.getClass();
        while(cls != null){
            hierarchies.add(cls.getName());
            cls = cls.getSuperclass();
        }
        for (int i = 0; i < hierarchies.size() ; i++) {
            output += hierarchies.get(i) + "\n";
            for (int j = 0; j < i; j++) {
                output += "\t";
            }
        }
        return output;
    }

    public ArrayList<Object> instantiateClassHierarchy(Object obj){
        ArrayList<Object> hierarchies = new ArrayList<Object>();
        Class cls = obj.getClass();
        while(cls != null){
            try {
                hierarchies.add(cls.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            cls = cls.getSuperclass();
        }

        return hierarchies;
    }
}

