package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

import android.content.Context;

import java.util.ArrayList;

import carlos.com.ticketsapp.data.models.ComidaEntity;
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
        Call<ArrayList<ComidaEntity>> call = postRequest.getMenuSemana();
        call.enqueue(new Callback<ArrayList<ComidaEntity>>() {
            @Override
            public void onResponse(Call<ArrayList<ComidaEntity>> call, Response<ArrayList<ComidaEntity>> response) {
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
            public void onFailure(Call<ArrayList<ComidaEntity>> call, Throwable t) {
                if (!mView.isActive()) {
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.showErrorMessage("Fallo al traer datos, comunicarse con su administrador");
            }
        });
    }

    @Override
    public void clickItem(ComidaEntity comidaEntity) {
        mView.clickItemCategorias(comidaEntity);
    }

    @Override
    public void deleteItem(ComidaEntity comidaEntity, int position) {

    }
}
