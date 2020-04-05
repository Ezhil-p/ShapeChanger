package com.example.shapechanger;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class Shapes extends View {
    boolean shape;
    int shapecolor;
    int selectedindex=2 ;
    int labelcolor;
    int shapewidth=300;
    int shapeheight=300;
    String curr[]={"Rectangle","Circle","Triangle"};
    public Shapes(Context context) {
        super(context);

    }

    public Shapes(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray array=getContext().getTheme().obtainStyledAttributes(attrs,R.styleable.Shapes,0,0);
        shape=array.getBoolean(R.styleable.Shapes_display_shape,true);
        shapecolor=array.getColor(R.styleable.Shapes_shape_color,0);
        labelcolor=array.getColor(R.styleable.Shapes_label_color,0);
        array.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(shapecolor);
        paint.setStyle(Paint.Style.FILL);
        Paint labelpaint=new Paint();
        labelpaint.setTextSize(50);
        labelpaint.setColor(labelcolor);
        if(curr[this.getSelectedindex()].equals("Rectangle")) {
            canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
        }
        else if(curr[this.getSelectedindex()].equals("Circle"))
        {
            canvas.drawCircle(this.getWidth()/2,this.getHeight()/2,shapewidth/2,paint);
        }
        else
        {
            Path pth=new Path();
            pth.moveTo(0,shapeheight);
            pth.lineTo(shapewidth,shapeheight);
            pth.lineTo(shapewidth/2,0);
            canvas.drawPath(pth,paint);
        }
        if(this.shape)
        {
            canvas.drawText(curr[this.getSelectedindex()],shapewidth/4,shapeheight/2,labelpaint);
        }

    }

    public boolean isShape() {
        return shape;
    }

    public void setShape(boolean shape) {
        this.shape = shape;
    }

    public int getShapecolor() {
        return shapecolor;
    }

    public void setShapecolor(int shapecolor) {
        this.shapecolor = shapecolor;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int minw=getPaddingLeft()+getPaddingRight()+shapewidth;
        int minh=getPaddingTop()+getPaddingBottom()+shapeheight;
        if(this.shape)
        {
            minw+=30+10;
        }
        int w=resolveSizeAndState(minw,MeasureSpec.getSize(widthMeasureSpec),0);
        int h=resolveSizeAndState(minh,MeasureSpec.getSize(heightMeasureSpec),0);
        setMeasuredDimension(w,h);



    }

    public int getSelectedindex() {
        return selectedindex;
    }
    public String getSelectedShape()
    {
        return curr[selectedindex];
    }

    public void setSelectedindex(int selectedindex) {
        this.selectedindex = selectedindex;
    }
}
