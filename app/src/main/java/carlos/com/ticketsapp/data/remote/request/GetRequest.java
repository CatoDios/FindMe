package carlos.com.ticketsapp.data.remote.request;

import carlos.com.ticketsapp.data.models.UserEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetRequest {
    @GET("tick-app-client/usuario/leer/{correo}/{contra}")
    Call<UserEntity>getUser(@Path("correo") String correo,@Path("contra")String contra);
}
