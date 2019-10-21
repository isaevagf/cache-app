package cacheDemo.cacheapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer key;
    private String data;

    public Entry() {};

    public Entry(Integer key, String data) {
        this.key = key;
        this.data = data;
    }
}
