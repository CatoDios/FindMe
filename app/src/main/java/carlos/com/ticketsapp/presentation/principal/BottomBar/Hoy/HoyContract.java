package carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy;

import java.util.ArrayList;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.MenuEntity;
import carlos.com.ticketsapp.data.models.ValidarEntity;

public class HoyContract {

    interface Presenter extends BasePresenter{

        void getCategorias();
        void validarUser();
    }

    interface View extends BaseView<HoyContract.Presenter>{

        boolean isActive();

        void getMenu(ArrayList<ComidaEntity> body);

        void validarUser(ValidarEntity body);


    }
}
