package carlos.com.ticketsapp.data.remote.request;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.models.CancelarRequest;
import carlos.com.ticketsapp.data.models.CancelarResponse;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.EstadoEntity;
import carlos.com.ticketsapp.data.models.FaltaEntity;
import carlos.com.ticketsapp.data.models.MenuEntity;
import carlos.com.ticketsapp.data.models.RespuestaNT;
import carlos.com.ticketsapp.data.models.RetornoEntity;
import carlos.com.ticketsapp.data.models.SemanaResponse;
import carlos.com.ticketsapp.data.models.TicketEnvio;
import carlos.com.ticketsapp.data.models.UserEntity;
import carlos.com.ticketsapp.data.models.ValidarEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GetRequest {
    @GET("tick-app-jdbc-client/usuario/leer/{correo}/{contra}")
    Call<UserEntity>getUser(@Path("correo") String correo,@Path("contra")String contra);

    @GET("tick-app-jdbc-client/comida/hoy")
    Call<ArrayList<ComidaEntity>>getMenuHoy();

    @GET("tick-app-jdbc-client/comida/listar/semanal/android")
    Call<SemanaResponse> getMenuSemana();
    @GET("tick-app-jdbc-client/usuario/aplicarsancion/sancion/listar/{id_user}")
    Call<ArrayList<FaltaEntity>>getFaltas(@Path("id_user") String user);
    @GET("tick-app-jdbc-client/ticket/validar/reserva/{id_user}/{id_comida}")
    Call<ValidarEntity> validarUser(@Path("id_user") String user, @Path("id_comida") String comida);

    @GET("tick-app-jdbc-client/ticket/validar/cantidad/{id_comida}/{id_nivelTurno}")
    Call<ValidarEntity> validarCantidad(@Path("id_comida") String id_comida, @Path("id_nivelTurno") String nivelTurno);
    @GET("tick-app-jdbc-client/ticket/nivelturno/comida/listar/{id_usuario}")
    Call<EstadoEntity> verEstado(@Path("id_usuario") int id_usuario);
    @PUT("tick-app-jdbc-client/ticket/cancelar")
    Call<CancelarResponse> cancelarTicket(@Body CancelarRequest cancelarRequest);
    @GET("tick-app-jdbc-client/nivelturno/listar/{id_comida}/{nivel}/{turno}")
    Call<RespuestaNT> getNT(@Path("id_comida") String id_comida, @Path("nivel") String nivel, @Path("turno") String turno);


    @POST("tick-app-jdbc-client/ticket/add/cola")
    Call<RetornoEntity> reservarColaTicket(@Body TicketEnvio ticketEnvio);
    @POST("tick-app-jdbc-client/ticket/add")
    Call<RetornoEntity> reservarTicket(@Body TicketEnvio ticketEnvio);

}

