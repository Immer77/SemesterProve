package storage;

import application.model.Arrangement;
import application.model.Plads;
import application.model.Reservation;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    //----------------------------------------------------------------------

    public static ArrayList<Reservation> getReservations(){
        return new ArrayList<>(reservations);
    }

    public static void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public static void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    //-------------------------------------------------------------

    public static ArrayList<Plads> getPladser(){
        return new ArrayList<>(pladser);
    }

    public static void addPladser(Plads plads){
        pladser.add(plads);
    }

    public static void removePladser(Plads plads){
        pladser.remove(plads);
    }

    //-------------------------------------------------------------

    public static ArrayList<Arrangement> getArrangementer(){
        return new ArrayList<>(arrangementer);
    }

    public static void addArrangement(Arrangement arrangement){
        arrangementer.add(arrangement);
    }

    public static void removeArrangement(Arrangement arrangement){
        arrangementer.remove(arrangement);
    }
}
