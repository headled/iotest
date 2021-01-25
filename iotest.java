package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * @author atom.hu
 * @version v1.0
 * @Package com.company
 * @data 2021-01-24 10:46
 */
public class iotest {
    public static void main(String[] args) {
        File j = new File("src/com/company/workd.txt");
        FileOutputStream out = null;
        BufferedOutputStream bo = null;
        try {
            out = new FileOutputStream(j, true);
            bo = new BufferedOutputStream(out);//包装字节流加大程序执行效率
            Scanner input = new Scanner(System.in);

            String str = input.next();

                byte b[] = str.getBytes();

            // out.write(b);// 没用bufferinputstream
            bo.write(b);
            //bufferedoutputstream才有flush方法
            bo.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //先创建的后关闭
            if (bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileInputStream in = null;
        BufferedInputStream bi = null;
        try {
            in = new FileInputStream(j);
            bi = new BufferedInputStream(in);
            byte b2[] = new byte[200];
            //int len = in.read(b2);//没用bufferedinputstream
            int len = bi.read(b2);
            System.out.println(new String(b2,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //先创建的后关闭
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

