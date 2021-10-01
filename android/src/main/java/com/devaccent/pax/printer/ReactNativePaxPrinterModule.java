package com.devaccent.pax.printer;

import android.util.Log;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

import com.devaccent.pax.printer.receipt.ReceiptBitmapGenerator;
import com.devaccent.pax.printer.receipt.ReceiptStorage;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import com.pax.dal.IDAL;
import com.pax.dal.IPrinter;
import com.pax.neptunelite.api.NeptuneLiteUser;

@ReactModule(name = ReactNativePaxPrinterModule.REACT_CLASS)
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
		} catch (Exception e) {}
	}

	@Override
	public String getName() {
		return REACT_CLASS;
	}

	@ReactMethod
	public void initPrinter() {
	    try {
	      printer.init();
	    } catch(Exception e) {}
	}

	@ReactMethod
	public void setGrayLevel(Integer grayLevel) {
	    try {
	      printer.setGray(grayLevel);
	    } catch(Exception e) {}
	}

	@ReactMethod
	public void addTextLine(String text) {
	    try {
	      printer.printStr(text, null);
	    } catch(Exception e) {}
	}

	@ReactMethod
	public void start(){
	    try {
	      printer.start();
	    } catch(Exception e) {}
	}

	@ReactMethod
	public void cutPaper(Double cutMode){
	    try {
	      printer.cutPaper(cutMode.intValue());
	    } catch(Exception e) {}
	}

	@ReactMethod
	public void addPage(String pageOptions, Boolean saveAsImage){
		Bitmap bitmap = ReceiptBitmapGenerator.generateBitmap(this.reactContext, pageOptions, 384);

		if(saveAsImage == true) {
			ReceiptStorage.store(this.reactContext, "pos-receipts", bitmap, "test-receipt");
		}

		try {
			printer.printBitmap(bitmap);
		} catch (Exception e) {}
	}
}
