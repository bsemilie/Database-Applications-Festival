package server.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "concert")
public class Concert implements Serializable{

  @Id
  public int id;
  public String artiste;
  public int sederoulesur;

  Concert(){}

  Concert(int id,String artiste, int sederoulesur){
    this.id = id;
    this.artiste = artiste;
    this.sederoulesur = sederoulesur;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return this.id;
  }

  public  void setArtiste(String artiste){
    this.artiste = artiste;
  }

  public String getArtiste(){
    return this.artiste;
  }

  public void setSederoulesur(int sederoulesur){
    this.sederoulesur = sederoulesur;
  }

  public int getSederoulesur(){
    return this.sederoulesur;
  }

}
