package model;

import java.net.URL;

public class Medias {
    
    private URL url;
    int sceneNumber;
    public Medias(URL url, int sceneNumber){
        this.url = url;
        this.sceneNumber = sceneNumber;
    }

    public URL getUrl() {
        return url;
    }

    public int getSceneNumber() {
        return sceneNumber;
    }
}
