package carlos.com.findme.presentation.reportar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

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

public class ReportarFragment extends BaseFragment  implements Validator.ValidationListener {

    @NotEmpty(message="Campo vacío")
    @BindView(R.id.et_nombres)
    TextInputEditText etNombres;
    @NotEmpty(message="Campo vacío")
    @BindView(R.id.et_apellidos)
    TextInputEditText etApellidos;
    @NotEmpty(message="Campo vacío")
    @BindView(R.id.et_edad)
    TextInputEditText etEdad;
    @BindView(R.id.et_talla)
    @NotEmpty(message="Campo vacío")
    TextInputEditText etTalla;
    @NotEmpty(message="Campo vacío")
    @BindView(R.id.et_otros)
    EditText etOtros;
    Unbinder unbinder;

    private Validator validator;


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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        validator=new Validator(this);
        validator.setValidationListener(this);
    }

    @OnClick(R.id.btn_seguir)
    public void onClick(View view){
        validator.validate();


    }


    @Override
    public void onValidationSucceeded() {
        Bundle arg= new Bundle();
        arg.putString("nombres",etNombres.getText().toString());
        arg.putString("apellidos",etApellidos.getText().toString());
        arg.putInt("edad",Integer.parseInt(etEdad.getText().toString()));
        arg.putFloat("talla",Float.parseFloat(etTalla.getText().toString()));
        arg.putString("otros",etOtros.getText().toString());
        nextActivity(getActivity(),arg,MapaActivity.class,false);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(), "Por favor ingrese lo campos correctamente", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
