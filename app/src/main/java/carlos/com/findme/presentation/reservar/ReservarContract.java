package carlos.com.findme.presentation.reservar;

import carlos.com.findme.core.BasePresenter;
import carlos.com.findme.core.BaseView;
import carlos.com.findme.data.models.RespuestaNT;
import carlos.com.findme.data.models.RetornoEntity;

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
