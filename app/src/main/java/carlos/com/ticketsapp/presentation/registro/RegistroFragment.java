package carlos.com.ticketsapp.presentation.registro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseFragment;

/**
 * Created by kath on 06/04/18.
 */

public class RegistroFragment extends BaseFragment {

    Unbinder unbinder;

    public static RegistroFragment newInstance() {
        return new RegistroFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_registro, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }
}
