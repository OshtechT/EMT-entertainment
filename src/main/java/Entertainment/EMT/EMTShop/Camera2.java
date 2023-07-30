package Entertainment.EMT.EMTShop;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Camera2 {

    public static void main (final String args[]) {
        // Load OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Create panels
        final JPanel cameraFeed = new JPanel();
        final JPanel processedFeed = new JPanel();
        ShapeDetectionUtil.createJFrame(cameraFeed, processedFeed);

        // Create video capture object (index 0 is default camera)
        final VideoCapture camera = new VideoCapture(0);

        // Start shape detection
        Camera2.startShapeDetection(cameraFeed, processedFeed, camera).run();
    }
    public static String readQR(Mat data)throws FileNotFoundException, IOException, NotFoundException {
        BufferedImage path = ShapeDetectionUtil.convertMatToBufferedImage(data);
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType,ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(path)));
        Result result= new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }

    private static Runnable startShapeDetection(final JPanel cameraFeed,
                                                final JPanel processedFeed,
                                                final VideoCapture camera) {
        return () -> {
            final Mat frame = new Mat();

            while (true) {
                // Read frame from camera
                camera.read(frame);

                // Process frame
                final Mat processed = ShapeDetectionUtil.processImage(frame);

                try {
                    JOptionPane.showMessageDialog(cameraFeed, "QRCode output: "+ readQR(frame));
                } catch (Exception e) {
                    System.out.println("");
                }


                // Mark outer contour
                ShapeDetectionUtil.markOuterContour(processed, frame);

                // Draw current frame
                ShapeDetectionUtil.drawImage(frame, cameraFeed);

                // Draw current processed image (for debugging)
                ShapeDetectionUtil.drawImage(processed, processedFeed);
            }
        };
    }
}