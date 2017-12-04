package com.example.jacek.bimbaspotted;


        import android.bluetooth.BluetoothAdapter;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.CompoundButton;
        import android.widget.ImageButton;
        import android.widget.Switch;
        import android.widget.ToggleButton;


public class TutorialActivity extends AppCompatActivity {

    ImageButton imageButton = null;
    Switch TG;
    BluetoothAdapter BA;
    int i = 1;
    Intent bluetoothIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        ToggleButton TG = (ToggleButton) findViewById(R.id.switch1);

        BA = BluetoothAdapter.getDefaultAdapter();


        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent intent = new Intent(TutorialActivity.this, AboutActivity.class);
                startActivity(intent);

                return true;
            }
        });


        TG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton ButtonView, boolean isChecked) {


                if (isChecked) {
                    bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(bluetoothIntent, i);


                } else {
                    BA.disable();
                }

            }
        });


    }

    public void onNextClick1(View view) {


        Intent intent = new Intent(TutorialActivity.this, HomeActivity.class);
        startActivity(intent);

    }
}
