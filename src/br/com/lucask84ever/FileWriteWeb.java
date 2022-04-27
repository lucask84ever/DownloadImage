package br.com.lucask84ever;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class FileWriteWeb {
    private URL url;

    public FileWriteWeb(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void downloadFromWeb(int chapter) {
        String localFilename = "/Users/lucask84ever-2/Documents/Temp.html";
        try {
            BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(localFilename));
            HttpsURLConnection con = (HttpsURLConnection) getUrl().openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
            InputStream is = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "Windows-1252");
            BufferedReader br = new BufferedReader(isr);
            String inputLine;

            while((inputLine = br.readLine())!= null) {
                long elapsedTime = System.nanoTime() - Main.startTime;
                System.out.println("Tempo discorrido: " + elapsedTime/1000000);
                bw.write(inputLine);
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fr = new FileReader(new File(localFilename));
        FileWriter fw = new FileWriter("/Users/lucask84ever-2/Documents/Kiss x Sis/", "/Users/lucask84ever-2/Documents/Kiss x Sis//Chapter " + chapter + "/", fr.parseManga());
        fw.createDirectoryWithSubDiretories();
    }
}
