// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: reservation.proto

package com.example.restprojecthotel.stubs;

public final class ReservationOuterClass {
  private ReservationOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_Chambre_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_Chambre_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_Client_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_Client_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_Reservation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_Reservation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_CreateUpdateReservationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_CreateUpdateReservationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_ReservationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_ReservationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_GetReservationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_GetReservationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_DeleteReservationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_DeleteReservationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_DeleteReservationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_DeleteReservationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_GetAllReservationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_GetAllReservationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stubs_GetAllReservationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stubs_GetAllReservationResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021reservation.proto\022\005stubs\"U\n\007Chambre\022\n\n" +
      "\002id\030\001 \001(\005\022\016\n\006numero\030\002 \001(\t\022 \n\004type\030\003 \001(\0162" +
      "\022.stubs.TypeChambre\022\014\n\004prix\030\004 \001(\001\"@\n\006Cli" +
      "ent\022\n\n\002id\030\001 \001(\005\022\013\n\003nom\030\002 \001(\t\022\016\n\006prenom\030\003" +
      " \001(\t\022\r\n\005email\030\004 \001(\t\"}\n\013Reservation\022\n\n\002id" +
      "\030\001 \001(\005\022\035\n\006client\030\002 \001(\0132\r.stubs.Client\022\037\n" +
      "\007chambre\030\003 \001(\0132\016.stubs.Chambre\022\021\n\tdateDe" +
      "but\030\004 \001(\t\022\017\n\007dateFin\030\005 \001(\t\"I\n\036CreateUpda" +
      "teReservationRequest\022\'\n\013reservation\030\001 \001(" +
      "\0132\022.stubs.Reservation\">\n\023ReservationResp" +
      "onse\022\'\n\013reservation\030\001 \001(\0132\022.stubs.Reserv" +
      "ation\"#\n\025GetReservationRequest\022\n\n\002id\030\001 \001" +
      "(\005\"&\n\030DeleteReservationRequest\022\n\n\002id\030\001 \001" +
      "(\005\"=\n\031DeleteReservationResponse\022\017\n\007succe" +
      "ss\030\001 \001(\010\022\017\n\007message\030\002 \001(\t\"\032\n\030GetAllReser" +
      "vationRequest\"E\n\031GetAllReservationRespon" +
      "se\022(\n\014reservations\030\001 \003(\0132\022.stubs.Reserva" +
      "tion*0\n\013TypeChambre\022\n\n\006SIMPLE\020\000\022\n\n\006DOUBL" +
      "E\020\001\022\t\n\005SUITE\020\0022\276\003\n\022ReservationService\022V\n" +
      "\021CreateReservation\022%.stubs.CreateUpdateR" +
      "eservationRequest\032\032.stubs.ReservationRes" +
      "ponse\022V\n\021UpdateReservation\022%.stubs.Creat" +
      "eUpdateReservationRequest\032\032.stubs.Reserv" +
      "ationResponse\022J\n\016GetReservation\022\034.stubs." +
      "GetReservationRequest\032\032.stubs.Reservatio" +
      "nResponse\022V\n\021DeleteReservation\022\037.stubs.D" +
      "eleteReservationRequest\032 .stubs.DeleteRe" +
      "servationResponse\022T\n\017AllReservations\022\037.s" +
      "tubs.GetAllReservationRequest\032 .stubs.Ge" +
      "tAllReservationResponseB\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_stubs_Chambre_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_stubs_Chambre_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_Chambre_descriptor,
        new java.lang.String[] { "Id", "Numero", "Type", "Prix", });
    internal_static_stubs_Client_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_stubs_Client_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_Client_descriptor,
        new java.lang.String[] { "Id", "Nom", "Prenom", "Email", });
    internal_static_stubs_Reservation_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_stubs_Reservation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_Reservation_descriptor,
        new java.lang.String[] { "Id", "Client", "Chambre", "DateDebut", "DateFin", });
    internal_static_stubs_CreateUpdateReservationRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_stubs_CreateUpdateReservationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_CreateUpdateReservationRequest_descriptor,
        new java.lang.String[] { "Reservation", });
    internal_static_stubs_ReservationResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_stubs_ReservationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_ReservationResponse_descriptor,
        new java.lang.String[] { "Reservation", });
    internal_static_stubs_GetReservationRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_stubs_GetReservationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_GetReservationRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_stubs_DeleteReservationRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_stubs_DeleteReservationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_DeleteReservationRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_stubs_DeleteReservationResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_stubs_DeleteReservationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_DeleteReservationResponse_descriptor,
        new java.lang.String[] { "Success", "Message", });
    internal_static_stubs_GetAllReservationRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_stubs_GetAllReservationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_GetAllReservationRequest_descriptor,
        new java.lang.String[] { });
    internal_static_stubs_GetAllReservationResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_stubs_GetAllReservationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stubs_GetAllReservationResponse_descriptor,
        new java.lang.String[] { "Reservations", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
