package carlos.com.findme.presentation.seguimientos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.models.desaparicion.Desaparecido;
import carlos.com.findme.data.models.desaparicion.ServicioDesaparecido;
import carlos.com.findme.presentation.seguimiento.NivelActivity;
import io.realm.Realm;

public class SeguimientosFragment extends BaseFragment implements ItemSeguimientos{
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private Unbinder unbinder;
    private LinearLayoutManager mLayoutManager;
    private SeguimientosAdapter mAdapter;

    public static SeguimientosFragment newInstance() {

        Bundle args = new Bundle();

        SeguimientosFragment fragment = new SeguimientosFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_seguimientos, container, false);
        unbinder = ButterKnife.bind(this, root);

        return root;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ServicioDesaparecido servicioDesaparecido= new ServicioDesaparecido(Realm.getDefaultInstance());
        ArrayList<Desaparecido> desaparecidos = servicioDesaparecido.getDesaparecidos();
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAdapter = new SeguimientosAdapter(desaparecidos, getContext(),this);
        rvList.setLayoutManager(mLayoutManager);
        rvList.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void clickItem(Desaparecido desaparecido) {
        Bundle arg=new Bundle();
        arg.putString("nombres",desaparecido.getNombres());
        arg.putString("apellidos",desaparecido.getApellidos());
        arg.putString("color_cabello",desaparecido.getColor_cabello());
        arg.putString("color_piel",desaparecido.getColor_piel());
        arg.putInt("edad",desaparecido.getEdad());
        arg.putFloat("talla",desaparecido.getTalla());
        arg.putInt("pk",desaparecido.getPk());
        arg.putString("fecha",desaparecido.getFecha());
        arg.putString("hora",desaparecido.getHora());
        arg.putString("otros",desaparecido.getOtros());
        arg.putDouble("latitud",desaparecido.getLatitud());
        arg.putDouble("longitud",desaparecido.getLongitud());
        nextActivity(getActivity(),arg, NivelActivity.class,false);
    }
}
