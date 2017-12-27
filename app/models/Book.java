package models;

import io.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book extends Model{
    @Id
    public int id;

    public String name;


    public Book(int id,String name){
        this.id = id;
        this.name = name;
    }

}