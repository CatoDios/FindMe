package carlos.com.ticketsapp.presentation.reservacion_nivel;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.ValidarEntity;

/**
 * Created by carlos on 16/06/2018.
 */

public class NivelContract {
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void validarCantidad(ValidarEntity body);
    }
    interface Presenter extends BasePresenter{

        void validarCantidad();
    }
}
