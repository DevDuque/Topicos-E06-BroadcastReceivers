package br.team.batteryreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

public class BatteryReceiver extends BroadcastReceiver {

    private final MainActivity activity;

    public BatteryReceiver(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float) scale;

        if (batteryPct < 0.15) { // Bateria baixa
            activity.switchActivityTheme(R.style.Theme_BatteryReceiverLowBattery);
        } else { // Bateria OK
            activity.switchActivityTheme(R.style.Theme_BatteryReceiver);
        }
    }


    public static IntentFilter getIntentFilter() {
        return new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    }
}
