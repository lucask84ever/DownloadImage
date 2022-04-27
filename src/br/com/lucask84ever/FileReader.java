package br.com.lucask84ever;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private File path;
    private URL url;

    public FileReader(File path) {
        this.path = path;
    }

    public FileReader(URL url) {
        this.url = url;
    }
    public void setPath(File path) {
        this.path = path;
    }

    public File getPath() {
        return this.path;
    }

    public Manga parseManga() {
        int number = 0;
        Manga manga = new Manga();
        for(String currentPage: this.readFile()) {
            try {
                Page page = new Page(number += 1, new URL(currentPage));
                manga.addPage(page);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return manga;
    }

    public List<String> readFile() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> listImageURLs = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(this.getPath());
            int r = 0;

            while((r = fis.read()) != -1) {
                stringBuilder.append((char)r);
            }
            listImageURLs = this.retrieveImagesURL(stringBuilder.toString());

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return listImageURLs;
    }

    public List<String> retrieveImagesURL(String html) {
        String substring = html.toString().substring(html.indexOf("images\":["), html.indexOf(".jpg\"]}]"));
        String formatada = substring.replace("\\/", "/");
        formatada = formatada.replace(",","");
        formatada = formatada.replace("images", "");
        formatada = formatada.replace(":[", "");
        formatada = formatada.replace("\n", "");
        formatada = formatada.replace("https://2.", "https://images2.");
        String[] split = formatada.split("\"");
        return retrieveImagesURL(split);
    }

    private List<String> retrieveImagesURL(String []urls) {
        List<String> imgUrls = new ArrayList<String>();
        for (String htmlBody: urls) {
            if (htmlBody.startsWith("https://images2.")) {
                imgUrls.add(htmlBody.endsWith(".jpg") ? htmlBody : htmlBody + ".jpg");
            }
        }
        return imgUrls;
    }
}
