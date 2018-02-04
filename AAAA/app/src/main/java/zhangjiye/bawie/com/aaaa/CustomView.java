package zhangjiye.bawie.com.aaaa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 张继业 on 2018/2/3.
 */

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 创建画笔
        Paint p = new Paint();
        p.setColor(Color.BLACK);

        p.reset();
        //设置空心
        p.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(100, 320);//设置Path的起点
        path.quadTo(150, 310, 170, 400);  //设置路径点和终点
        canvas.drawPath(path, p);
    }
}
