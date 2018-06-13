package carlos.com.ticketsapp.presentation.reservar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;
import carlos.com.ticketsapp.data.local.SessionManager;
import carlos.com.ticketsapp.presentation.reservacion_nivel.NivelFragment;

/**
 * Created by carlos on 12/06/2018.
 */

public class ReservarFragment extends BaseFragment {
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.id_user)
    TextView id_user;
    @BindView(R.id.turno)
    TextView turno;
    @BindView(R.id.comida)
    TextView comida;
    @BindView(R.id.nivel)
    TextView nivel;
    Unbinder unbinder;
    SessionManager mSessionManager;
    public static ReservarFragment newInstance(){
        return new ReservarFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager=new SessionManager(getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_reservar,container,false);
        unbinder= ButterKnife.bind(this,root);
        return  root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre.setText(mSessionManager.getUserEntity().getNombres()+" "+mSessionManager.getUserEntity().getApePat());
        id_user.setText(String.valueOf(mSessionManager.getUserEntity().getIdUsuario()));
        comida.setText(mSessionManager.getIdComida());
        turno.setText(mSessionManager.getIdNivelturno());


    }
}
