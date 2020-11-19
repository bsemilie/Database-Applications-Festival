package client;

import server.interfaces.IGestionScene;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client{
  private IGestionScene iGestionScene;

  public static void main(String[] args){
    Client client = new Client();

    client.initialisation();

    //System.out.println("Test attribution scene à un concert");
    //client.testAttributionScene(1,1);
    //System.out.println();

    System.out.println("Test maximum attribution de concerts à une scène");
    client.testAttributionScene(1,1);
    client.testAttributionScene(1,2);
    client.testAttributionScene(1,3);
    client.testAttributionScene(1,4);
    client.testAttributionScene(1,5);
    client.testAttributionScene(1,6);
    System.out.println();
  }


  private void initialisation(){
    try{
      InitialContext initialContext = new InitialContext();
      this.iGestionScene = (IGestionScene) initialContext.lookup("server.interfaces.IGestionScene");
    } catch(NamingException e){
      e.printStackTrace();
    }
  }

  private void testAttributionScene(int id_scene, int id_concert){
    System.out.printf("> Attribution de la scène %d au concert %d\n", id_scene, id_concert);
    try{
      this.iGestionScene.creerSessionScene(id_scene);
      this.iGestionScene.ajouterConcert(id_concert);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
