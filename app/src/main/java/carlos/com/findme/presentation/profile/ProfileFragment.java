package carlos.com.findme.presentation.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.local.SessionManager;
import carlos.com.findme.data.models.UserEntity;

public class ProfileFragment extends BaseFragment {
    SessionManager mSessionManager;
    Unbinder unbinder;

    @BindView(R.id.tv_nombre)
    TextView tvNombre;
    @BindView(R.id.tv_codigo)
    TextView tvCodigo;
    @BindView(R.id.tv_dni)
    TextView tvDNI;

    @BindView(R.id.tv_telefono)
    TextView tvTelefono;

    private UserEntity mUser;

    public ProfileFragment() {
    }
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();

        return fragment;

    }
    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSessionManager = new SessionManager(getContext());
        mUser=mSessionManager.getUserEntity();
        //Se inicializan datos


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Se coloca el layout y este se administra

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNombre.setText(mUser.getNombres());
        tvCodigo.setText("Codigo: "+mUser.getCodigo());
        tvDNI.setText("DNI: "+mUser.getDni());

        tvTelefono.setText("Telefono: "+mUser.getTelefono());
    }
}
