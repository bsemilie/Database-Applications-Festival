package server.interfaces;
import javax.ejb.Remote;

import server.exceptions.NbMaxConcertsAtteint;

@Remote
public interface IGestionScene{
  public void creerSessionScene(int id);
  public void ajouterConcert(int id) throws NbMaxConcertsAtteint;
}
