package br.com.lucask84ever;

import java.util.ArrayList;
import java.util.List;

public class Manga {
    private String name;
    private String path;
    private int chapter;
    private List<Page> pages;

    public Manga() {
        this.pages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public List<Page> getPages() {
        return pages;
    }

    public boolean addPage(Page page) {
        return this.getPages().add(page);
    }
}
