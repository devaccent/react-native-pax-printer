package com.devaccent.pax.printer.receipt;

import android.net.Uri;
import android.os.Environment;
import android.media.MediaScannerConnection;
import android.util.Log;
import android.graphics.Bitmap;

import com.facebook.react.bridge.ReactApplicationContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Random;

public class ReceiptStorage {
  public static boolean store(ReactApplicationContext context, String storageFolder, Bitmap imageData, String fileName) {
      String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
      File saveDirectory = new File(root + "/" + storageFolder);

      if (!saveDirectory.exists()) {
        saveDirectory.mkdirs();
      }

      String realFileName = fileName + "-" + getRandomNumber() + ".png";

      try {
        File file = new File (saveDirectory, realFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);

        imageData.compress(Bitmap.CompressFormat.PNG, 100, bos);

        bos.flush();
        bos.close();

				reScanMedia(context, file);
      } catch (FileNotFoundException e) {
        Log.w("Storage", "Error saving image file: " + e.getMessage());
        return false;
      } catch (IOException e) {
        Log.w("Storage", "Error saving image file: " + e.getMessage());
        return false;
      }

      return true;
    }

		private static Integer getRandomNumber() {
      Random generator = new Random();
      int n = 10000;
      n = generator.nextInt(n);

      return n;
		}

    private static void reScanMedia(ReactApplicationContext context, File file) {
      MediaScannerConnection.scanFile(context, new String[] { file.toString() }, null,
        new MediaScannerConnection.OnScanCompletedListener() {
          public void onScanCompleted(String path, Uri uri) {}
        }
      );
    }
}
