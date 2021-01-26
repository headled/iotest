package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author atom.hu
 * @version v1.0
 * @Package com.company
 * @data 2021-01-26 10:49
 */
public class ziptest2 {
    public static void main(String[] args) {

        File dir = new File("src/com/company/");//解压目的路径
        File source = new File("src/com/company/word.zip");//解压文件路径
        byte buf[] = new byte[1024];
        ZipEntry entry = null;
        try {
            FileInputStream fis = new FileInputStream(source);
            ZipInputStream zis = new ZipInputStream(fis);
            while (true) {
                entry = zis.getNextEntry();//获取一个项目
                if (entry == null) {
                    break;
                }
                if (entry.isDirectory()) {
                    continue;
                }
                File f = new File(dir, entry.getName());
                if (f.getParentFile().exists()) {//如果解压文件夹不存在
                    f.getParentFile().mkdirs();//创建文件夹
                }
                int count = -1;
                FileOutputStream fos = new FileOutputStream(f);
                while ((count = zis.read(buf)) != -1) {
                    fos.write(buf, 0, count);
                    fos.flush();
                }
                fos.close();
                zis.closeEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
