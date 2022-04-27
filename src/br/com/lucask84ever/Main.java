package br.com.lucask84ever;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    static int pageInitial = 0;
    static int pageFinal = 151;
    static long startTime = System.nanoTime();

    public static void main(String[] args) {
//        useLocalFile();
        try {
            useHttpUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void useHttpUrl() throws MalformedURLException {
        for(int i = 16; i < pageFinal; i += 1) {
            FileWriteWeb fww = new FileWriteWeb(new URL("https://manhwax.com/kiss-x-sis-chapter-" + i + "-english/"));
            fww.downloadFromWeb(i);
            System.out.println("Terminou o capitulo " + i);
        }
        System.out.println("Terminou");
    }

    public static void useLocalFile() {
        FileReader fr = new FileReader(new File("/Users/lucask84ever-2/Downloads/test.html"));

        FileWriter fw = new FileWriter("/Users/lucask84ever-2/Documents/MangaTest", fr.parseManga());
        fw.createDirectory();
        System.out.println("Terminou");
    }
}
