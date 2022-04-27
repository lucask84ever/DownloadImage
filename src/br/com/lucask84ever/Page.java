package br.com.lucask84ever;

import java.net.URL;

public class Page {
    private int number;
    private URL url;

    public Page(int number, URL url) {
        this.number = number;
        this.url = url;
    }

    public int getNumber() {
        return this.number;
    }

    public URL getUrl() {
        return this.url;
    }
}
