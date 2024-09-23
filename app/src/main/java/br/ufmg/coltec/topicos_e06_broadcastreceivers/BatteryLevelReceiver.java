package br.ufmg.coltec.topicos_e06_broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class BatteryLevelReceiver extends BroadcastReceiver {

    private final MainActivity activity;

    public BatteryLevelReceiver(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float) scale;

        if (batteryPct < 0.15) { // Bateria baixa
            activity.switchActivityTheme(R.style.Theme_TopicosE06BroadcastReceiversLowBattery);
        } else { // Bateria OK
            activity.switchActivityTheme(R.style.Theme_TopicosE06BroadcastReceivers);
        }
    }

    public static IntentFilter getIntentFilter() {
        return new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    }
}
