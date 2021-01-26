package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author atom.hu
 * @version v1.0
 * @Package com.company
 * @data 2021-01-26 10:26
 */
public class ziptest {
    static void addEntry(ZipOutputStream zos, String bas, File source) {
        if (source.isDirectory()) {
            for (File file : source.listFiles()) {
                addEntry(zos, bas + source.getName() + File.separator, file);//File.separator为文件路径分隔线
            }
        }else {
            byte buf[] = new byte[1024];
            try {
                FileInputStream fis = new FileInputStream(source);
                int count = -1;
                zos.putNextEntry(new ZipEntry(bas + source.getName()));
                while ((count = fis.read(buf)) != -1) {
                    zos.write(buf, 0, count);
                    zos.flush();
                }
                zos.closeEntry();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        File source = new File("workd.txt");//源文件路径
        File target = new File("src/com/company/word.zip");//压缩包压缩路径
        try {
            FileOutputStream fo = new FileOutputStream(target);
            ZipOutputStream zo = new ZipOutputStream(fo);
            if (source.isDirectory()) {
                for (File f : source.listFiles()) {
                    addEntry(zo, "", f);
                }
            }else{
                addEntry(zo, "", source);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
