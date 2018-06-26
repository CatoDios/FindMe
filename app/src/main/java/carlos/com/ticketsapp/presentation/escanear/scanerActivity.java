package carlos.com.ticketsapp.presentation.escanear;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import carlos.com.ticketsapp.R;
import carlos.com.ticketsapp.core.BaseActivity;

public class scanerActivity extends BaseActivity {
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    Context mContext;
    @BindView(R.id.camera_preview)
    SurfaceView cameraPreview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_escanear);
        ButterKnife.bind(this);
        mContext=this.getBaseContext();

        if (ContextCompat.checkSelfPermission(scanerActivity.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(scanerActivity.this,
                    Manifest.permission.CAMERA)) {

            } else {

                ActivityCompat.requestPermissions(scanerActivity.this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

            }
        }
        createCameraSource();
    }




    private void createCameraSource() {
        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(this).setBarcodeFormats(
                Barcode.EAN_13
                        | Barcode.EAN_8
                        | Barcode.UPC_A
                        | Barcode.UPC_E
                        | Barcode.CODE_39
                        | Barcode.CODE_93
                        | Barcode.CODE_128
                        | Barcode.CODABAR| Barcode.QR_CODE
        ).build();
        final CameraSource cameraSource = new CameraSource.Builder(this, barcodeDetector).
                setAutoFocusEnabled(true)
                .setRequestedPreviewSize(8000, 512)
                .build();
        cameraPreview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                try {
                    if (ActivityCompat.checkSelfPermission(scanerActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    cameraSource.start(cameraPreview.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop();
            }
        });
        barcodeDetector.setProcessor(new com.google.android.gms.vision.Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(com.google.android.gms.vision.Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes=detections.getDetectedItems();
                if(barcodes.size()>0){
                    Intent intent=new Intent();
                    intent.putExtra("barcode", (Parcelable) barcodes.valueAt(0));
                    setResult(CommonStatusCodes.SUCCESS,intent);
                    finish();
                }
            }
        });
    }
}
