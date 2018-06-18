package carlos.com.ticketsapp.presentation.tipo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.ValidarEntity;
import carlos.com.ticketsapp.presentation.mapa.MapaActivity;

public class TipoFragment extends BaseFragment  implements TipoContract.View{

    Unbinder unbinder;
TipoContract.Presenter mPresenter;
    SessionManager mSessionManager;
    String desayuno;
    String almuerzo;
    String cena;


    public static TipoFragment newInstance(){
        return new TipoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager=new SessionManager(getContext());
        mPresenter=new TipoPresenter(getContext(),this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_tipo,container,false);
        unbinder= ButterKnife.bind(this,root);
        desayuno=getArguments().getString("desayuno");
        almuerzo=getArguments().getString("almuerzo");
        cena=getArguments().getString("cena");
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @OnClick({R.id.desayuno,R.id.almuerzo,R.id.cena})
    public void onclicked(View view){

        switch (view.getId()){
            case R.id.desayuno:


                mSessionManager.setIdComida(desayuno);
                mPresenter.validar();

                break;
            case R.id.almuerzo:

                mSessionManager.setIdComida(almuerzo);
                mPresenter.validar();
                break;
            case R.id.cena:

                mSessionManager.setIdComida(cena);
                mPresenter.validar();
                break;
        }
    }

    @Override
    public void setPresenter(TipoContract.Presenter presenter) {

    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void validarUser(ValidarEntity body) {
            if(body.getEstado()==0){
                Toast.makeText(getContext(), body.getMensaje(), Toast.LENGTH_SHORT).show();
                nextActivity(getActivity(),null,MapaActivity.class,false);

            }else{
                nextActivity(getActivity(),null,MapaActivity.class,false);
            }
    }
}
