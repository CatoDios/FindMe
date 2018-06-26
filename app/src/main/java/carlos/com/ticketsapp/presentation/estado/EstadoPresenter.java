package carlos.com.ticketsapp.presentation.estado;

import android.content.Context;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.CancelarRequest;
import carlos.com.ticketsapp.data.models.CancelarResponse;
import carlos.com.ticketsapp.data.models.EstadoEntity;
import carlos.com.ticketsapp.data.models.RetornoEntity;
import carlos.com.ticketsapp.data.models.TicketEnvio;
import carlos.com.ticketsapp.data.remote.ServiceFactory;
import carlos.com.ticketsapp.data.remote.request.GetRequest;
import carlos.com.ticketsapp.presentation.auth.LoginContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EstadoPresenter implements EstadoContract.Presenter {
    SessionManager mSessionManager;
    private  EstadoContract.View mView;
    private Context context;

    public EstadoPresenter(EstadoContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        this.mView.setPresenter(this);
        mSessionManager=new SessionManager(context);
    }
    @Override
    public void start() {

    }

    @Override
    public void traerEstado() {
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);

        Call<EstadoEntity> call = postRequest.verEstado(mSessionManager.getUserEntity().getIdUsuario());
        call.enqueue(new Callback<EstadoEntity>() {
            @Override
            public void onResponse(Call<EstadoEntity> call, Response<EstadoEntity> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.verEstado(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<EstadoEntity> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.error();
            }
        });
    }

    @Override
    public void cancelarTicket(String idTicket) {
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);
         CancelarRequest cancelarRequest=new CancelarRequest();
         cancelarRequest.setIdTicket(Integer.valueOf(idTicket));
         cancelarRequest.setNumero(9);
         cancelarRequest.setEstado("RESERVADO");
         cancelarRequest.setIdComida(90);
         cancelarRequest.setIdNt(357);
         cancelarRequest.setIdUsuario(1);


        Call<CancelarResponse> call = postRequest.cancelarTicket(cancelarRequest);
        call.enqueue(new Callback<CancelarResponse>() {
            @Override
            public void onResponse(Call<CancelarResponse> call, Response<CancelarResponse> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.cancelarTicket(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<CancelarResponse> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.showErrorMessage("Fallo al traer datos, comunicarse con su administrador");
            }
        });
    }
}
