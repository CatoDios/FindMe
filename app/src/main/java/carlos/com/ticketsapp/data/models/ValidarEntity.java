package carlos.com.ticketsapp.data.models;

import java.io.Serializable;

/**
 * Created by carlos on 16/06/2018.
 */

public class ValidarEntity implements Serializable {
    int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
