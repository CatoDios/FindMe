package carlos.com.findme.presentation.seguimiento;

import android.content.Context;

import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.data.models.RespuestaNT;
import carlos.com.findme.data.models.ValidarEntity;
import carlos.com.findme.data.remote.ServiceFactory;
import carlos.com.findme.data.remote.request.GetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by carlos on 16/06/2018.
 */

public class NivelPresenter implements NivelContract.Presenter {
    SessionManager mSessionManager;

    Context context;
    NivelContract.View mView;

    public NivelPresenter(Context context, NivelContract.View mView) {
        this.context = context;
        this.mView = mView;
        this.mSessionManager = new SessionManager(this.context);
    }

    @Override
    public void start() {

    }



    public void validarCantidad(){
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);
        Call<ValidarEntity> call = postRequest.validarCantidad(mSessionManager.getIdComida(),mSessionManager.getIdNivelturno());
        call.enqueue(new Callback<ValidarEntity>() {
            @Override
            public void onResponse(Call<ValidarEntity> call, Response<ValidarEntity> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.validarCantidad(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<ValidarEntity> call, Throwable t) {
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
