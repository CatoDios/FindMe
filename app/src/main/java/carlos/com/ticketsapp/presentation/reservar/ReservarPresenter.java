package carlos.com.ticketsapp.presentation.reservar;

import android.content.Context;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.RespuestaNT;
import carlos.com.ticketsapp.data.models.RetornoEntity;
import carlos.com.ticketsapp.data.models.TicketEnvio;
import carlos.com.ticketsapp.data.models.ValidarEntity;
import carlos.com.ticketsapp.data.remote.ServiceFactory;
import carlos.com.ticketsapp.data.remote.request.GetRequest;
import carlos.com.ticketsapp.presentation.reservacion_nivel.NivelContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservarPresenter implements ReservarContract.Presenter {

    SessionManager mSessionManager;
    Context context;
    ReservarContract.View mView;

    public ReservarPresenter(Context context, ReservarContract.View mView) {
        this.context = context;
        this.mView = mView;
        mSessionManager=new SessionManager(this.context);
    }

    @Override

    public void start() {

    }

    @Override
    public void finalizar() {
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);
        TicketEnvio ticketEnvio=new TicketEnvio();
        ticketEnvio.setIdTicket(0);
        ticketEnvio.setNumero(0);
        ticketEnvio.setEstado("RESERVADO");
        ticketEnvio.setIdComida(Integer.valueOf(mSessionManager.getIdComida()));
        ticketEnvio.setIdNt(Integer.valueOf(mSessionManager.getIdNivelturno()));
        ticketEnvio.setIdUsuario(mSessionManager.getUserEntity().idUsuario);
        Call<RetornoEntity> call = postRequest.reservarTicket(ticketEnvio);
        call.enqueue(new Callback<RetornoEntity>() {
            @Override
            public void onResponse(Call<RetornoEntity> call, Response<RetornoEntity> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.reservado(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<RetornoEntity> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.showErrorMessage("Fallo al traer datos, comunicarse con su administrador");
            }
        });
    }

    @Override
    public void getNT() {
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);

        Call<RespuestaNT> call = postRequest.getNT(mSessionManager.getIdComida(),mSessionManager.getNivel(),mSessionManager.getTurno());
        call.enqueue(new Callback<RespuestaNT>() {
            @Override
            public void onResponse(Call<RespuestaNT> call, Response<RespuestaNT> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.ponerNT(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<RespuestaNT> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.showErrorMessage("Fallo al traer datos, comunicarse con su administrador");
            }
        });
    }
}
