package com.devaccent.pax.printer.receipt;

import android.graphics.Bitmap;
import android.util.Log;

import com.devaccent.pax.printer.receipt.page.ReceiptUnit;
import com.facebook.react.bridge.ReactApplicationContext;

import com.pax.gl.page.IPage;
import com.pax.gl.page.IPage.ILine;
import com.pax.gl.page.PaxGLPage;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class ReceiptBitmapGenerator {
	public static Bitmap generateBitmap(ReactApplicationContext reactContext, String pageOptions, Integer width) {
		PaxGLPage pageBuilder;
		pageBuilder = PaxGLPage.getInstance(reactContext);
		IPage page = pageBuilder.createPage();

		try {
			JSONObject pageObject = new JSONObject(pageOptions);
			JSONArray lines = ReceiptUnserializer.getLines(pageObject);

		    for (int i = 0; i < lines.length(); i++) {
				JSONArray units = ReceiptUnserializer.getUnits(lines.getJSONObject(i));
				ILine pageLine = page.addLine();

				for (int j = 0; j < units.length(); j++) {
					JSONObject unitSettings = units.getJSONObject(j);
					ReceiptUnit unit = ReceiptUnserializer.getUnit(unitSettings);
					pageLine.addUnit(unit.text, unit.fontSize, unit.alignment, unit.textStyle);
		        }
			}
	    } catch (JSONException e) {
            Log.d("", e.toString());
	    }

	    return pageBuilder.pageToBitmap(page, width);
    }

	private void getImage(){
// 		Options options = new Options();
// 		options.inScaled = false;
// 		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rect,options);
	}
}
