package carlos.com.ticketsapp.data.remote;


import carlos.com.ticketsapp.BuildConfig;
import carlos.com.ticketsapp.utils.AddHeadersInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Service Factory for Retrofit
 */
public class ServiceFactory {
    public static final String API_BASE_URL = BuildConfig.BASE;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addNetworkInterceptor(new AddHeadersInterceptor());
        client.addInterceptor(logging);

        Retrofit retrofit = builder.client(httpClient.build()).client(client.build()).build();
        return retrofit.create(serviceClass);
    }


    public static Retrofit retrofit() {
        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();
        return retrofit;
    }

    private static OkHttpClient.Builder oAuthHttp = new OkHttpClient.Builder();
    private static Retrofit.Builder oAuthBuilder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    public static <S> S createAuthService(Class<S> serviceClass) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
        Retrofit retrofit = oAuthBuilder.client(oAuthHttp.build()).client(client).build();
        return retrofit.create(serviceClass);
    }
}