package ua.olegsl.testzoom.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchExampleView extends View {

    private static final String TAG = "TouchExampleView";
    private float spaceFirst, spaceSecond;

    public TouchExampleView(Context context) {
        super(context);
    }

    public TouchExampleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchExampleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        switch (action & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_MOVE: {
                invalidate();
                break;
            }

            case MotionEvent.ACTION_POINTER_DOWN: {
                Log.e(TAG, String.valueOf(ev.getPointerCount()));
                if (ev.getPointerCount() >= 2) {
                    spaceFirst = spacing(ev);
                    Log.e(TAG, String.valueOf(spaceFirst) + "first");
                }
            }

            case MotionEvent.ACTION_POINTER_UP: {

                if (ev.getPointerCount() >= 2) {
                    spaceSecond = spacing(ev);
                    Log.e(TAG, String.valueOf(spaceSecond) + "second");
                }
                float spaceSumm = spaceFirst - spaceSecond;

                Log.e(TAG, String.valueOf(spaceSumm) + "summ");

                if (spaceSumm != 0) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                    builder1.setMessage("Write your message here.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
                break;
            }
        }
        return true;
    }
    private float spacing(MotionEvent event) {
        if (event.getPointerCount() >= 2) {
            float x = event.getX(0) - event.getX(1);
            float y = event.getY(0) - event.getY(1);
            return (float) Math.ceil(x * x + y * y);
        }
        return 0;
    }
}