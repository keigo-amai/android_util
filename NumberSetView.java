package com.glpgs.ika.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.glpgs.ika.R;

/**
 * 最大2桁の数字を画像を組み合わせて表示します.
 * 
 * @author keigo.amai
 * 
 */
public class NumberSetView extends LinearLayout {

    public enum Size {
        SMALL, NORMAL,
    }

    public NumberSetView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberSetView(Context context) {
        super(context);
    }

    private int mNumber = 30;

    private static final int IMAGES[] = new int[] { R.drawable.number_0,
            R.drawable.number_1, R.drawable.number_2, R.drawable.number_3,
            R.drawable.number_4, R.drawable.number_5, R.drawable.number_6,
            R.drawable.number_7, R.drawable.number_8, R.drawable.number_9, };
    private static final int SMALL_IMAGES[] = new int[] {
            R.drawable.number_small_0, R.drawable.number_small_1,
            R.drawable.number_small_2, R.drawable.number_small_3,
            R.drawable.number_small_4, R.drawable.number_small_5,
            R.drawable.number_small_6, R.drawable.number_small_7,
            R.drawable.number_small_8, R.drawable.number_small_9, };

    /**
     * 表示
     */
    public void show() {
        setVisibility(View.VISIBLE);
    }

    /**
     * hideする.
     */
    public void hide() {
        setVisibility(View.GONE);
    }

    public void setNumber(int number, Size size) {
        this.mNumber = number;
        update(size);
    }

    private void update(Size size) {
        setOrientation(HORIZONTAL);
        int num = mNumber;
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);

        do {
            int order = num % 10;
            ImageView imageView;
            switch (size) {
            case NORMAL:
            default:
                imageView = createImageView(IMAGES[order]); // 1の位
                break;
            case SMALL:
                imageView = createImageView(SMALL_IMAGES[order]); // 1の位
                break;
            }
            addView(imageView, 0, lp);
            num = num / 10;
        } while (num != 0);
    }

    private ImageView createImageView(final int resId) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(resId);
        return imageView;
    }
}
