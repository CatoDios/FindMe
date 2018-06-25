package carlos.com.ticketsapp.presentation.estado;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.CancelarResponse;
import carlos.com.ticketsapp.data.models.EstadoEntity;
import carlos.com.ticketsapp.data.models.RetornoEntity;

public class EstadoContract {
    interface Presenter extends BasePresenter{

        void traerEstado();

        void cancelarTicket(String idTicket);
    }
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void verEstado(EstadoEntity body);

        void cancelarTicket(CancelarResponse body);
    }
}
