package net.sgoliver.android.navigationdrawer.managers;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author Libin
 */
public class CheeseManager {
    public static final String TAG = CheeseManager.class.getName();

    private ResourceLoader mResourceLoader;
    public Context context;
    //Vars for retrieving the info from the WEB
    //https://gist.githubusercontent.com/libinbensin/21efcf3e57cbda43c0df075aca1923db/raw/3e4adb89c32a8ea77210785595fdffa3a626ab54/cheese_list.json
    private String BASE_URL = "https://gist.githubusercontent.com/";
    private String GITHUB_USER = "libinbensin";

    //Singleton
//    public static CheeseManager instance;
//    public static synchronized CheeseManager getInstance(Context context){
//        if(instance == null){
//            instance = new CheeseManager(context);
//        }
//        return instance;
//    }

    public CheeseManager(ResourceLoader resourceLoader) {
        mResourceLoader = resourceLoader;
    }

    public CheeseManager(Context context){
        this.context = context;
    }

    /**
     * Retrieves the sorted list of the cheeses.
     * @param context the Android context.
     * @return the sorted list of cheeses.
     */
    public ArrayList<String> getSortedCheeseListFromAssets(Context context) {
        // load from assets
        ArrayList<String> cheeseList = mResourceLoader.loadFileFromAssets(context, "cheese_list.json");
        // Sort the list here
        return cheeseList;
    }

    public ArrayList<String> getArrLstResponseReturn() {
        return arrLstResponseReturn;
    }

    /**
     * Retrieves the sorted list of the cheeses from the web.
     * @param context the Android context.
     * @return the sorted list of cheeses.
     */

//    public ArrayList<String> getSortedCheeseListFromWeb_(){
//        Log.d(TAG, "getSortedCheeseListFromWeb");
//        //Do not do strange stuff in the main thread
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(URL)
//                .build();
//        okhttp3.Response response = null;
//
//        try{
//
//            response = client.newCall(request).execute();
//            String strResponse = response.body().string();
//
//            JSONArray jsonArray = new JSONArray(strResponse);
//            for(int i = 0; i < jsonArray.length(); i ++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                Log.d(TAG, jsonObject.toString());
//            }
//
//        }catch(IOException e){
//            Log.d(TAG, e.getMessage());
//        } catch (JSONException e) {
//            Log.d(TAG, e.getMessage());
//        }
//
//
//        return null;
//
//    }
    ArrayList<String>arrLstResponseReturn = new ArrayList<>();
    public ArrayList<String> getSortedCheeseListFromWeb(){
        //TODO: This is an extra challenge, prioritize last.
        // Make server request and load from cheese list
        //"https://gist.githubusercontent.com/libinbensin/21efcf3e57cbda43c0df075aca1923db/raw/3e4adb89c32a8ea77210785595fdffa3a626ab54/cheese_list.json";
        Log.d(TAG, "getSortedCheeseListFromWeb");
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubRestInterface gitHubRestInterface = retrofit.create(GitHubRestInterface.class);
        Call<ArrayList<String>> call = gitHubRestInterface.getRepositories(GITHUB_USER);

        if(call != null){
            Log.d(TAG, "CALL NOT NULL");
            call.enqueue(new Callback<ArrayList<String>>() {
                @Override
                public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                    Log.d(TAG, "onResponse:: " + response);
                    ArrayList arrLstResponse = response.body();
                    for(int i = 0; i < arrLstResponse.size(); i ++){
                        Log.d(TAG, String.valueOf(arrLstResponse.get(i)));
                        arrLstResponseReturn.add(String.valueOf(arrLstResponse.get(i)));
                    }

                }

                @Override
                public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                    Log.d(TAG, "onFailure:: " + t.getMessage());
                }
            });
        }else{
            Log.d(TAG, "CALL NULL");
        }

        Log.d(TAG, " -- OFF -- " + arrLstResponseReturn.size());
        return arrLstResponseReturn;
    }

    /**
     * Provides a filtered list of cheeses containing the given name
     * @param context the Android context.
     * @param name the name to filter
     * @return the list of filtered cheeses
     */
    public ArrayList<String> filterByName(Context context , String name){
        // search the matching cheese names
        return null;
    }

    //Retrofit
    //Endpoint
    //https://gist.githubusercontent.com/libinbensin/21efcf3e57cbda43c0df075aca1923db/raw/3e4adb89c32a8ea77210785595fdffa3a626ab54/cheese_list.json

    public interface GitHubRestInterface{
        @GET("{user}/21efcf3e57cbda43c0df075aca1923db/raw/3e4adb89c32a8ea77210785595fdffa3a626ab54/cheese_list.json")
        Call<ArrayList<String>> getRepositories(@Path("user") String username);

        @GET("{user}/21efcf3e57cbda43c0df075aca1923db/raw/3e4adb89c32a8ea77210785595fdffa3a626ab54/cheese_list.json")
        Call<String[]> getCheese(@Path("user") String username);

    }

}
