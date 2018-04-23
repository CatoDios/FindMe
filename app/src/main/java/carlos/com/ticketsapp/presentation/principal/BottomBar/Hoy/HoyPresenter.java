package carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy;

import android.content.Context;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.MenuEntity;
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
        Call<MenuEntity> call = postRequest.getMenuHoy();
        call.enqueue(new Callback<MenuEntity>() {
            @Override
            public void onResponse(Call<MenuEntity> call, Response<MenuEntity> response) {
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
            public void onFailure(Call<MenuEntity> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.showErrorMessage("Fallo al traer datos, comunicarse con su administrador");
            }
        });
    }


}
