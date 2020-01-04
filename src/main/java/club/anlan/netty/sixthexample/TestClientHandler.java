package club.anlan.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("faker").setAge(20).setAddress("首尔").build();
        MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder().setName("小黑").setAge(2).build();
        MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder().setName("小花").setCity("成都").build();
        int randomInt = new Random().nextInt(3);
        MyDataInfo.MyMessage message = null;
        if (randomInt == 0) {
            message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).
                    setPerson(person).build();
        } else if (randomInt == 1) {
            message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).
                    setDog(dog).build();
        } else {
            message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).
                    setCat(cat).build();
        }
        ctx.writeAndFlush(message);
    }
}
