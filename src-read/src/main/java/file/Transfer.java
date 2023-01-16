package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;

/**
 * @author Fchen
 * @date 2022/4/15 5:25 下午
 * @desc nio 提供的 TransferTo 与 TransferFrom
 */
public class Transfer {

    public static void copyFileByChannel(File source, File dest) throws IOException {
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
             FileChannel targetChannel = new FileOutputStream(dest).getChannel();) {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;

//                sourceChannel.transferFrom()
            }
        }
    }



    public static Path copy(Path source, Path target, CopyOption... options)
            throws IOException
    {
        FileSystemProvider provider = provider(source);
        if (provider(target) == provider) {
            // same provider
            provider.copy(source, target, options);//这是本文分析的路径
        } else {
            // different providers
//            CopyMoveHelper.copyToForeignTarget(source, target, options);
        }
        return target;
    }

    private static FileSystemProvider provider(Path source) {
        return null;
    }


    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
