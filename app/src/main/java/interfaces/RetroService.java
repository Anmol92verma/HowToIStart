package interfaces;

import java.util.Map;

import models.PostsMainModel;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Created by anmol on 28/5/15.
 */
public interface RetroService {

    @GET("/")
    void getPosts(@QueryMap Map<String, String> query, Callback<PostsMainModel> cb);


}
