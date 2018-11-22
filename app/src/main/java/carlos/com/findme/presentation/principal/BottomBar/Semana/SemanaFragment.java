package carlos.com.findme.presentation.principal.BottomBar.Semana;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseActivity;
import carlos.com.findme.core.BaseFragment;
import carlos.com.findme.data.models.SemanaResponse;
import carlos.com.findme.data.models.Semana_card;
import carlos.com.findme.utils.ProgressDialogCustom;

public class SemanaFragment extends BaseFragment implements SemanaContract.View{

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.error)
    RelativeLayout error;

    @BindView(R.id.cuerpo)
    RelativeLayout cuerpo;
    ProgressBar progressBar;
    private LinearLayoutManager mLayoutManager;

    Unbinder unbinder;
    private SemanaContract.Presenter mPresenter;
    private SemanaAdapter mAdapter;
    private ProgressDialogCustom mProgressDialogCustom;

    public static SemanaFragment newInstance() {
        return new SemanaFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=new SemanaPresenter(this,getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Obteniendo datos...");
        progressBar = new ProgressBar(getContext(),null,android.R.attr.progressBarStyleLarge);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100,100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        RelativeLayout layout = getActivity().findViewById(R.id.root);
        layout.addView(progressBar,params);
        progressBar.setVisibility(View.VISIBLE);  //To show ProgressBar
        cuerpo.setVisibility(View.GONE);
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mAdapter = new SemanaAdapter(new ArrayList<Semana_card>(), getContext(),(ItemSemana) mPresenter);
        rvList.setLayoutManager(mLayoutManager);
        rvList.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {

        super.onResume();
        mPresenter.getMenu();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_semana, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void setPresenter(SemanaContract.Presenter presenter) {

    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (getView() == null) {
            return;
        }


        if (active) {
            mProgressDialogCustom.show();
        } else {
            if (mProgressDialogCustom.isShowing()) {
                mProgressDialogCustom.dismiss();
            }
        }


    }

    @Override
    public void showMessage(String message) {
        ((BaseActivity) getActivity()).showMessage(message);
    }

    @Override
    public void showErrorMessage(String message) {
        ((BaseActivity) getActivity()).showMessageError(message);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void getMenuSemana(SemanaResponse body) {


        progressBar.setVisibility(View.GONE);
        cuerpo.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);
        ArrayList<Semana_card> semana= new ArrayList<>();
        Semana_card lunes=new Semana_card();
        lunes.setDia("LUNES");
        lunes.setDesayuno(body.getLunes().get(0).getNombre());
        lunes.setAlmuerzo(body.getLunes().get(1).getNombre());
        lunes.setCena(body.getLunes().get(2).getNombre());

        Semana_card martes=new Semana_card();
        martes.setDia("MARTES");
        martes.setDesayuno(body.getMartes().get(0).getNombre());
        martes.setAlmuerzo(body.getMartes().get(1).getNombre());
        martes.setCena(body.getMartes().get(2).getNombre());

        Semana_card miercoles=new Semana_card();
        miercoles.setDia("MIERCOLES");
        miercoles.setDesayuno(body.getMiercoles().get(0).getNombre());
        miercoles.setAlmuerzo(body.getMiercoles().get(1).getNombre());
        miercoles.setCena(body.getMiercoles().get(2).getNombre());

        Semana_card jueves=new Semana_card();
        jueves.setDia("JUEVES");
        jueves.setDesayuno(body.getJueves().get(0).getNombre());
        jueves.setAlmuerzo(body.getJueves().get(1).getNombre());
        jueves.setCena(body.getJueves().get(2).getNombre());

        Semana_card viernes=new Semana_card();
        viernes.setDia("VIERNES");
        viernes.setDesayuno(body.getViernes().get(0).getNombre());
        viernes.setAlmuerzo(body.getViernes().get(1).getNombre());
        viernes.setCena(body.getViernes().get(2).getNombre());

        Semana_card sabado=new Semana_card();
        sabado.setDia("SABADO");
        sabado.setDesayuno(body.getSabado().get(0).getNombre());
        sabado.setAlmuerzo(body.getSabado().get(1).getNombre());
        sabado.setCena(body.getSabado().get(2).getNombre());

        Semana_card domingo=new Semana_card();
        domingo.setDia("DOMINGO");
        domingo.setDesayuno(body.getDomingo().get(0).getNombre());
        domingo.setAlmuerzo(body.getDomingo().get(1).getNombre());
        domingo.setCena(body.getDomingo().get(2).getNombre());

        semana.add(lunes);
        semana.add(martes);
        semana.add(miercoles);
        semana.add(jueves);
        semana.add(viernes);
        semana.add(sabado);
        semana.add(domingo);

        mAdapter.setItems(semana);


    }

    @Override
    public void clickItemCategorias(Semana_card comidaEntity) {
        //nextActivity(getActivity(),null, DetallesActivity.class,false);
    }

    @Override
    public void error() {
        progressBar.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
    }
}
