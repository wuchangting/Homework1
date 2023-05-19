package com.example.homework1;

public class Message {
    private int imageId;
    private String username;
    private String inform;
    public Message(int imageId, String username, String inform) {
        this.imageId = imageId;
        this.username = username;
        this.inform = inform;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }
}
