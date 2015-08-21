package com.example.ashu4642.nbaplayers;

/**
 * Created by ashu4642 on 11/6/2014.
 */
public class Player {

    private String id;
    private String title;
    private String content;

    Player(String noteId, String noteTitle, String noteContent) {
        id = noteId;
        title = noteTitle;
        content = noteContent;

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return this.getTitle() + "  " + this.getContent();
    }


}
