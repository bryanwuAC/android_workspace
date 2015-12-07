package cn.eoe.custom.camera;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class CustomCameraActivity extends Activity {
	private Camera mCamera;
	private Preview mPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		mPreview = new Preview(this);
		setContentView(mPreview);
	}

	protected void onResume() {
		super.onResume();

		mCamera = Camera.open();
		mPreview.setCamera(mCamera);
	}

	protected void onPause() {
		super.onPause();

		if (mCamera != null) {
			mCamera.release();
			mCamera = null;
			mPreview.setCamera(null);
		}
	}

	class Preview extends ViewGroup implements SurfaceHolder.Callback,
			OnClickListener {

		SurfaceView mSurfaceView;
		SurfaceHolder mHolder;
		Size mPreviewSize;
		List<Size> mSupportedPreviewSizes;
		Camera mCamera;
		Context mContext;

		public Preview(Context context) {
			super(context);
			mContext = context;
			mSurfaceView = new SurfaceView(context);
			addView(mSurfaceView);
			mHolder = mSurfaceView.getHolder();
			mHolder.addCallback(this);

		}

		public void setCamera(Camera camera) {
			mCamera = camera;
			if (mCamera != null) {
				mSupportedPreviewSizes = mCamera.getParameters()
						.getSupportedPictureSizes();
				requestLayout();
			}
		}

		private PictureCallback mPictureCallback = new PictureCallback() {

			@Override
			public void onPictureTaken(byte[] data, Camera camera) {
				mCamera.startPreview();
				File pictureFile = new File("/sdcard/image.jpg");
				try {
					FileOutputStream fos = new FileOutputStream(pictureFile);
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		};

		public void onClick(View view) {
			mCamera.takePicture(null, null, mPictureCallback);
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			Camera.Parameters parameters = mCamera.getParameters();
			parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);

			mCamera.setParameters(parameters);
			mCamera.startPreview();

		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			try {
				if (mCamera != null) {
					mCamera.setPreviewDisplay(holder);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			if (mCamera != null) {
				mCamera.stopPreview();
			}
		}

		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			if (changed && getChildCount() > 0) {
				final View child = getChildAt(0);

				int width = r - l;
				int height = b - t;

				int previewWidth = width;
				int previewHeight = height;

				if (mPreviewSize != null) {
					previewWidth = mPreviewSize.width;
					previewHeight = mPreviewSize.height;
				}
				// 手机屏幕的宽高比大于采集图像的宽高比
				if (width * previewHeight > height * previewWidth) {
					final int scaledChildWidth = previewWidth * height
							/ previewHeight;
					// child.layout((width - scaledChildWidth)/2,
					// 0,(width+scaledChildWidth)/2,height);

					child.layout(100, 100, 340, 240);
				} else {
					final int scaledChildHeight = previewHeight * width
							/ previewWidth;
					child.layout(0, (height - scaledChildHeight) / 2, width,
							(height + scaledChildHeight) / 2);
				}

			}

		}

		private Size getOptimalPreviewSize(List<Size> sizes, int w, int h) {
			double ASPECT_TOLERANCE = 0.1;
			double targetRatio = (double) w / h;
			if (sizes == null)
				return null;

			Size optimalSize = null;
			double minDiff = Double.MAX_VALUE;
			int targetHeight = h;

			for (Size size : sizes) {
				double ratio = (double) size.width / size.height;
				if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) {
					continue;
				}
				if (Math.abs(size.height - targetHeight) < minDiff) {
					optimalSize = size;
					minDiff = Math.abs(size.height - targetHeight);
				}
			}

			if (optimalSize == null) {
				minDiff = Double.MAX_VALUE;
				for (Size size : sizes) {
					if (Math.abs(size.height - targetHeight) < minDiff) {
						optimalSize = size;
						minDiff = Math.abs(size.height - targetHeight);
					}
				}
			}
			return optimalSize;
		}

		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			int width = resolveSize(getSuggestedMinimumWidth(),
					widthMeasureSpec);
			int height = resolveSize(getSuggestedMinimumHeight(),
					heightMeasureSpec);

			setMeasuredDimension(width, height);

			if (mSupportedPreviewSizes != null) {
				mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSizes,
						width, height);
			}
		}

	}

}
