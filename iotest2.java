package com.company;

import java.io.*;

/**
 * @author atom.hu
 * @version v1.0
 * @Package com.company
 * @data 2021-01-24 11:21
 */
public class iotest2 {
    public static void main(String[] args) {
        File fi = new File("src/com/company/ioword.txt");
        FileWriter out = null;

        BufferedWriter bw = null;
        String str[] = {"天行健，君子以自强不息", "地势坤，君子以厚德载物"};

        try {
            out = new FileWriter(fi,true);
            bw = new BufferedWriter(out);//包装字符流可以以行为单位输入或输出
            /*String str = "天行健，君子以自强不息";
            out.write(str);//没用bufferwriter*/
            for (int i = 0; i < str.length; i++) {
                bw.write(str[i]);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //先创建的后关闭
            if (bw != null) {
                try {
                    bw.close();
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
        FileReader in = null;
        BufferedReader br = null;
        try {
            in = new FileReader(fi);
            br = new BufferedReader(in);
            /*char ch[] = new char[1024];
            int count = in.read(ch);
          //  while ((count= in.read(ch)) != -1) {
                System.out.println(new String(ch, 0, count));
           // }*/

            //bufferedReader的输出格式
            String tmp = null;
            int i = 1;//计时器
            while ((tmp = br.readLine()) != null) {
                System.out.println("第" + i + "行" + tmp);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //先创建的后关闭
            if (br != null) {
                try {
                    br.close();
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
