package com.liboshuai.mall.tiny.zlearning.Test.literal.day09.d2_recusion;

import java.io.File;
import java.io.IOException;

public class RecursionDemo05 {
    public static void main(String[] args) {



    }

    public static void searchFile(File dir,String fileName){
        if (dir != null && dir.isDirectory()){

            File[] files = dir.listFiles();

            if (files != null && files.length > 0){
                for (File file : files){
                    if (file.isFile()){
                        if (file.getName().contains(fileName)){
                            System.out.println("找到了：" + file.getAbsolutePath());
                            try {
                                Runtime r = Runtime.getRuntime();
                                r.exec(file.getAbsolutePath());
                            } catch(IOException e) {

                            }
                        }
                    }
                }
            }

        }
    }


}
