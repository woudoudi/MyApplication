package com.edaochina.axinbaba.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;

import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.test.R;


public class AppbarZoomBehavior extends AppBarLayout.Behavior {

    private ImageView mImageView;
    private int mAppbarHeight;//记录AppbarLayout原始高度
    private int mImageViewHeight;//记录ImageView原始高度

    private static final float MAX_ZOOM_HEIGHT = 500;//放大最大高度
    private float mTotalDy;//手指在Y轴滑动的总距离
    private float mScaleValue;//图片缩放比例
    private int mLastBottom;//Appbar的变化高度

    private boolean isAnimate;//是否做动画标志

    public AppbarZoomBehavior(){

    }

    public AppbarZoomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, AppBarLayout abl, int layoutDirection) {
        boolean handled = super.onLayoutChild(parent, abl, layoutDirection);
        init(abl);
        return handled;
    }

    /**
     * 进行初始化操作，在这里获取到ImageView的引用，和Appbar的原始高度
     *
     * @param abl
     */
    private void init(AppBarLayout abl) {
        abl.setClipChildren(false);
        mAppbarHeight = abl.getHeight();
        mImageView = (ImageView) abl.findViewById(R.id.iv_img);
        if (mImageView != null) {
            mImageViewHeight = mImageView.getHeight();
        }
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, AppBarLayout child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }

    /**
     * 是否处理嵌套滑动
     *
     * @param parent
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @param
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        super.onStartNestedScroll(parent,child,directTargetChild,target,nestedScrollAxes);
        isAnimate = true;
        return true;
    }

    /**
     * 在这里做具体的滑动处理
     *
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param dx
     * @param dy
     * @param consumed
     * @param
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {
        if (mImageView != null && child.getBottom() >= mAppbarHeight && dy < 0 ) {
            zoomHeaderImageView(child, dy);
        } else {
            if (mImageView != null && child.getBottom() > mAppbarHeight && dy > 0 ) {
                consumed[1] = dy;
                zoomHeaderImageView(child, dy);
            } else {
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
                }

            }
        }

    }


    /**
     * 对ImageView进行缩放处理，对AppbarLayout进行高度的设置
     *
     * @param abl
     * @param dy
     */
    private void zoomHeaderImageView(AppBarLayout abl, int dy) {
        mTotalDy += -dy;
        mTotalDy = Math.min(mTotalDy, MAX_ZOOM_HEIGHT);
        mScaleValue = Math.max(1f, 1f + mTotalDy / MAX_ZOOM_HEIGHT);
        ViewCompat.setScaleX(mImageView, mScaleValue);
        ViewCompat.setScaleY(mImageView, mScaleValue);
        mLastBottom = mAppbarHeight + (int) (mImageViewHeight / 2 * (mScaleValue - 1));
        abl.setBottom(mLastBottom);
    }


    /**
     * 处理惯性滑动的情况
     *
     * @param coordinatorLayout
     * @param child
     * @param target
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY) {
        if (velocityY > 100) {
            isAnimate = false;
        }
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }


    /**
     * 滑动停止的时候，恢复AppbarLayout、ImageView的原始状态
     *
     * @param coordinatorLayout
     * @param abl
     * @param target
     * @param
     */
    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target) {
        recovery(abl);
        super.onStopNestedScroll(coordinatorLayout, abl, target);
    }

    ValueAnimator valueAnimator;

    /**
     * 通过属性动画的形式，恢复AppbarLayout、ImageView的原始状态
     *
     * @param abl
     */
    private void recovery(final AppBarLayout abl) {
        if (mTotalDy > 0) {
            mTotalDy = 0;
            if (isAnimate) {
                valueAnimator = ValueAnimator.ofFloat(mScaleValue, 1f).setDuration(220);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        ViewCompat.setScaleX(mImageView, value);
                        ViewCompat.setScaleY(mImageView, value);
                        abl.setBottom((int) (mLastBottom - (mLastBottom - mAppbarHeight) * animation.getAnimatedFraction()));
                    }
                });
                valueAnimator.start();
            } else {
                ViewCompat.setScaleX(mImageView, 1f);
                ViewCompat.setScaleY(mImageView, 1f);
                abl.setBottom(mAppbarHeight);
            }
        }
    }
}