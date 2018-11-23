package carlos.com.findme.presentation.reportar2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.data.models.desaparicion.ServicioDesaparecido;
import carlos.com.findme.presentation.principal.PrincipalActivity;
import io.realm.Realm;

/**
 * Created by carlos on 12/06/2018.
 */

public class ReservacionFragment extends BaseFragment {


    SessionManager mSessionManager;
    Unbinder unbinder;
    @BindView(R.id.et_hora)
    TextInputEditText etHora;
    @BindView(R.id.et_fecha)
    TextInputEditText etFecha;

    public static ReservacionFragment newInstance() {
        return new ReservacionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager = new SessionManager(getContext());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_turno, container, false);
        unbinder = ButterKnife.bind(this, root);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }


    @OnClick(R.id.btn_seguir)
    public void onViewClicked() {
        Bundle args=new Bundle();
        args=getArguments();
        ServicioDesaparecido servicioDesaparecido=new ServicioDesaparecido(Realm.getDefaultInstance());
        servicioDesaparecido.newDesaparecido(1,
                args.getString("nombres"),
                args.getString("apellidos"),
                args.getInt("edad"),
                args.getFloat("talla"),
                "negro",
                "blanco",args.getString("otros"),etFecha.getText().toString(),etHora.getText().toString(),
                args.getDouble("latitud"),
                args.getDouble("longitud"));
        nextActivity(getActivity(),null, PrincipalActivity.class,true);

    }
}
