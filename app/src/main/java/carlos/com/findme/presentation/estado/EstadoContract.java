package carlos.com.findme.presentation.estado;

import carlos.com.findme.core.BasePresenter;
import carlos.com.findme.core.BaseView;
import carlos.com.findme.data.models.CancelarResponse;
import carlos.com.findme.data.models.EstadoEntity;

public class EstadoContract {
    interface Presenter extends BasePresenter{

        void traerEstado();

        void cancelarTicket(String idTicket);
    }
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void verEstado(EstadoEntity body);

        void cancelarTicket(CancelarResponse body);

        void error();
    }
}
