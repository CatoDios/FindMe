package carlos.com.findme.presentation.tipo;

import android.content.Context;

import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.data.models.ValidarEntity;
import carlos.com.findme.data.remote.ServiceFactory;
import carlos.com.findme.data.remote.request.GetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TipoPresenter implements TipoContract.Presenter {
    SessionManager mSessionManager;

    Context context;
    TipoContract.View mView;

    public TipoPresenter(Context context, TipoContract.View mView) {
        this.context = context;
        this.mView = mView;
        this.mSessionManager = new SessionManager(this.context);
    }


    @Override
    public void start() {

    }

    @Override
    public void validar() {
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);
        Call<ValidarEntity> call = postRequest.validarUser(String.valueOf(mSessionManager.getUserEntity().getIdUsuario()),mSessionManager.getIdComida());
        call.enqueue(new Callback<ValidarEntity>() {
            @Override
            public void onResponse(Call<ValidarEntity> call, Response<ValidarEntity> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.validarUser(response.body());
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
