package server.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import server.exceptions.NbMaxConcertsAtteint;


@Entity
@Table(name="scene")
public class Scene implements Serializable{

  @Id
  public int id;
  public String nom;
  public int nbconcerts;

  Scene(){}

  Scene(int id, String nom, int nbconcerts){
    this.id = id;
    this.nom = nom;
    this.nbconcerts = nbconcerts;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return this.id;
  }

  public void setNom(String nom){
    this.nom = nom;
  }

  public String getNom(){
    return this.nom;
  }

  public void setNbconcerts(int nbconcerts){
    this.nbconcerts = nbconcerts;
  }

  public int getNbconcerts(){
    return this.nbconcerts;
  }

  public void ajouterConcertScene(int nb_max_concerts) throws NbMaxConcertsAtteint{
    this.nbconcerts++;
    if(this.nbconcerts > nb_max_concerts){
      throw new NbMaxConcertsAtteint();
    }
  }
}
