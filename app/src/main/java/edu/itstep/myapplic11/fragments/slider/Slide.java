package edu.itstep.myapplic11.fragments.slider;

import edu.itstep.myapplic11.models.Post;

public class Slide
{
    private final Post post;
    private String header, paragraph;
    private int color;


    public Slide(String header, String paragraph, int color, Post post) {
        this.header = header;
        this.paragraph = paragraph;
        this.color = color;
        this.post = post;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Post getPost() {
        return post;
    }
}
