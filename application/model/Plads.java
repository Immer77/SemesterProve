package application.model;

import java.util.ArrayList;

public class Plads {
    private int nr;
    private Område område;
    private final ArrayList<Reservation> reservations = new ArrayList<>();
    private static int standardTimePris = 50;

    public Plads(int nr, Område område){
        this.nr = nr;
        this.område = område;
    }

    public ArrayList<Reservation> getReservations(){
        return new ArrayList<>(reservations);
    }

    public void addReservation(Reservation reservation){
        if(!reservations.contains(reservation)){
            reservations.add(reservation);
            reservation.addPlads(this);
        }
    }

    public void removeReservation(Reservation reservation){
        if(reservations.contains(reservation)){
            reservations.remove(reservation);
            reservation.removePlads(this);
        }
    }
    public int getNr() {
        return nr;
    }

    public Område getOmråde() {
        return område;
    }
    public static int getStandardTimePris() {
        return standardTimePris;
    }

    public static void setStandardTimePris(int standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }

    public double pris(int timer){
        double result = 0;
        if(område.equals(Område.VIP)){
            result = standardTimePris * timer * 1.25;
        } else if(område.equals(Område.BØRNE)){
            result = standardTimePris * timer * 0.80;
        } else if(område.equals(Område.TURNERING)){
            result = standardTimePris * timer * 1.10;
        } else{
            result = standardTimePris * timer;
        }
        return result;
    }

     @Override
    public String toString(){
        return "" + nr + reservations + område;
     }

}
