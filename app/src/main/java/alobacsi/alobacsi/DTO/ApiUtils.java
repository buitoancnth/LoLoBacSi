package alobacsi.alobacsi.DTO;

/**
 * Created by lequa on 31/10/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://serveralobs2.azurewebsites.net/api/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
