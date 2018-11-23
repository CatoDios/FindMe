package carlos.com.findme.presentation.seguimiento.seguimiento_tabs;

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

public class FechaFragment extends BaseFragment {
    @BindView(R.id.tv_fecha)
    TextView tvFecha;
    @BindView(R.id.tv_hora)
    TextView tvHora;
    private Unbinder unbinder;

    public static FechaFragment newInstance() {

        Bundle args = new Bundle();

        FechaFragment fragment = new FechaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_fecha, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arg = getActivity().getIntent().getExtras();
        tvFecha.setText(arg.getString("fecha"));
        tvHora.setText(arg.getString("hora"));

    }

}
