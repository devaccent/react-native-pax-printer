package com.devaccent.pax.printer.receipt.page;

import com.devaccent.pax.printer.receipt.ReceiptPageConstants;
import com.pax.gl.page.IPage.EAlign;

import org.json.JSONObject;
import org.json.JSONException;

public class ReceiptUnit {
	public String text = "";
	public EAlign alignment = ReceiptPageConstants.LEFT_ALIGNMENT;
	public Integer fontSize = ReceiptPageConstants.FONT_SIZE_SM;
	public Integer textStyle = ReceiptPageConstants.TEXT_STYLE_NORMAL;

	//TODO: Not working at the moment
	public Integer scaleWidth = 1;
	public Integer scaleHeight = 1;
	public Integer weight = 1;

	public ReceiptUnit(JSONObject unitSettings) {
		try {
			text = unitSettings.getString("text");
	    } catch (JSONException e) {}

	    try {
            String fontSizeKey = unitSettings.getString("fontSize");
            if(ReceiptPageConstants.FONT_SIZES.containsKey(fontSizeKey)){
                fontSize = (Integer) ReceiptPageConstants.FONT_SIZES.get(fontSizeKey);
            }
        } catch (JSONException e) {}

	    try {
			String alignmentKey = unitSettings.getString("align");
			if(ReceiptPageConstants.ALIGNMENTS.containsKey(alignmentKey)){
				alignment = (EAlign) ReceiptPageConstants.ALIGNMENTS.get(alignmentKey);
			}
		} catch (JSONException e) {}

	    try {
            String textStyleKey = unitSettings.getString("textStyle");
            if(ReceiptPageConstants.TEXT_STYLES.containsKey(textStyleKey)){
                textStyle = (Integer) ReceiptPageConstants.TEXT_STYLES.get(textStyleKey);
            }
        } catch (JSONException e) {}

        try {
            Integer scaleHeightFactor = unitSettings.getInt("scaleHeight");
            if(scaleHeightFactor >= 1 && scaleHeightFactor <= 5){
                scaleHeight = scaleHeightFactor;
            }
        } catch (JSONException e) {}

        try {
            Integer scaleWidthFactor = unitSettings.getInt("scaleWidth");
            if(scaleWidthFactor >= 1 && scaleWidthFactor <= 5){
                scaleWidth = scaleWidthFactor;
            }
        } catch (JSONException e) {}

	    try {
            fontSize = unitSettings.getInt("fontSize");
	    } catch (JSONException e) {}
    }
}
