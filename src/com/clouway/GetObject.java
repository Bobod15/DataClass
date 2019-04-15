package com.clouway;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class GetObject {
    public GetObject() {
    }

    public Object getObject(InputStream in) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(in).readObject();
    }
}
