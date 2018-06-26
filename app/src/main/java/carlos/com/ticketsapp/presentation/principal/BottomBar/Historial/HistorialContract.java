package carlos.com.ticketsapp.presentation.principal.BottomBar.Historial;

import java.util.ArrayList;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.FaltaEntity;

/**
 * Created by carlos on 12/06/2018.
 */

public class HistorialContract {
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void getFaltas(ArrayList<FaltaEntity> body);

        void error();
    }
    interface Presenter extends BasePresenter {
        void getFaltas();
    }
}
