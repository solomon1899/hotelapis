package com.example.restprojecthotel.controller;

import com.example.restprojecthotel.service.ReservationService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restprojecthotel.repository.ClientRepository;
import com.example.restprojecthotel.repository.ChambreRepository;
import com.example.restprojecthotel.repository.ReservationRepository;
import stubs.*;

import java.util.UUID;
import java.util.stream.Collectors;


@GrpcService
public class ReservationServiceGrpcImpl extends ReservationServiceGrpc.ReservationServiceImplBase {


    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ChambreRepository chambreRepository;
    @Autowired
    private ReservationRepository reservationRepository;



//
//
//
//            // Populate the Reservation object
//            reservation.setClient(client);
//            reservation.setChambre(chambre);
//            reservation.setDateDebut(reservationReq.getDateDebut());
//            reservation.setDateFin(reservationReq.getDateFin());
//
//            // Save the Reservation
//            var savedReservation = reservationService.createReservation(reservation);
//
//            // Convert the saved entity to gRPC response
//            var grpcReservation = entityToGrpc(savedReservation);
//
//            // Return the response
//            responseObserver.onNext(ReservationResponse.newBuilder()
//                    .setReservation(grpcReservation)
//                    .build());
//            responseObserver.onCompleted();
//
//        } catch (Exception e) {
//            responseObserver.onError(
//                    Status.INTERNAL
//                            .withDescription("Error saving reservation: " + e.getMessage())
//                            .asRuntimeException()
//            );
//        }
//    }


    @Override
    public void createReservation(CreateUpdateReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        try {
            var reservationReq = request.getReservation();

            // Handle Client
            com.example.restprojecthotel.entities.Client client;
            if (reservationReq.getClient().getId() == 0) {
                client = new com.example.restprojecthotel.entities.Client();
                client.setPrenom(reservationReq.getClient().getPrenom());
                client.setNom(reservationReq.getClient().getNom());
                client.setEmail(reservationReq.getClient().getEmail());
                client = clientRepository.save(client); // Save the new client
            } else {
                client = clientRepository.findById(reservationReq.getClient().getId());

            }

            // Handle Chambre
            com.example.restprojecthotel.entities.Chambre chambre;
            if (reservationReq.getChambre().getId() == 0) {
                chambre = new com.example.restprojecthotel.entities.Chambre();
                chambre.setNumero(reservationReq.getChambre().getNumero());
                chambre.setPrix(reservationReq.getChambre().getPrix());
                chambre.setType(mapGrpcToEntityType(reservationReq.getChambre().getType()));
                chambre = chambreRepository.save(chambre); // Save the new chambre
            } else {
                chambre = chambreRepository.findById(reservationReq.getChambre().getId());

            }

            // Create Reservation
            var reservation = new com.example.restprojecthotel.entities.Reservation();
            reservation.setClient(client);
            reservation.setChambre(chambre);
            reservation.setDateDebut(reservationReq.getDateDebut());
            reservation.setDateFin(reservationReq.getDateFin());

            // Save Reservation
            var savedReservation = reservationService.createReservation(reservation);

            // Respond with the saved reservation
            responseObserver.onNext(ReservationResponse.newBuilder()
                    .setReservation(entityToGrpc(savedReservation))
                    .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription("Error saving reservation: " + e.getMessage())
                            .asRuntimeException()
            );
        }
    }


    private com.example.restprojecthotel.entities.TypeChambre mapGrpcToEntityType(TypeChambre grpcType) {
        return com.example.restprojecthotel.entities.TypeChambre.valueOf(grpcType.name());
    }


    @Override
    public void updateReservation(CreateUpdateReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        try {
            // Extract reservation ID from the request
            var id = request.getReservation().getId();

            // Fetch the existing reservation
            var existingReservation = reservationService.getReservationById(id);

            // Update Client if provided
            var clientReq = request.getReservation().getClient();
            if (clientReq.getId() != 0) {
                var client = clientRepository.findById(clientReq.getId()) ;
                existingReservation.setClient(client);
            }

            // Update Chambre if provided
            var chambreReq = request.getReservation().getChambre();
            if (chambreReq.getId() != 0) {
                var chambre = chambreRepository.findById(chambreReq.getId()) ;
                existingReservation.setChambre(chambre);
            }

            // Update reservation details
            if (!request.getReservation().getDateDebut().isEmpty()) {
                existingReservation.setDateDebut(request.getReservation().getDateDebut());
            }
            if (!request.getReservation().getDateFin().isEmpty()) {
                existingReservation.setDateFin(request.getReservation().getDateFin());
            }

            // Save the updated reservation
            var updatedReservation = reservationService.updateReservation(id, existingReservation);

            // Convert to gRPC response
            var grpcResponse = entityToGrpc(updatedReservation);

            // Send the response
            responseObserver.onNext(ReservationResponse.newBuilder()
                    .setReservation(grpcResponse)
                    .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(
                    Status.INTERNAL
                            .withDescription("Error updating reservation: " + e.getMessage())
                            .asRuntimeException()
            );
        }
    }



    private Reservation entityToGrpc(com.example.restprojecthotel.entities.Reservation reservation) {

        var grpcClient = Client.newBuilder()
                .setId(reservation.getClient().getId())
                .setEmail(reservation.getClient().getEmail())
                .setNom(reservation.getClient().getNom())
                .setPrenom(reservation.getClient().getPrenom())
                .build();

        var grpcChambre = Chambre.newBuilder()
                .setId(reservation.getChambre().getId())
                .setNumero(reservation.getChambre().getNumero())
                .setPrix(reservation.getChambre().getPrix())
                .setType(TypeChambre.valueOf(reservation.getChambre().getType().name()))
                .build() ;

        var grpcReservation = Reservation.newBuilder()
                .setId(reservation.getId())
                .setDateDebut(reservation.getDateDebut())
                .setDateFin(reservation.getDateFin())
                .setClient(grpcClient)
                .setChambre(grpcChambre)
                .build();
        return grpcReservation ;
    }
    @Override
    public void getReservation(GetReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        try{
            var reservation = reservationService.getReservationById(request.getId());
            if(reservation != null){

               var grpcReservation = entityToGrpc(reservation);

                responseObserver.onNext(ReservationResponse.newBuilder().setReservation(grpcReservation).build());
            }else {
                responseObserver.onError(new RuntimeException("reservation not found"));
            }

        }catch (Exception e){
            responseObserver.onError(e);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteReservation(DeleteReservationRequest request, StreamObserver<DeleteReservationResponse> responseObserver) {
        try {
            reservationService.deleteReservation(request.getId());
            responseObserver.onNext(DeleteReservationResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("reservation supprimé avec succès")
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(DeleteReservationResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Erreur lors de la suppression: " + e.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void allReservations(GetAllReservationRequest request, StreamObserver<GetAllReservationResponse> responseObserver) {
        var reservations = reservationService.getAllReservations().stream()
                .map(reservation -> entityToGrpc(reservation)).collect(Collectors.toList()) ;

        responseObserver.onNext(GetAllReservationResponse.newBuilder()
                .addAllReservations(reservations).build());
        responseObserver.onCompleted();
    }
}


