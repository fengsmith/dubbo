package service.impl;

import service.DemoService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by shifengqiang on 17/3/10.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "hello " + name;
    }

    public static void main(String[] args) {
        String path = "/Users/shifengqiang/projects/dubbo";
        File folder = new File(path);
        File test = new File("/Users/shifengqiang/projects/dubbo");
        Counter javaFileCount = new Counter();
        Counter counter = new Counter();

        readDirectory(test, javaFileCount, counter);
        System.out.println(javaFileCount.getCount());
        System.out.println(counter.getCount());
    }

    private static void readDirectory(File folder, Counter javaFileCount, Counter counter) {
        if (folder == null || !folder.isDirectory()) {
            return;
        }
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                readDirectory(file, javaFileCount, counter);
            } else {
                String fileName = file.getName();
                if (fileName.endsWith(".java") && !fileName.endsWith("Test.java")) {
                    javaFileCount.addOne();

                    String path = file.getPath();
                    try {
                        Files.lines(Paths.get(path)).forEach(line -> {
                            counter.addOne();
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }


        }


    }

    public static class Counter {
        Integer count = new Integer(0);

        public Integer getCount() {
            return count;
        }

        public void addOne() {
            count++;
        }
    }
}
