package server.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class NbMaxConcertsAtteint extends Exception {

  public NbMaxConcertsAtteint(){
    super(
    "Exception: Nombre maximum de concerts atteint pour cette scène");
  }
}
