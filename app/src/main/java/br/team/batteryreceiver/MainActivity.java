package br.team.batteryreceiver;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int CURRENT_THEME = R.style.Base_Theme_BatteryReceiver;
    private BatteryReceiver batteryReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(CURRENT_THEME);
        setContentView(R.layout.activity_main);

        // Registrar o receiver
        batteryReceiver = new BatteryReceiver(this);
        registerReceiver(batteryReceiver, BatteryReceiver.getIntentFilter());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Desregistrar o receiver
        unregisterReceiver(batteryReceiver);
    }

    public void switchActivityTheme(int themeId) {
        if (CURRENT_THEME != themeId) { // Verifica se o tema é diferente
            CURRENT_THEME = themeId;
            // Recria a atividade para aplicar o novo tema
            recreate();
        }
    }

}
