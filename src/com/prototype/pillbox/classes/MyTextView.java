package com.prototype.pillbox.classes;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {

  public MyTextView(Context context, AttributeSet attrs, int defStyle) {
      super(context, attrs, defStyle);
      if(!isInEditMode())
    	  init();
  }

 public MyTextView(Context context, AttributeSet attrs) {
      super(context, attrs);
      if(!isInEditMode())
      init();
  }

 public MyTextView(Context context) {
      super(context);
      if(!isInEditMode())
      init();
 }


public void init() {
    Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/streamline.ttf");
    setTypeface(tf);

}
}