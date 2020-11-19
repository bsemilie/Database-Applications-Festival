package server.implementations;
import javax.ejb.Stateful;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import server.interfaces.IGestionScene;
import server.entities.Concert;
import server.entities.Scene;
import server.exceptions.NbMaxConcertsAtteint;

@Stateful
public class GestionScene implements IGestionScene{
  @PersistenceContext(unitName = "FestivalManagement", type=PersistenceContextType.EXTENDED)
  protected EntityManager em;

  @Resource(lookup = "java:comp/env/MAX_CONCERTS")
  int MAX_CONCERTS;

  public Scene scene;
  @Override
  public void creerSessionScene(int id){
    this.scene = em.find(Scene.class, id);
    if(this.scene != null){
      System.out.printf("La session pour la scène %d a bien démarrée\n", id);
    }
    else{
      System.out.println("L'identifiant de scène n'est pas présent dans la base de donnée");
    }
  }

  @Override
  public void ajouterConcert(int id) throws NbMaxConcertsAtteint{

    Concert concert = em.find(Concert.class, id);
    if(concert != null) {
      try{
          concert.setSederoulesur(this.scene.getId());
          this.scene.ajouterConcertScene(MAX_CONCERTS);
      }
      catch(NbMaxConcertsAtteint exc){
        throw exc;
      }
    }
    else{
      System.out.println("Le concert n'existe pas dans la base de donnée");
    }

  }
}
