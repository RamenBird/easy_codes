package com.example.ramenbird.myapplication;


import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.TextureView;

/**
 * Created by ramenbird on 2016/11/1.
 *
 * @see android.view.TextureView
 * @see
 */

public class UseCamera extends Activity {
    private String mCameraId;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            openCamera(width, height);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            return true;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };

    public void fakeCode() {
        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
//        String targetCameraId = getTargetCameraId();

//        CameraDevice device = cameraManager.openCamera(targetCameraId, new CameraDevice.StateCallback() {
//            @Override
//            public void onOpened(CameraDevice camera) {
//
//            }
//
//            @Override
//            public void onDisconnected(CameraDevice camera) {
//
//            }
//
//            @Override
//            public void onError(CameraDevice camera, int error) {
//
//            }
//        }, mBackgroundHandler);
//
//
//        device.createCaptureSession(Arrays.asList(new Surface(new TextureView(this).getSurfaceTexture())),
//                new CameraCaptureSession.StateCallback() {
//                    @Override
//                    public void onConfigured(CameraCaptureSession session) {
//
//                    }
//
//                    @Override
//                    public void onConfigureFailed(CameraCaptureSession session) {
//
//                    }
//                }, mBackgroundHandler);
//
//
//        CaptureRequest.Builder builder = device.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
//        builder.addTarget(Arrays.asList(new TextureView(this).getSurfaceTexture()));
//        builder.set();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_use_camera);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextureView textureView = (TextureView) findViewById(R.id.surface);
        if (textureView.isAvailable()) {
            openCamera(textureView.getWidth(), textureView.getHeight());
        } else {
            textureView.setSurfaceTextureListener(mSurfaceTextureListener);
        }

        mBackgroundThread = new HandlerThread("BackgroundThread-3");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    @Override
    protected void onPause() {
        mBackgroundThread.quitSafely();
        try {
            mBackgroundThread.join();
            mBackgroundThread = null;
            mBackgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        super.onPause();
    }

    private void getCameraId() {
        CameraManager manager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            for (String cameraId : manager.getCameraIdList()) {
                Log.i(getClass().getSimpleName(), String.format("camera id:%s", cameraId));

                CameraCharacteristics characteristics
                        = manager.getCameraCharacteristics(cameraId);

                Log.i(getClass().getSimpleName(), String.format("camera lens_facing:%d", characteristics
                        .get(CameraCharacteristics.LENS_FACING)));

                if (characteristics.get(CameraCharacteristics.LENS_FACING) != CameraCharacteristics.LENS_FACING_FRONT) {
                    continue;
                }

                StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (map == null) {
                    continue;
                }

            }

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void openCamera(int width, int height) {
        getCameraId();

    }

}
