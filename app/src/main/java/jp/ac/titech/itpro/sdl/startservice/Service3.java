package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

@SuppressWarnings("deprecation")
public class Service3 extends IntentService {
    private final static String TAG = Service3.class.getSimpleName();
    public final static String EXTRA_MYARG = "MYARG";

    Intent senderIntent = new Intent();

    public final static String ACTION_ANSWER = "SERVICE3_AA";
    public final static String EXTRA_ANSWER = "SERVICE3_EA";

    public Service3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Thread.sleep(2000); // 5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());

        senderIntent.setAction(ACTION_ANSWER);
        senderIntent.putExtra(EXTRA_ANSWER, "Service3 start");
        sendBroadcast(senderIntent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        senderIntent.putExtra(EXTRA_ANSWER, "Service3 finish");
        sendBroadcast(senderIntent);
        super.onDestroy();
    }
}
