package carlos.com.findme.presentation.principal.BottomBar.Hoy;

import java.util.ArrayList;

import carlos.com.findme.core.BasePresenter;
import carlos.com.findme.core.BaseView;
import carlos.com.findme.data.models.ComidaEntity;
import carlos.com.findme.data.models.ValidarEntity;

public class HoyContract {

    interface Presenter extends BasePresenter{

        void getCategorias();
        void validarUser();
    }

    interface View extends BaseView<HoyContract.Presenter>{

        boolean isActive();

        void getMenu(ArrayList<ComidaEntity> body);

        void validarUser(ValidarEntity body);


        void error();
    }
}
