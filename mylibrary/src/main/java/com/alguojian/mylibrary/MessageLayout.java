package com.alguojian.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * ${Descript}
 *
 * @author alguojian
 * @date 2018/7/3
 */
public class MessageLayout extends RelativeLayout {

    private Context mContext;
    private View rootView;
    private RelativeLayout mRelativeLayout;
    private TextView leftTextView;
    private TextView centerTextView;
    private ImageView rightIcon;
    private ImageView leftIcon;

    private int leftTextColor;
    private float leftTextSize;
    private float centerTextSize;
    private int centerTextColor;
    private float leftTextMarginLeft;
    private float centerTextMarginRight;
    private float rightIconMarginRight;
    private int rightIconId;
    private int leftIconId;
    private boolean rightIconShow;
    private String leftTextString;
    private String centerTextString;


    public MessageLayout(Context context) {
        super(context);
        initView(context, null, 0);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        rootView = LayoutInflater.from(context).inflate(R.layout.messagelayout, null);
        addView(rootView);
        mRelativeLayout = rootView.findViewById(R.id.relativeLayout);
        leftTextView = rootView.findViewById(R.id.leftText);
        centerTextView = rootView.findViewById(R.id.centerText);
        rightIcon = rootView.findViewById(R.id.rightIcon);
        leftIcon = rootView.findViewById(R.id.leftIcon);

        setGravity(Gravity.CENTER);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MessageLayout);

        leftTextColor = typedArray.getColor(R.styleable.MessageLayout_leftTextColor, 0xff878794);
        leftTextSize = typedArray.getDimension(R.styleable.MessageLayout_leftTextSize, 16f);
        centerTextSize = typedArray.getDimension(R.styleable.MessageLayout_centerTextSize, 16f);
        centerTextColor = typedArray.getColor(R.styleable.MessageLayout_leftTextColor, 0xff39364d);
        leftTextMarginLeft = typedArray.getDimension(R.styleable.MessageLayout_leftTextMarginLeft, 14f);
        centerTextMarginRight = typedArray.getDimension(R.styleable.MessageLayout_centerTextMarginRight, 30f);
        rightIconMarginRight = typedArray.getDimension(R.styleable.MessageLayout_rightIconMarginRight, 10f);

        rightIconId = typedArray.getResourceId(R.styleable.MessageLayout_rightIcon, R.drawable.common_arrowright_icon);
        leftIconId = typedArray.getResourceId(R.styleable.MessageLayout_rightIcon, 0);
        rightIconShow = typedArray.getBoolean(R.styleable.MessageLayout_rightIconShow, true);
        leftTextString = typedArray.getString(R.styleable.MessageLayout_leftTextString);
        centerTextString = typedArray.getString(R.styleable.MessageLayout_centerTextString);

        typedArray.recycle();

        leftTextView.setTextColor(leftTextColor);
        leftTextView.setText(leftTextString);
        centerTextView.setText(centerTextString);
        leftTextView.setTextSize(leftTextSize);

        leftTextView.setPadding(dpTopx(leftTextMarginLeft), 0, 0, 0);
        centerTextView.setTextSize(centerTextSize);
        centerTextView.setTextColor(centerTextColor);
        centerTextView.setPadding(0, 0, dpTopx(centerTextMarginRight), 0);
        rightIcon.setImageDrawable(ContextCompat.getDrawable(context, rightIconId));
        rightIcon.setPadding(0, 0, dpTopx(rightIconMarginRight), 0);

        if (leftIconId != 0) {
            leftIcon.setVisibility(VISIBLE);
            leftIcon.setImageDrawable(ContextCompat.getDrawable(context, leftIconId));
        }

        if (!rightIconShow) {
            rightIcon.setVisibility(GONE);
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dpTopx(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public MessageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView(context, attrs, 0);
    }

    public MessageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    public void setLeftTextString(String string) {
        leftTextView.setText(string);
    }

    public void setcenterTextString(String string) {
        centerTextView.setText(string);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
