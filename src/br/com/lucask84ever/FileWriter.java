package br.com.lucask84ever;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class FileWriter {
    private String mainPath;
    private String path;
    private Manga manga;

    public FileWriter(String mainPath, String subFolder, Manga manga) {
        this.mainPath = mainPath;
        this.path = subFolder;
        this.manga = manga;
    }

    public FileWriter(String path, Manga manga) {
        this.path = path;
        this.manga = manga;
    }

    public String getPath() {
        return path;
    }

    public Manga getManga() {
        return manga;
    }

    public String getMainPath() {
        return mainPath;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath;
    }

    public void createDirectoryWithSubDiretories() {
        File directory = new File(this.getMainPath());
        File subDirectory = new File(this.getPath());

        if(!directory.exists()) {
            directory.mkdir();
        }

        if(!subDirectory.exists()) {
            subDirectory.mkdir();
        }
        this.writeFile(this.getManga());
    }

    public void createDirectory() {
        File directory = new File(this.getPath());
        if(!directory.exists()) {
            directory.mkdir();
        }
        this.writeFile(this.getManga());
    }

    private void writeFile(Manga manga)  {
        for(Page page: manga.getPages()) {
            try {
                InputStream in = new BufferedInputStream(page.getUrl().openStream());
                OutputStream out = new BufferedOutputStream(new FileOutputStream(this.getPath() + "/" + page.getNumber() + ".jpg"));

                for (int i; (i = in.read()) != -1; ) {
                    out.write(i);
                }
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
