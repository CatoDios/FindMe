package carlos.com.ticketsapp.presentation.reservar;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.RespuestaNT;
import carlos.com.ticketsapp.data.models.RetornoEntity;

public class ReservarContract {
    interface Presenter extends BasePresenter{

        void finalizar();

        void getNT();

        void finalizarCola();
    }
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void reservado(RetornoEntity body);

        void ponerNT(RespuestaNT body);

        void reservadoCola(RetornoEntity body);
    }
}
