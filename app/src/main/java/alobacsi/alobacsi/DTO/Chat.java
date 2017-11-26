package alobacsi.alobacsi.DTO;

/**
 * Created by lequa on 26/11/2017.
 */

public class Chat {
    private String noiDung;
    private boolean nhan;

    public Chat(String noiDung, boolean nhan) {
        this.noiDung = noiDung;
        this.nhan = nhan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public boolean isNhan() {
        return nhan;
    }

    public void setNhan(boolean nhan) {
        this.nhan = nhan;
    }
}
