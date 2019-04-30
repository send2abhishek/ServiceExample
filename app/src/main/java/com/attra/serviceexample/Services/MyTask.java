package com.attra.serviceexample.Services;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class MyTask extends AsyncTask<Void,String,Void> {


    private Context context;

    public MyTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.i("MyService","doInBackground Method is called: Thread Name -"+ Thread.currentThread().getName());
        int ctr=0;
        try {

            while (ctr<10){
                publishProgress("Current Progress: - "+ ctr);
                Thread.sleep(1000);

                ctr++;


            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.i("MyService","onProgressUpdate Method is called: Thread Name -"+ Thread.currentThread().getName());
        Toast.makeText(context,""+values[0],Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
