package carlos.com.ticketsapp.presentation.estado;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.data.models.CancelarResponse;
import carlos.com.ticketsapp.data.models.EstadoEntity;
import carlos.com.ticketsapp.presentation.principal.PrincipalActivity;

public class EstadoFragment extends BaseFragment implements EstadoContract.View{
    @BindView(R.id.cancelar)
    Button cancelar;
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.comida)
    TextView comida;
    @BindView(R.id.turno)
    TextView turno;
    @BindView(R.id.nivel)
    TextView nivel;
    @BindView(R.id.cuerpo)
    RelativeLayout cuerpo;
    ProgressBar progressBar;

    @BindView(R.id.hora_inicio)
    TextView hora_inicio;
    @BindView(R.id.hora_fin)
    TextView hora_fin;
    Unbinder unbinder;
    EstadoContract.Presenter mPresenter;
    SessionManager mSessionManager;
    String idTicket;

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.traerEstado();
    }

    public static EstadoFragment newInstance(){
        return new EstadoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new EstadoPresenter(this,getContext());
        mSessionManager=new SessionManager(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_estado,container,false);
        unbinder= ButterKnife.bind(this,root);
        return root;
    }

    @Override
    public void setPresenter(EstadoContract.Presenter presenter) {

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
    public void verEstado(EstadoEntity body) {
        progressBar.setVisibility(View.GONE);
        cuerpo.setVisibility(View.VISIBLE);

        nombre.setText(mSessionManager.getUserEntity().getNombres()+" "+mSessionManager.getUserEntity().getApePat()+" "+mSessionManager.getUserEntity().getApeMat());
        comida.setText(body.getNombre());
        nivel.setText(String.valueOf(body.getNivel()));
        turno.setText(String.valueOf(body.getTurno()));
        hora_fin.setText(body.getHoraFin());
        hora_inicio.setText(body.getHoraInicio());
        idTicket=body.getIdTicket();

        mSessionManager.setIdNivelTurno("");
    }

    @Override
    public void cancelarTicket(CancelarResponse body) {
        Toast.makeText(getContext(), body.getMensaje(), Toast.LENGTH_SHORT).show();
        newActivityClearPreview(getActivity(),null,PrincipalActivity.class);
    }

    @OnClick(R.id.cancelar)
    public void onclick(View view){
        mPresenter.cancelarTicket(idTicket);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = new ProgressBar(getContext(),null,android.R.attr.progressBarStyleLarge);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100,100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        RelativeLayout layout = getActivity().findViewById(R.id.root);
        layout.addView(progressBar,params);
        progressBar.setVisibility(View.VISIBLE);  //To show ProgressBar
        cuerpo.setVisibility(View.GONE);
    }
}
