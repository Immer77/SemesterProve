package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private LocalDateTime start;
    private LocalDateTime slut;
    private ArrayList<Plads> pladser = new ArrayList<>();

    public Reservation(LocalDateTime start, LocalDateTime slut){
        this.start = start;
        this.slut = slut;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getSlut() {
        return slut;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setSlut(LocalDateTime slut) {
        this.slut = slut;
    }


    /**
     * Add plads to the reservation
     * @param plads
     */

    public void addPlads(Plads plads) {
        if(!pladser.contains(plads)){
            pladser.add(plads);
            plads.addReservation(this);
        }
    }


    /**
     * Removes the plads aswell as the reservation
     * @param plads
     */
    public void removePlads(Plads plads) {
        if(pladser.contains(plads)){
            pladser.remove(plads);
            plads.removeReservation(this);
        }
    }

    /**
     * Returns a copy of pladser
     * @return
     */
    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    @Override
    public String toString(){
        return "Start date: " + start + "End date: " + slut;
    }
}
