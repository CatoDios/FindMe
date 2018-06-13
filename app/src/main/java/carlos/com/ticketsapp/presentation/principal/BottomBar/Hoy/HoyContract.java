package carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy;

import java.util.ArrayList;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.MenuEntity;

public class HoyContract {

    interface Presenter extends BasePresenter{

        void getCategorias();
    }

    interface View extends BaseView<HoyContract.Presenter>{

        boolean isActive();

        void getMenu(ArrayList<ComidaEntity> body);
    }
}
