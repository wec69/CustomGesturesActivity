package com.example.customgestures;

import android.Manifest;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.gesture.Gesture;
import java.util.ArrayList;

public class CustomGesturesActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureLibrary gLibrary;
    String DEBUG_TAG = "Custom_Gesture";
    private static Switch switch1, switch2, switch3, switch4, switch5, switch6;
    int selectedItem_num, selectedItem_num2, selectedItem_num3, selectedItem_num4, selectedItem_num5;
    String selectedItem, selectedItem2, selectedItem3, selectedItem4, selectedItem5;
    DevicePolicyManager devicePolicyManager;
    ComponentName componentName;
    boolean gesture_setting_11 = false; boolean gesture_setting_12 = false; boolean gesture_setting_13 = false; boolean gesture_setting_14 = false; boolean gesture_setting_15 = false;
    boolean gesture_setting_21 = false; boolean gesture_setting_22 = false; boolean gesture_setting_23 = false; boolean gesture_setting_24 = false; boolean gesture_setting_25 = false;
    boolean gesture_setting_31 = false; boolean gesture_setting_32 = false; boolean gesture_setting_33 = false; boolean gesture_setting_34 = false; boolean gesture_setting_35 = false;
    boolean gesture_setting_41 = false; boolean gesture_setting_42 = false; boolean gesture_setting_43 = false; boolean gesture_setting_44 = false; boolean gesture_setting_45 = false;
    boolean gesture_setting_51 = false; boolean gesture_setting_52 = false; boolean gesture_setting_53 = false; boolean gesture_setting_54 = false; boolean gesture_setting_55 = false;
    boolean testMode = false;
    static final int RESULT_ENABLE = 1;
    Button toggle_service = (Button) findViewById(R.id.button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gestures);

        toggle_service.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                startService(intent);
            }
        });

        devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
        componentName = new ComponentName(CustomGesturesActivity.this, Controller.class);
        boolean active = devicePolicyManager.isAdminActive(componentName);

        gLibrary = GestureLibraries.fromRawResource(this, R.raw.gesture);
        if (!gLibrary.load()) {
            finish();
        }

        GestureOverlayView gOverlay = (GestureOverlayView) findViewById(R.id.gOverlay);
        gOverlay.addOnGesturePerformedListener(CustomGesturesActivity.this);

        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem_num = i;
                selectedItem = spinner.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem2 = spinner2.getItemAtPosition(i).toString();
                selectedItem_num2 = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem3 = spinner3.getItemAtPosition(i).toString();
                selectedItem_num3 = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Spinner spinner4 = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem4 = spinner4.getItemAtPosition(i).toString();
                selectedItem_num4 = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Spinner spinner5 = findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem5 = spinner5.getItemAtPosition(i).toString();
                selectedItem_num5 = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        switch4 = findViewById(R.id.switch4);
        switch5 = findViewById(R.id.switch5);
        switch6 = findViewById(R.id.switch6);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Log.d(DEBUG_TAG, "switch on");
                    if(!selectedItem.equals("No action")) {
                        Log.d(DEBUG_TAG, selectedItem);
                        Log.d(DEBUG_TAG, "Selected num is " + selectedItem_num);
                        toggleConnection(selectedItem_num);
                    }
                }
                else {
                    Log.d(DEBUG_TAG, "switch off");
                    gesture_setting_11=false;
                    gesture_setting_12=false;
                    gesture_setting_13=false;
                    gesture_setting_14=false;
                    gesture_setting_15=false;
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Log.d(DEBUG_TAG, "switch on");
                    if(!selectedItem2.equals("No action")) {
                        Log.d(DEBUG_TAG, selectedItem);
                        Log.d(DEBUG_TAG, "Selected num is " + selectedItem_num2);
                        toggleConnection2(selectedItem_num2);
                    }
                }
                else {
                    Log.d(DEBUG_TAG, "switch off");
                    gesture_setting_21=false;
                    if (gesture_setting_22=true) {
                        devicePolicyManager.removeActiveAdmin(componentName);
                        gesture_setting_22=false;
                    }
                    gesture_setting_23=false;
                    gesture_setting_24=false;
                    gesture_setting_25=false;
                }
            }
        });

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Log.d(DEBUG_TAG, "switch on");
                    if(!selectedItem3.equals("No action")) {
                        Log.d(DEBUG_TAG, selectedItem);
                        Log.d(DEBUG_TAG, "Selected num is " + selectedItem_num3);
                        toggleConnection3(selectedItem_num3);
                    }
                }
                else {
                    Log.d(DEBUG_TAG, "switch off");
                    gesture_setting_31=false;
                    gesture_setting_32=false;
                    gesture_setting_33=false;
                    gesture_setting_34=false;
                    gesture_setting_35=false;
                }
            }
        });

        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Log.d(DEBUG_TAG, "switch on");
                    if(!selectedItem4.equals("No action")) {
                        Log.d(DEBUG_TAG, selectedItem);
                        Log.d(DEBUG_TAG, "Selected num is " + selectedItem_num4);
                        toggleConnection4(selectedItem_num4);
                    }
                }
                else {
                    Log.d(DEBUG_TAG, "switch off");
                    gesture_setting_41 = false;
                    gesture_setting_42 = false;
                    gesture_setting_43 = false;
                    gesture_setting_44 = false;
                    gesture_setting_45 = false;
                }
            }
        });

        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    Log.d(DEBUG_TAG, "switch on");
                    if(!selectedItem5.equals("No action")) {
                        Log.d(DEBUG_TAG, selectedItem);
                        Log.d(DEBUG_TAG, "Selected num is " + selectedItem_num5);
                        toggleConnection5(selectedItem_num5);
                    }
                }
                else {
                    Log.d(DEBUG_TAG, "switch off");
                    gesture_setting_51=false;
                    gesture_setting_52=false;
                    gesture_setting_53=false;
                    gesture_setting_54=false;
                    gesture_setting_55=false;
                }
            }
        });

        switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.d(DEBUG_TAG, "here?");
                if (isChecked) {
                    testMode = true;
                }
                else if (!isChecked) {
                    testMode = false;
                }
            }
        });
    }

    public void toggleConnection(int selectedItem_num) {
        switch(selectedItem_num) {
            case 1:
                gesture_setting_11 = true;
                Log.d(DEBUG_TAG, "Take Screen shot");
                break;
            case 2:
                gesture_setting_12 = true;
                Log.d(DEBUG_TAG, "Lock the screen");
                boolean active = devicePolicyManager.isAdminActive(componentName);
                Log.d(DEBUG_TAG, "current active : "+active);
                if (active) {
                    devicePolicyManager.removeActiveAdmin(componentName);
                } else {
                    Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                    intent.putExtra (DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
                    intent.putExtra (DevicePolicyManager.EXTRA_ADD_EXPLANATION, "You should enable app!");
                    startActivityForResult(intent, RESULT_ENABLE);
                }
                break;
            case 3:
                gesture_setting_13 = true;
                Log.d(DEBUG_TAG, "Open camera app");
                break;
            case 4:
                gesture_setting_14 = true;
                Log.d(DEBUG_TAG, "Show recent used app");
                break;
            case 5:
                gesture_setting_15 = true;
                Log.d(DEBUG_TAG, "action5");
                break;
        }
        //return true;
    }

    public void toggleConnection2(int selectedItem_num) {
        switch(selectedItem_num) {
            case 1:
                gesture_setting_21 = true;
                Log.d(DEBUG_TAG, "Take Screen shot");
                break;
            case 2:
                gesture_setting_22 = true;
                Log.d(DEBUG_TAG, "Lock the screen");
                boolean active = devicePolicyManager.isAdminActive(componentName);
                Log.d(DEBUG_TAG, "current active : "+active);
                if (active) {
                    devicePolicyManager.removeActiveAdmin(componentName);
                } else {
                    Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                    intent.putExtra (DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
                    intent.putExtra (DevicePolicyManager.EXTRA_ADD_EXPLANATION, "You should enable app!");
                    startActivityForResult(intent, RESULT_ENABLE);
                }
                break;
            case 3:
                gesture_setting_23 = true;
                Log.d(DEBUG_TAG, "Open camera app");
                break;
            case 4:
                gesture_setting_24 = true;
                Log.d(DEBUG_TAG, "Show recent used app");
                break;
            case 5:
                gesture_setting_25 = true;
                Log.d(DEBUG_TAG, "action5");
                break;
        }
        //return true;
    }

    public void toggleConnection3(int selectedItem_num) {
        switch(selectedItem_num) {
            case 1:
                gesture_setting_31 = true;
                Log.d(DEBUG_TAG, "Take Screen shot");
                break;
            case 2:
                gesture_setting_32 = true;
                Log.d(DEBUG_TAG, "Lock the screen");
                boolean active = devicePolicyManager.isAdminActive(componentName);
                Log.d(DEBUG_TAG, "current active : "+active);
                if (active) {
                    devicePolicyManager.removeActiveAdmin(componentName);
                } else {
                    Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                    intent.putExtra (DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
                    intent.putExtra (DevicePolicyManager.EXTRA_ADD_EXPLANATION, "You should enable app!");
                    startActivityForResult(intent, RESULT_ENABLE);
                }
                Log.d(DEBUG_TAG, "Lock the screen");
                break;
            case 3:
                gesture_setting_33 = true;
                Log.d(DEBUG_TAG, "Open camera app");
                break;
            case 4:
                gesture_setting_34 = true;
                Log.d(DEBUG_TAG, "Show recent used app");
                break;
            case 5:
                gesture_setting_35 = true;
                Log.d(DEBUG_TAG, "action5");
                break;
        }
        //return true;
    }

    public void toggleConnection4(int selectedItem_num) {
        switch(selectedItem_num) {
            case 1:
                gesture_setting_41 = true;
                Log.d(DEBUG_TAG, "Take Screen shoot");
                break;
            case 2:
                gesture_setting_42 = true;
                Log.d(DEBUG_TAG, "Lock the screen");
                boolean active = devicePolicyManager.isAdminActive(componentName);
                Log.d(DEBUG_TAG, "current active : "+active);
                if (active) {
                    devicePolicyManager.removeActiveAdmin(componentName);
                } else {
                    Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                    intent.putExtra (DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
                    intent.putExtra (DevicePolicyManager.EXTRA_ADD_EXPLANATION, "You should enable app!");
                    startActivityForResult(intent, RESULT_ENABLE);
                }
                Log.d(DEBUG_TAG, "Lock the screen");
                break;
            case 3:
                gesture_setting_43 = true;
                Log.d(DEBUG_TAG, "Open camera app");
                break;
            case 4:
                gesture_setting_44 = true;
                Log.d(DEBUG_TAG, "Show recent used app");
                break;
            case 5:
                gesture_setting_45 = true;
                Log.d(DEBUG_TAG, "action5");
                break;
        }
        //return true;
    }

    public void toggleConnection5(int selectedItem_num) {
        switch(selectedItem_num) {
            case 1:
                gesture_setting_51 = true;
                Log.d(DEBUG_TAG, "Take Screen shot");
                break;
            case 2:
                gesture_setting_52 = true;
                Log.d(DEBUG_TAG, "Lock the screen");
                boolean active = devicePolicyManager.isAdminActive(componentName);
                Log.d(DEBUG_TAG, "current active : "+active);
                if (active) {
                    devicePolicyManager.removeActiveAdmin(componentName);
                } else {
                    Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                    intent.putExtra (DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
                    intent.putExtra (DevicePolicyManager.EXTRA_ADD_EXPLANATION, "You should enable app!");
                    startActivityForResult(intent, RESULT_ENABLE);
                }
                Log.d(DEBUG_TAG, "Lock the screen");
                break;
            case 3:
                gesture_setting_53 = true;
                Log.d(DEBUG_TAG, "Open camera app");
                break;
            case 4:
                gesture_setting_54 = true;
                Log.d(DEBUG_TAG, "Show recent used app");
                break;
            case 5:
                gesture_setting_55 = true;
                Log.d(DEBUG_TAG, "action5");
                break;
        }
        //return true;
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_CAMERA = 2;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == REQUEST_EXTERNAL_STORAGE) {
                takeScreenshot();
            }
            else if (requestCode == REQUEST_CAMERA) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        }
    }

    private void takeScreenshot() {
        Log.d(DEBUG_TAG, "start take screen shot method");
        try {
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            v1.buildDrawingCache();
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            Log.d(DEBUG_TAG, "hi0");
            MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", null);
            Log.d(DEBUG_TAG, "stored");
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture)  {
        String gesture_s, gesture_horn, gesture_next, gesture_pre, gesture_star, gesture_cir, gesture_rec;
        ArrayList<Prediction> predictions = gLibrary.recognize(gesture);
        if (predictions.size() > 0 && predictions.get(0).score >1.0) {
            String action = predictions.get(0).name;
            if (testMode) {
                Toast.makeText(this, action, Toast.LENGTH_SHORT).show();
            }
            else if (!testMode) {}
            if (action.equals("gesture_s")) {
                if (gesture_setting_11) {
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                    }
                    else {
                        takeScreenshot();
                    }
                }
                else if (gesture_setting_12){
                    Log.d(DEBUG_TAG, "2_2");
                    devicePolicyManager.lockNow();
                }
                else if (gesture_setting_13){
                    Log.d(DEBUG_TAG, "2_3");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String []{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                    }
                    else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 1);
                    }
                }
                else if (gesture_setting_14){
                    Log.d(DEBUG_TAG, "2_4");
                    Intent home = new Intent(Intent.ACTION_MAIN);
                    home.addCategory(Intent.CATEGORY_HOME);
                    startActivity(home);
                }
                else if (gesture_setting_15){
                    Log.d(DEBUG_TAG, "2_5");
                }
            }
            else if (action.equals("gesture_horn")) {
                if (gesture_setting_21) {
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                    }
                    else {
                        takeScreenshot();
                    }
                }
                else if (gesture_setting_22){
                    Log.d(DEBUG_TAG, "2_2");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK);
                    devicePolicyManager.lockNow();
                }
                else if (gesture_setting_23){
                    Log.d(DEBUG_TAG, "2_3");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String []{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                    }
                    else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 1);
                    }
                }
                else if (gesture_setting_24){
                    Log.d(DEBUG_TAG, "2_4");
                    Intent home = new Intent(Intent.ACTION_MAIN);
                    home.addCategory(Intent.CATEGORY_HOME);
                    startActivity(home);
                }
                else if (gesture_setting_25){
                    Log.d(DEBUG_TAG, "2_5");
                }
            }
            else if (action.equals("gesture_star")) {
                if (gesture_setting_31) {
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                    }
                    else {
                        takeScreenshot();
                    }
                }
                else if (gesture_setting_32){
                    Log.d(DEBUG_TAG, "2_2");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK);
                    devicePolicyManager.lockNow();
                }
                else if (gesture_setting_33){
                    Log.d(DEBUG_TAG, "2_3");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String []{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                    }
                    else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 1);
                    }
                }
                else if (gesture_setting_34){
                    Log.d(DEBUG_TAG, "2_4");
                    Intent home = new Intent(Intent.ACTION_MAIN);
                    home.addCategory(Intent.CATEGORY_HOME);
                    startActivity(home);
                }
                else if (gesture_setting_35){
                    Log.d(DEBUG_TAG, "2_5");
                }
            }
            else if (action.equals("gesture_circle")) {
                if (gesture_setting_41) {
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                    }
                    else {
                        takeScreenshot();
                    }
                }
                else if (gesture_setting_42){
                    Log.d(DEBUG_TAG, "2_2");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK);
                    devicePolicyManager.lockNow();
                }
                else if (gesture_setting_43){
                    Log.d(DEBUG_TAG, "2_3");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String []{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                    }
                    else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 1);
                    }
                }
                else if (gesture_setting_44){
                    Log.d(DEBUG_TAG, "2_4");
                    Intent home = new Intent(Intent.ACTION_MAIN);
                    home.addCategory(Intent.CATEGORY_HOME);
                    startActivity(home);
                }
                else if (gesture_setting_45){
                    Log.d(DEBUG_TAG, "2_5");
                }
            }
            else if (action.equals("gesture_next")) {
                if (gesture_setting_51) {
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                    }
                    else {
                        takeScreenshot();
                    }
                }
                else if (gesture_setting_52){
                    Log.d(DEBUG_TAG, "2_2");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK);
                    devicePolicyManager.lockNow();
                }
                else if (gesture_setting_53){
                    Log.d(DEBUG_TAG, "2_3");
                    int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    if (permission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String []{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                    }
                    else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 1);
                    }
                }
                else if (gesture_setting_54){
                    Log.d(DEBUG_TAG, "2_4");
                    Intent home = new Intent(Intent.ACTION_MAIN);
                    home.addCategory(Intent.CATEGORY_HOME);
                    startActivity(home);
                }
                else if (gesture_setting_55){
                    Log.d(DEBUG_TAG, "2_5");
                }
            }
        }
    }
}
