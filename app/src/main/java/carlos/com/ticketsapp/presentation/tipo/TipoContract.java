package carlos.com.ticketsapp.presentation.tipo;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.ValidarEntity;

public class TipoContract {
    interface Presenter extends BasePresenter{

        void validar();
    }
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void validarUser(ValidarEntity body);
    }
}
