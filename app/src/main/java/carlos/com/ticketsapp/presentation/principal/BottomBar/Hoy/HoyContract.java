package carlos.com.ticketsapp.presentation.principal.BottomBar.Hoy;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.MenuEntity;

public class HoyContract {

    interface Presenter extends BasePresenter{

    }

    interface View extends BaseView<HoyContract.Presenter>{

        boolean isActive();

        void getMenu(MenuEntity body);
    }
}
