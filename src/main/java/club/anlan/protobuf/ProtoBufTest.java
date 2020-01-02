package club.anlan.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().
                setName("faker").setAge(20).setAddress("韩国").build();
        byte[] student2ByteArray = student.toByteArray();
        DataInfo.Student student1 = DataInfo.Student.parseFrom(student2ByteArray);
        System.out.println(student1.toString());
    }
}
