package carlos.com.findme.presentation.seguimiento;

import carlos.com.findme.core.BasePresenter;
import carlos.com.findme.core.BaseView;
import carlos.com.findme.data.models.RespuestaNT;
import carlos.com.findme.data.models.ValidarEntity;

/**
 * Created by carlos on 16/06/2018.
 */

public class NivelContract {
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void validarCantidad(ValidarEntity body);

        void ponerNT(RespuestaNT body);
    }
    interface Presenter extends BasePresenter{

        void validarCantidad();

        void getNT();
    }
}
