package org.vs.others.hashing;

public class CacheServer {

    private final String id;

    public CacheServer(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CacheServer{" +
                "id=" + id +
                '}';
    }
}
