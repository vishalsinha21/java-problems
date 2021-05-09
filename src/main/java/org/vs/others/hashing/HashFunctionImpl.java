package org.vs.others.hashing;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunctionImpl implements HashFunction {
    @Override
    public int hash(Object object) {
        try {
            return getChecksum(object).hashCode() % 1000;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static String getChecksum(Object object) throws IOException, NoSuchAlgorithmException {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(baos.toByteArray());
            return DatatypeConverter.printHexBinary(thedigest);
        } finally {
            oos.close();
            baos.close();
        }
    }
}
