package application.controller;

import application.model.Arrangement;
import application.model.Område;
import application.model.Plads;
import application.model.Reservation;
import storage.Storage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    public static Arrangement createArrangement(String navn, boolean offentlig){
        Arrangement arrangement = new Arrangement(navn,offentlig);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static void deleteArrangement(Arrangement arrangement){
        Storage.removeArrangement(arrangement);
    }

    public static void updateArrangement(Arrangement arrangement, String navn, boolean offentlig){
        arrangement.setNavn(navn);
        arrangement.setOffentlig(offentlig);
    }

    public static ArrayList<Arrangement> getArrangementer(){
        return Storage.getArrangementer();
    }

    //--------------------------------------------------------

    public static Plads createPlads(int nr, Område område){
        Plads plads = new Plads(nr,område);
        Storage.addPladser(plads);
        return plads;
    }

    public static void deletePlads(Plads plads){
        Storage.removePladser(plads);
    }

    // Unødvendig at update pladser ?
//    public static void updatePladser(Plads plads, int nr, Område område){
//        plads.
//    }

    public static ArrayList<Plads> getPladser(){
        return Storage.getPladser();
    }
    //-------------------------------------------------------------------

    public static Reservation createReservation(LocalDateTime start, LocalDateTime slut){
        Reservation reservation = new Reservation(start,slut);
        Storage.addReservation(reservation);
        return reservation;
    }

    public static void removeReservation(Reservation reservation){
        Storage.removeReservation(reservation);
    }

    public static void updateReservation(Reservation reservation, LocalDateTime start, LocalDateTime slut){
        reservation.setStart(start);
        reservation.setSlut(slut);
    }

    public static ArrayList<Reservation> getReservations(){
        return Storage.getReservations();
    }
    //-----------------------------------------------------------------

    public static void addReservationsToPladser(Reservation reservation, Plads plads){
        plads.addReservation(reservation);
    }

    public static void removeReservationsFromPladser(Reservation reservation, Plads plads){
        if(reservation != null){
            plads.removeReservation(reservation);
        }
    }

    public static void addReservationToArrangement(Reservation reservation, Arrangement arrangement){
        arrangement.addReservation(reservation);
    }

    public static void removeReservationFromArrangement(Reservation reservation, Arrangement arrangement){
        if(reservation != null){
            arrangement.removeReservation(reservation);
        }
    }

    public static void initStorage(){

        Plads plads1 = Controller.createPlads(1,Område.TURNERING);
        Plads plads2 = Controller.createPlads(2,Område.TURNERING);
        Plads plads3 = Controller.createPlads(3,Område.STANDARD);
        Plads plads4 = Controller.createPlads(4,Område.STANDARD);
        Plads plads5 = Controller.createPlads(5,Område.BØRNE);
        Plads plads6 = Controller.createPlads(6,Område.VIP);

        Arrangement arrangement1 = Controller.createArrangement("Dota 2 Arrangement",true);
        Arrangement arrangement2 = Controller.createArrangement("CS GO Tournament",false);

        Reservation reservation1 = Controller.createReservation(LocalDateTime.of(2019,8,12,20,0),LocalDateTime.of(2019,8,12,23,0));
        Reservation reservation2 = Controller.createReservation(LocalDateTime.of(2019,8,13,19,0), LocalDateTime.of(2019,8,14,6,0));
        Reservation reservation3 = Controller.createReservation(LocalDateTime.of(2019,8,14,19,0), LocalDateTime.of(2019,8,15,6,0));


        //TIlføjer reservation til pladser og arrangementer
        Controller.addReservationsToPladser(reservation1,plads1);
        Controller.addReservationsToPladser(reservation1,plads2);
        Controller.addReservationToArrangement(reservation1,arrangement1);

        // Tilføjer reservation til standard områderne
        Controller.addReservationsToPladser(reservation2,plads3);
        Controller.addReservationsToPladser(reservation2,plads4);

        // Tilføøjer reservation til plads 6 området VIP
        Controller.addReservationsToPladser(reservation3,plads6);

    }

    public static void init() {
        initStorage();
    }
}
