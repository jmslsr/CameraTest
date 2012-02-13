package com.example.cameratest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button cameraGet = (Button) findViewById(R.id.gotoCamera);
        cameraGet.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View view) {
        		Intent getPicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        		startActivityForResult(getPicture, CAMERA_PIC_REQUEST);
        	}
        });
    }   
    
    public static final int CAMERA_PIC_REQUEST = 999;    
        
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    		 if (requestCode == CAMERA_PIC_REQUEST) {
    			ImageView image = (ImageView) findViewById(R.id.photoResultView);
    		    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
    			image.setImageBitmap(thumbnail);
    		}
    }
}