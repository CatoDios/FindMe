package carlos.com.ticketsapp.presentation.principal.BottomBar.Historial;

import android.content.Context;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.FaltaEntity;
import carlos.com.ticketsapp.data.remote.ServiceFactory;
import carlos.com.ticketsapp.data.remote.request.GetRequest;
import carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy.HoyContract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by carlos on 12/06/2018.
 */

public class HistorialPresenter implements HistorialContract.Presenter {
    private HistorialContract.View mView;
    private Context context;
    private SessionManager mSessionManager;

    @Override
    public void start() {

    }
    public HistorialPresenter(HistorialContract.View mView, Context context) {
        this.context =context;
        this.mView = mView;
        this.mView.setPresenter(this);
        this.mSessionManager = new SessionManager(this.context);
    }

    public void getFaltas(){
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);
        Call<ArrayList<FaltaEntity>> call = postRequest.getFaltas(String.valueOf(mSessionManager.getUserEntity().getIdUsuario()));
        call.enqueue(new Callback<ArrayList<FaltaEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<FaltaEntity>> call, Response<ArrayList<FaltaEntity>> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.getFaltas(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FaltaEntity>> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.error();
            }
        });
    }

}
