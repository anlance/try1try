package club.anlan.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest9 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("input.txt","rw");
        FileChannel channel = file.getChannel();

        MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_WRITE,0,5);
        byteBuffer.put(0,(byte)'a');
        byteBuffer.put(1,(byte)'f');
        file.close();
    }
}
