package github.opensource.netty.client;

/**
 * Project :  NettyServer.
 * Package name: github.opensource.netty.client
 * Created by :  Administrator.
 * Created time: 2017/7/17 13:53
 * Changed by :  Administrator.
 * Changed time: 2017/7/17 13:53
 * Class description:
 */

class Dog {
    private int dogId;
    private String dogName;
    private String dogImage;

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogImage() {
        if (this.dogImage == null) {
            return "";
        } else {
            return dogImage;
        }
    }

    public void setDogImage(String dogImage) {
        this.dogImage = dogImage;
    }
}
