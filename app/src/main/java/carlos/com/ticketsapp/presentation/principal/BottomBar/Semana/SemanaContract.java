package carlos.com.ticketsapp.presentation.principal.BottomBar.Semana;

import java.util.ArrayList;

import carlos.com.ticketsapp.core.BasePresenter;
import carlos.com.ticketsapp.core.BaseView;
import carlos.com.ticketsapp.data.models.ComidaEntity;

public class SemanaContract  {
    interface View extends BaseView<Presenter>{

        boolean isActive();

        void getMenuSemana(ArrayList<ComidaEntity> body);

        void clickItemCategorias(ComidaEntity comidaEntity);
    }
    interface Presenter extends BasePresenter{

        void getMenu();
    }
}
