package com.app.sportzfever.aynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.sportzfever.R;
import com.app.sportzfever.interfaces.ApiResponse;
import com.app.sportzfever.interfaces.GlobalConstants;

import org.json.JSONObject;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by Hemanta on 11/7/2016.
 */
public class CommonAsyncTask {

    private ProgressDialog pd;
    private RequestQueue queue;
    private Context context;
    private ApiResponse listener;
    int method;

    public CommonAsyncTask(int method, Context context, ApiResponse response) {

        queue = Volley.newRequestQueue(context);
        this.context = context;
        listener = response;
        this.method = method;
        pd = new ProgressDialog(context);
        pd.setMessage("Please wait ... ");
        pd.setCancelable(false);

    }


    public void getquery(String url) {
        // String url = context.getResources().getString(R.string.base_url) + addurl;
        Log.e("request", ": " + url);
        final ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading...");
        pDialog.show();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("response", response.toString());
                        pDialog.dismiss();
                        try {
                            if (response != null) {

                                if (listener != null)
                                    listener.onPostSuccess(method, response);
                            } else {
                                if (listener != null)
                                    // listener.onPostRequestFailed(method, "Null data from server.");
                                    Toast.makeText(context,
                                            context.getResources().getString(R.string.problem_server),
                                            Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.dismiss();
                try {
                    if (listener != null) {
                        listener.onPostFail(method, error.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

// Adding request to request queue
        queue.add(jsonObjReq);
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                GlobalConstants.ONE_SECOND_DELAY * 40, 0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


    }


}
