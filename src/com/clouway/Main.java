package com.clouway;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        Path dataStream = Paths.get(("/home/clouway/clouway/workspaces/idea/TextFilesDir/dataStream.txt"));

        OutputStream dataOutput = null;
        InputStream dataInput = null;
        try {
            dataOutput = new FileOutputStream(dataStream.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dataInput = new FileInputStream(dataStream.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Dog dog = new Dog("dogname", 11 , "breed");
        Dog restoredDog = new Dog();

        Person guy = new Person("guy", 12, true);
        Person restoredPerson = new Person();

        try {
            new SaveObject().saveObject(dataOutput, dog);
            new SaveObject().saveObject(dataOutput, guy);
            new SaveObject().saveObject(dataOutput,guy);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GetObject go = new GetObject();
        Object temp;

/*        if(temp.getClass().isInstance(restoredPerson)) {
            restoredPerson = (restoredPerson.getClass().cast(temp));
            System.out.println(restoredPerson.getClass());
        }*/

        try {
            assert dataInput != null;
            for(int i = 0; i < dataInput.available() ; i++) {
                temp = go.getObject(dataInput);
                restoredDog.setAttributesWithAutoCast(temp);
                restoredPerson.setAttributesWithAutoCast(temp);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(restoredDog.getName());
        System.out.println(restoredPerson.getName());
        try {
            dataInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (dataOutput != null) {
                dataOutput.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
