package at.yeoman.mutabor.companion.hugeBitmap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

public class HugeBitmap {
    public static void main(String[] args) throws IOException {
        new HugeBitmap().run();
    }

    private void run() throws IOException {
        BufferedImage buffer = new BufferedImage(10_000, 10_000, BufferedImage.TYPE_INT_RGB);
        new HugeImagePainter(buffer).run();
        ImageIO.write(buffer, "JPG", new FileOutputStream("huge_bitmap.jpg"));
    }
}
