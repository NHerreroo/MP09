package Jugador;

public class MonitorPlayer implements Runnable {
    private Player player;

    public MonitorPlayer (Player p){
        player = p;
    }

    @Override
    public void run() {
        System.out.println(player.getNom()  + " Te ara mateix: " + player.getPunt() + " Punts");
    }
}
