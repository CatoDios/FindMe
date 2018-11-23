package carlos.com.findme.presentation.reportar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.models.desaparicion.Desaparecido;
import carlos.com.findme.presentation.mapa.MapaActivity;

/**
 * Created by kath on 06/04/18.
 */

public class ReportarFragment extends BaseFragment {

    @BindView(R.id.et_nombres)
    TextInputEditText etNombres;
    @BindView(R.id.et_apellidos)
    TextInputEditText etApellidos;
    @BindView(R.id.et_edad)
    TextInputEditText etEdad;
    @BindView(R.id.et_talla)
    TextInputEditText etTalla;
    @BindView(R.id.et_otros)
    EditText etOtros;
    Unbinder unbinder;


    public static ReportarFragment newInstance() {

        ReportarFragment fragment = new ReportarFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_registro, container, false);
        unbinder = ButterKnife.bind(this, root);

        return root;
    }


    @OnClick(R.id.btn_seguir)
    public void onClick(View view){
        Bundle arg= new Bundle();
        arg.putString("nombres",etNombres.getText().toString());
        arg.putString("apellidos",etApellidos.getText().toString());
        arg.putInt("edad",Integer.parseInt(etEdad.getText().toString()));
        arg.putFloat("talla",Float.parseFloat(etTalla.getText().toString()));
        arg.putString("otros",etOtros.getText().toString());
        nextActivity(getActivity(),arg,MapaActivity.class,false);

    }





}
