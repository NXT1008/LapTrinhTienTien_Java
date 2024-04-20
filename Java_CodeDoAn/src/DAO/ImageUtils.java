package DAO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageUtils {

    public static byte[] imageToByteArray(ImageIcon icon) throws IOException {
        if (icon == null) {
            // Nếu không có hình ảnh được đặt, trả về mảng byte rỗng
            return new byte[0];
        }

        // Lấy hình ảnh từ ImageIcon
        Image image = icon.getImage();

        // Chuyển đổi hình ảnh thành BufferedImage để có thể sử dụng ImageIO
        BufferedImage bufferedImage = new BufferedImage(
                image.getWidth(null),
                image.getHeight(null),
                BufferedImage.TYPE_INT_RGB
        );
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);

        // Tạo một ByteArrayOutputStream để ghi dữ liệu hình ảnh
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Ghi hình ảnh vào ByteArrayOutputStream dưới dạng PNG
        ImageIO.write(bufferedImage, "png", baos);

        // Trả về mảng byte từ ByteArrayOutputStream
        return baos.toByteArray();
    }
}

