package carlos.com.ticketsapp.presentation.reservacion_nivel;

import android.content.Context;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.ValidarEntity;
import carlos.com.ticketsapp.data.remote.ServiceFactory;
import carlos.com.ticketsapp.data.remote.request.GetRequest;
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
}
