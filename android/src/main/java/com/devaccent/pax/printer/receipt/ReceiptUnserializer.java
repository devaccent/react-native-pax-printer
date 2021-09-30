package com.devaccent.pax.printer.receipt;

import com.devaccent.pax.printer.receipt.page.ReceiptUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class ReceiptUnserializer {
  public static JSONArray getLines(JSONObject pageObject) throws JSONException {
     JSONArray lines = pageObject.getJSONArray("lines");
     return lines;
  }

  public static JSONArray getUnits(JSONObject pageLine) throws JSONException {
     JSONArray units = pageLine.getJSONArray("units");
     return units;
  }

  public static ReceiptUnit getUnit(JSONObject unitSettings){
    return new ReceiptUnit(unitSettings);
  }
}
