package carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy;

import android.content.Context;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.MenuEntity;
import carlos.com.ticketsapp.data.models.ValidarEntity;
import carlos.com.ticketsapp.data.remote.ServiceFactory;
import carlos.com.ticketsapp.data.remote.request.GetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HoyPresenter implements HoyContract.Presenter{

    private HoyContract.View mView;
    private Context context;
    private SessionManager mSessionManager;

    @Override
    public void start() {

    }
    public HoyPresenter(HoyContract.View mView, Context context) {
        this.context =context;
        this.mView = mView;
        this.mView.setPresenter(this);
        this.mSessionManager = new SessionManager(this.context);
    }

    public void getCategorias(){
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);
        Call<ArrayList<ComidaEntity>> call = postRequest.getMenuHoy();
        call.enqueue(new Callback<ArrayList<ComidaEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<ComidaEntity>> call, Response<ArrayList<ComidaEntity>> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.getMenu(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ComidaEntity>> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.showErrorMessage("Fallo al traer datos, comunicarse con su administrador");
            }
        });
    }
    public void validarUser(){
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
