package domains;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yQ on 2015/1/7.
 */
public class userData {
    private String usercode="";
    private String _name="";
    private boolean _isvip;

    public String getUsercode() {
        return usercode;
    }

    public String get_name() {
        return _name;
    }

    public void set_isvip(boolean _isvip) {
        this._isvip = _isvip;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public boolean is_isvip() {
        return _isvip;
    }
}
