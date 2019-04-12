package com.clouway;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SaveObject {
    public SaveObject() {
    }

    public void saveObject(OutputStream out , Object obj) throws IOException {
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject(obj);
    }
}
