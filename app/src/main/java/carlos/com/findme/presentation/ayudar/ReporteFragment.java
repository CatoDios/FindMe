package carlos.com.findme.presentation.ayudar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import carlos.com.findme.R;
import carlos.com.findme.core.BaseFragment;

public class ReporteFragment extends BaseFragment {
    private Unbinder unbinder;

    public static ReporteFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ReporteFragment fragment = new ReporteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_reporte, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }
}
