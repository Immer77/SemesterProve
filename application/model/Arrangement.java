package application.model;

import java.util.ArrayList;

public class Arrangement {
    private String navn;
    private boolean offentlig;
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public Arrangement(String navn, boolean offentlig){
        this.navn = navn;
        this.offentlig = offentlig;
    }

    public ArrayList<Reservation> getReservations(){
        return new ArrayList<>(reservations);
    }

    public void addReservation(Reservation reservation){
        if(!reservations.contains(reservation)){
            reservations.add(reservation);
        }
    }

    public void removeReservation(Reservation reservation){
        if(reservations.contains(reservation)){
            reservations.remove(reservation);
        }
    }

    public int antalReserveredePladser(){
        int antalPladser = 0;
        for (Reservation reservation : reservations){
            antalPladser += reservation.getPladser().size();
        }
        return antalPladser;
    }

    public void setNavn(String navn){
        this.navn = navn;
    }

    public void setOffentlig(boolean offentlig){
        this.offentlig = offentlig;
    }

}
