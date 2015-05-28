package application;

import android.app.Application;

import interfaces.RetroService;
import retrofit.RestAdapter;

/**
 * Created by anmol on 28/5/15.
 */
public class MyApplication extends Application {

    RetroService service;

    @Override
    public void onCreate() {
        super.onCreate();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://howtoistart.com")
                .build();

        service = restAdapter.create(RetroService.class);

    }

    public RetroService getService() {
        return service;
    }

    public void setService(RetroService service) {
        this.service = service;
    }
}
