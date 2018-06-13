package carlos.com.ticketsapp.data.remote.request;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.FaltaEntity;
import carlos.com.ticketsapp.data.models.MenuEntity;
import carlos.com.ticketsapp.data.models.SemanaResponse;
import carlos.com.ticketsapp.data.models.UserEntity;
import retrofit2.Call;
import retrofit2.http.GET;
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
}
