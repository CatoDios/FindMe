package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

import java.util.ArrayList;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.ComidaEntity;
import carlos.com.ticketsapp.data.models.SemanaResponse;
import carlos.com.ticketsapp.data.models.Semana_card;

public class SemanaContract  {
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void getMenuSemana(SemanaResponse body);

        void clickItemCategorias(Semana_card comidaEntity);

        void error();
    }
    interface Presenter extends BasePresenter{

        void getMenu();
    }
}
