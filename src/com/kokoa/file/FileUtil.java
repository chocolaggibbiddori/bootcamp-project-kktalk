package com.kokoa.file;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    private FileUtil() {
    }

    public static void writeHtml(String uri, String content) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(uri);
            fw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(fw);
        }
    }

    private static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
