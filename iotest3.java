package com.company;

import java.io.*;

/**
 * @author atom.hu
 * @version v1.0
 * @Package com.company
 * @data 2021-01-26 9:28
 */
public class iotest3 {
    public static void main(String[] args) {
        File fi = new File("word.txt");
        FileOutputStream fo = null;
        DataOutputStream dos = null;

        try {
            fo = new FileOutputStream(fi,true);
            dos = new DataOutputStream(fo);
            dos.writeUTF("荷塘月色");
            dos.writeDouble(3.14);
            dos.writeBoolean(true);
            dos.writeBytes("yhet");
            dos.writeChars("sda");
            dos.writeInt(123);
            dos.close();
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;
        DataInputStream Dis = null;
        try {
            fis = new FileInputStream(fi);
            Dis = new DataInputStream(fis);
            System.out.println("readUTF()读取数据："+Dis.readUTF());
            System.out.println("readDouble()读取数据："+Dis.readDouble());
            System.out.println("readBoolean()()读取数据："+Dis.readBoolean());
            System.out.println("readInt()读取数据："+Dis.readInt());
            System.out.println("readBytes()读取数据："+Dis.readByte());
            System.out.println("readChars()读取数据："+Dis.readChar());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
