package carlos.com.findme.presentation.tipo;

import carlos.com.findme.core.BasePresenter;
import carlos.com.findme.core.BaseView;
import carlos.com.findme.data.models.ValidarEntity;

public class TipoContract {
    interface Presenter extends BasePresenter{

        void validar();
    }
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void validarUser(ValidarEntity body);
    }
}
