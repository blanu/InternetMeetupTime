package org.itm;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Locale;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class HelloWidget extends AppWidgetProvider
{
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
	{
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 1, 1000);
	}
	
	private class MyTime extends TimerTask
	{
		RemoteViews remoteViews;
		AppWidgetManager appWidgetManager;
		ComponentName thisWidget;
//		DateFormat format = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
		
		public MyTime(Context context, AppWidgetManager appWidgetManager)
		{
			this.appWidgetManager = appWidgetManager;
			remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
			thisWidget = new ComponentName(context, HelloWidget.class);
		}
	
		@Override
		public void run()
		{
//			remoteViews.setTextViewText(R.id.widget_textview, format.format(new Date()));
			long now=new Date().getTime();
			double itm=(Math.floor(now/1000)%86400)/100;
			String nows="~"+new Double(itm).toString();
			remoteViews.setTextViewText(R.id.widget_textview, nows);
			appWidgetManager.updateAppWidget(thisWidget, remoteViews);
		}
	}
}
