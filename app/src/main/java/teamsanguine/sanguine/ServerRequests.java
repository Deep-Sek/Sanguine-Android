package teamsanguine.sanguine;

/**
 * Created by Deepan on 10/15/2015.
 */
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Deepan on 10/8/2015.
 */
public class ServerRequests {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://deepan.netai.net/";

    public ServerRequests(Context context){

        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void storeUserDataInBackground(User user, GetUserCallback userCallback){
        progressDialog.show();
        new StoreUserDataAsyncTask(user, userCallback).execute();

    }

    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void> {
        User user;
        GetUserCallback userCallback;

        public StoreUserDataAsyncTask(User user, GetUserCallback userCallback) {
            this.user = user;
            this.userCallback = userCallback;
        }

        @Override
        protected Void doInBackground(Void... params) {

            ContentValues dataToSend = new ContentValues();
            dataToSend.put("name", user.name);
            dataToSend.put("username", user.username);
            dataToSend.put("email", user.email);
            dataToSend.put("password", user.password);
            dataToSend.put("phone", user.phone);
            dataToSend.put("type", 1);

            HttpURLConnection urlConnection = null;

            try{
                URL url = new URL("http://10.0.2.2:8080/postdetails.php");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
                urlConnection.setDoOutput(true);
                urlConnection.setChunkedStreamingMode(0);

                OutputStream os = urlConnection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                StringBuilder sb = new StringBuilder();
                sb.append(URLEncoder.encode("Name", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(user.name, "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("Username", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(user.username, "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("Email", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(user.email, "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("Password", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(user.password, "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("PhoneNumber", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(String.valueOf(user.phone), "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("rdoAccountType", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(String.valueOf(user.type), "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("Address1", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(user.address1, "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("Address2", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(user.address2, "UTF-8"));

                writer.write(sb.toString());
                writer.flush();
                writer.close();
                os.close();
                urlConnection.disconnect();

            } catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            progressDialog.dismiss();
            userCallback.done(null);
            super.onPostExecute(aVoid);
        }
    }
}
