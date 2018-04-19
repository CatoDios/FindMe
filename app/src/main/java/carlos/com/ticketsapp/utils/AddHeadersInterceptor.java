package carlos.com.ticketsapp.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by macintoshhd on 20/03/18.
 */

public class AddHeadersInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder newBuilder = chain.request().newBuilder();
        newBuilder.addHeader("version", "1.0");
        return chain.proceed(newBuilder.build());
    }
}
