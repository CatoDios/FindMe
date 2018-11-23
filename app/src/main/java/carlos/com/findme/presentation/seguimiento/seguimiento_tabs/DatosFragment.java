package carlos.com.findme.presentation.seguimiento.seguimiento_tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;

public class DatosFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.et_nombres)
    TextInputEditText etNombres;
    @BindView(R.id.et_apellidos)
    TextInputEditText etApellidos;
    @BindView(R.id.tv_edad)
    TextInputEditText tvEdad;
    @BindView(R.id.et_caracteristicas)
    TextInputEditText etCaracteristicas;

    public static DatosFragment newInstance() {

        Bundle args = new Bundle();

        DatosFragment fragment = new DatosFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_datos, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arg = getActivity().getIntent().getExtras();
        etNombres.setText(arg.getString("nombres"));
        etApellidos.setText(arg.getString("apellidos"));
        tvEdad.setText(String.valueOf(arg.getInt("edad")));
        etCaracteristicas.setText(arg.getString("otros"));
    }


}
