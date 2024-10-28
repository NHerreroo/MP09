package Threads.Jugador;

public class Player implements Runnable,Comparable<Player>{

    private String nom;
    private int punt;

    public Player(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getPunt() {
        return punt;
    }

    public void addPunt(int punt) {
        this.punt += punt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nom='" + nom + '\'' +
                ", punt=" + punt +
                '}';
    }

    @Override
    public void run() {
       int punts = (int) Math.floor(Math.random()*11);
        System.out.println(nom + ": ha fet " + punts + " punts!");
        punt += punts;
    }

    @Override
    public int compareTo(Player player) {
        return Integer.compare(this.punt, player.punt);
    }
}
