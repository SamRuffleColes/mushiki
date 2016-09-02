package es.rufflecol.sam.mushiki.presentation.common.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Steam logos are 184px * 69px, this view will set its height proportionately to the specified width
 */
public class SteamLogoImageView extends ImageView {

    private static final double HEIGHT_ASPECT_RATIO = 69;
    private static final double WIDTH_ASPECT_RATIO = 184;

    public SteamLogoImageView(Context context) {
        super(context);
    }

    public SteamLogoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SteamLogoImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SteamLogoImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
        int calculatedHeight = (int) Math.round(((double) originalWidth) * (HEIGHT_ASPECT_RATIO / WIDTH_ASPECT_RATIO));
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(originalWidth, MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(calculatedHeight, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
