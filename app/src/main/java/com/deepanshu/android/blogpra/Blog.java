package com.deepanshu.android.blogpra;

public class Blog {
    private  String title,authorName,ON,whn;
    private String imgUrl;

    private String when;
    private String describe;


    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", ON='" + ON + '\'' +
                ", whn='" + whn + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", when='" + when + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getON() {
        return ON;
    }

    public void setON(String ON) {
        this.ON = ON;
    }

    public String getWhn() {
        return whn;
    }

    public void setWhn(String whn) {
        this.whn = whn;
    }

    public Blog(String title,String whn, String authorName,String ON,  String describe, String imgUrl) {
        this.title = title;
        this.whn = whn;
        this.authorName=authorName;
        this.ON=ON;
        this.describe = describe;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }




}
