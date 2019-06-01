package custom_font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by one on 3/12/15.
 */
public class Aeh extends TextView {

    public Aeh(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Aeh(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Aeh(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "AEH.ttf");
            setTypeface(tf);
        }
    }

}