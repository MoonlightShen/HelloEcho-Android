package com.echo.hello.util.network;

import com.echo.hello.MyApp;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class BaseRequest {
    private static final OkHttpClient client;

    static {
        client = MyApp.getClient();
    }

    protected enum MIME_TYPE{
        JSON(MediaType.Companion.parse("application/json;charset=utf-8")),
        UNKNOWN_BINARY_DATA_STREAM(MediaType.Companion.parse("application/octet-stream;charset=utf-8"));

        final MediaType mediaType;

        MIME_TYPE(MediaType mediaType) {
            this.mediaType = mediaType;
        }
    }

    protected static RequestBody createBody(MediaType mediaType, String content){
        return RequestBody.Companion.create(content, mediaType);
    }

    protected static Response submitCall(Request request) throws IOException {
        return client.newCall(request).execute();
    }

//    public Response fun() throws IOException {
//        Request request = new Request.Builder()
//                .url("...")
//                .method("POST", createBody(MIME_TYPE.JSON.mediaType, ""))
//                .addHeader("Content-Type", "application/json")
//                .build();
//        return submitCall(request);
//    }

}
