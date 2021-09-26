package com.devaccent.pax.printer;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import com.pax.dal.IDAL;
import com.pax.dal.IPrinter;
import com.pax.neptunelite.api.NeptuneLiteUser;

public class ReactNativePaxPrinterModule extends ReactContextBaseJavaModule {
  protected static final String REACT_CLASS = "PaxPrinter";
  private final ReactApplicationContext reactContext;

  private IDAL dal;
  private IPrinter printer;

  public ReactNativePaxPrinterModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;

    try {
      dal = NeptuneLiteUser.getInstance().getDal(reactContext);
      printer = dal.getPrinter();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @ReactMethod
  public void initPrinter(Promise promise) {
    try {
      printer.init();
      promise.resolve(null);
    } catch(Exception e) {
      promise.reject("Error initializing the printer", e);
    }
  }

  @ReactMethod
  public void setGrayLevel(Integer grayLevel, Promise promise) {
    try {
      printer.setGray(grayLevel);
      promise.resolve(null);
    } catch(Exception e) {
      promise.reject("Error setting gray level", e);
    }
  }

  @ReactMethod
  public void addSimpleLine(String text, Promise promise) {
    try {
      printer.printStr(text, null);
      promise.resolve(null);
    } catch(Exception e) {
      promise.reject("Error adding line", e);
    }
  }

  @ReactMethod
  public void printLines(Promise promise){
    try {
      printer.start();
      promise.resolve(null);
    } catch(Exception e) {
      promise.reject("Print error", e);
    }
  }

  @ReactMethod
  public void cutPaper(Double cutMode, Promise promise){
    try {
      promise.resolve(null);
      printer.cutPaper(cutMode.intValue());
    } catch(Exception e) {
      promise.reject("Error cutting the paper", e);
    }
  }

  @ReactMethod
  public void printOneLine(String text, Double cutMode, Promise promise) {
    try {
      printer.init();
      printer.setGray(3);
      printer.printStr(text, null);
      printer.start();
      printer.cutPaper(cutMode.intValue());
      promise.resolve(null);
    } catch(Exception e) {
      promise.reject("Create Event Error", e);
    }
  }
}
