package com.quizeduca.app;

import android.graphics.Bitmap;
import android.graphics.Color;

public final class BitmapUtils {
    private BitmapUtils() {}
    public static Bitmap trimTransparentBorders(Bitmap src) {
        if (src == null || src.isRecycled()) return src;
        final int width = src.getWidth();
        final int height = src.getHeight();
        if (width == 0 || height == 0) return src;

        int[] pixels = new int[width * height];
        src.getPixels(pixels, 0, width, 0, 0, width, height);

        int top = 0;
        int left = 0;
        int right = width - 1;
        int bottom = height - 1;
        boolean found;

        // Top
        found = false;
        for (int y = 0; y < height; y++) {
            int rowIndex = y * width;
            for (int x = 0; x < width; x++) {
                if (Color.alpha(pixels[rowIndex + x]) != 0) {
                    top = y;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        // Bottom
        found = false;
        for (int y = height - 1; y >= top; y--) {
            int rowIndex = y * width;
            for (int x = 0; x < width; x++) {
                if (Color.alpha(pixels[rowIndex + x]) != 0) {
                    bottom = y;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        // Left
        found = false;
        for (int x = 0; x < width; x++) {
            for (int y = top; y <= bottom; y++) {
                if (Color.alpha(pixels[y * width + x]) != 0) {
                    left = x;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        // Right
        found = false;
        for (int x = width - 1; x >= left; x--) {
            for (int y = top; y <= bottom; y++) {
                if (Color.alpha(pixels[y * width + x]) != 0) {
                    right = x;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        int newWidth = right - left + 1;
        int newHeight = bottom - top + 1;
        if (newWidth <= 0 || newHeight <= 0) return src;
        if (newWidth == width && newHeight == height) return src;

        try {
            return Bitmap.createBitmap(src, left, top, newWidth, newHeight);
        } catch (Throwable t) {
            return src;
        }
    }
}

