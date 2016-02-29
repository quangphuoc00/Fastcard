package mobi.fastcard.database.API;

import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by My-PC on 11/5/2015.
 */
public class ApiConnector {
    //TODO replace endpoint
    private static final String ENDPOINT = "";
    public static ApiService iApiCaller;
    public static String TAG = "Retrofit";
    public static ApiService getInstance()
    {
        if(iApiCaller == null)
        {
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExclusionStrategy() {
                        @Override
                        public boolean shouldSkipField(FieldAttributes f) {
                            return f.getDeclaringClass().equals(RealmObject.class);
                        }

                        @Override
                        public boolean shouldSkipClass(Class<?> clazz) {
                            return false;
                        }
                    })
                    .create();

            iApiCaller = new RestAdapter.Builder()
                    .setEndpoint(ENDPOINT)
                    .setConverter(new GsonConverter(gson))
                    .setClient(new OkClient())
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setLog(new RestAdapter.Log() {
                        @Override
                        public void log(String message) {
                            Log.i(TAG, message);
                        }
                    })
                    .setRequestInterceptor(new ApiRequestInterceptor())
                    .build().create(ApiService.class);
        }
        return iApiCaller;
    }
}
