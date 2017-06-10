package customfonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by one on 3/12/15.
 */
public class MyTextViewMedium extends android.support.v7.widget.AppCompatTextView {

    public MyTextViewMedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextViewMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextViewMedium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/MavenPro-Medium.ttf");
            setTypeface(tf);
        }
    }

}