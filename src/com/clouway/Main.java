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

        String obj = "assd";

        try {
            new SaveObject().saveObject(dataOutput, obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String otStream = null;
        try {
            otStream = String.valueOf(new GetObject().getObject(dataInput));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(otStream);

    }
}
