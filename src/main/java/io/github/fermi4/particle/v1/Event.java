package io.github.fermi4.particle.v1;

public class Event {
    private final String data;
    private final String name;
    private final int ttl;
    public Event(String data, String name, int ttl) {
        super();
        this.data = data;
        this.name = name;
        this.ttl = ttl;
    }

    public String getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public int getTtl() {
        return ttl;
    }
    
}
