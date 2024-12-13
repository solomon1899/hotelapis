        package com.example.restprojecthotel.controller;

        import com.example.restprojecthotel.entities.Reservation;
        import com.example.restprojecthotel.entities.Client;
        import com.example.restprojecthotel.entities.Chambre;
        import com.example.restprojecthotel.entities.TypeChambre;
        import com.example.restprojecthotel.service.ReservationService;
        import jakarta.jws.WebMethod;
        import jakarta.jws.WebParam;
        import jakarta.jws.WebService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.List;

        @Component
        @WebService(serviceName = "ReservationWS")
        public class SoapReservationController {

            @Autowired
            private ReservationService reservationService;

            @WebMethod
            public List<Reservation> getAllReservations() {
                return reservationService.getAllReservations();
            }

            @WebMethod
            public Reservation getReservationById(@WebParam(name = "id") Long id) {
                return reservationService.getReservationById(id).orElse(null);
            }

            @WebMethod
            public Reservation createReservation(
                    @WebParam(name = "clientNom") String clientNom,
                    @WebParam(name = "clientPrenom") String clientPrenom,
                    @WebParam(name = "clientEmail") String clientEmail,
                    @WebParam(name = "chambreNumero") String chambreNumero,
                    @WebParam(name = "chambreType") String chambreType,
                    @WebParam(name = "chambrePrix") double chambrePrix,
                    @WebParam(name = "dateDebut") String dateDebut,
                    @WebParam(name = "dateFin") String dateFin
            ) {
                // Parse chambreType from String to Enum
                TypeChambre parsedChambreType;
                try {
                    parsedChambreType = TypeChambre.valueOf(chambreType.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Invalid chambreType value: " + chambreType);
                }

                // Create and save Client
                Client client = new Client();
                client.setNom(clientNom);
                client.setPrenom(clientPrenom);
                client.setEmail(clientEmail);

                // Create and save Chambre
                Chambre chambre = new Chambre();
                chambre.setNumero(chambreNumero);
                chambre.setType(parsedChambreType);
                chambre.setPrix(chambrePrix);

                // Create Reservation
                Reservation reservation = new Reservation();
                reservation.setClient(client);
                reservation.setChambre(chambre);
                reservation.setDateDebut(dateDebut);
                reservation.setDateFin(dateFin);

                return reservationService.createReservation(reservation);
            }

            @WebMethod
            public boolean deleteReservation(@WebParam(name = "id") Long id) {
                if (reservationService.getReservationById(id).isPresent()) {
                    reservationService.deleteReservation(id);
                    return true;
                }
                return false;
            }

            @WebMethod
            public Reservation updateReservation(
                    @WebParam(name = "id") Long id,
                    @WebParam(name = "clientNom") String clientNom,
                    @WebParam(name = "clientPrenom") String clientPrenom,
                    @WebParam(name = "clientEmail") String clientEmail,
                    @WebParam(name = "chambreNumero") String chambreNumero,
                    @WebParam(name = "chambreType") String chambreType,
                    @WebParam(name = "chambrePrix") double chambrePrix,
                    @WebParam(name = "dateDebut") String dateDebut,
                    @WebParam(name = "dateFin") String dateFin
            ) {
                // Parse chambreType from String to Enum
                TypeChambre parsedChambreType;
                try {
                    parsedChambreType = TypeChambre.valueOf(chambreType.toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException("Invalid chambreType value: " + chambreType);
                }

                // Prepare details for the updated Reservation
                Reservation reservationDetails = new Reservation();

                // Update Client information
                Client client = new Client();
                client.setNom(clientNom);
                client.setPrenom(clientPrenom);
                client.setEmail(clientEmail);
                reservationDetails.setClient(client);

                // Update Chambre information
                Chambre chambre = new Chambre();
                chambre.setNumero(chambreNumero);
                chambre.setType(parsedChambreType);
                chambre.setPrix(chambrePrix);
                reservationDetails.setChambre(chambre);

                // Update dates
                reservationDetails.setDateDebut(dateDebut);
                reservationDetails.setDateFin(dateFin);

                return reservationService.updateReservation(id, reservationDetails);
            }
        }
