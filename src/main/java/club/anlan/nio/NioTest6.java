package club.anlan.nio;

import java.nio.ByteBuffer;

public class NioTest6 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        for(int i=0;i<10;++i){
            byteBuffer.put((byte)i);
        }

        byteBuffer.position(2);
        byteBuffer.limit(5);

        ByteBuffer sliceBuffer = byteBuffer.slice();
        for(int i=0;i<sliceBuffer.capacity();++i){
            byte b = sliceBuffer.get();
            sliceBuffer.put(i,b*=2);
        }

        byteBuffer.clear();
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
    }
}
