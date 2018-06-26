package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

import android.content.Context;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.SemanaResponse;
import carlos.com.ticketsapp.data.models.Semana_card;
import carlos.com.ticketsapp.data.remote.ServiceFactory;
import carlos.com.ticketsapp.data.remote.request.GetRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SemanaPresenter implements SemanaContract.Presenter,ItemSemana {

    private SemanaContract.View mView;
    private Context context;

    public SemanaPresenter(SemanaContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void getMenu() {
        GetRequest postRequest =
                ServiceFactory.createService(GetRequest.class);
        Call<SemanaResponse> call = postRequest.getMenuSemana();
        call.enqueue(new Callback<SemanaResponse>() {
            @Override
            public void onResponse(Call<SemanaResponse> call, Response<SemanaResponse> response) {
                if (!mView.isActive()) {
                    return;
                }

                if (response.isSuccessful()) {
                    mView.getMenuSemana(response.body());
                    // mView.showMessage("noticias obtenidas");
                    //openSession(token, response.body());

                } else {
                    mView.setLoadingIndicator(false);
                    mView.showErrorMessage("Ocurrió un error al obtener las noticias");
                }
            }

            @Override
            public void onFailure(Call<SemanaResponse> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.error();
            }
        });
    }

    @Override
    public void clickItem(Semana_card comidaEntity) {
        mView.clickItemCategorias(comidaEntity);
    }

    @Override
    public void deleteItem(Semana_card comidaEntity, int position) {

    }
}
