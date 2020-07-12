package nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassNameNettyServerHandler
 * @Description  :
 *  自定义一个handler继承netty某个适配器
 * @Author fenggaopan
 * @Date2020/7/12 9:28 下午
 * @Version V1.0
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *
     * @param ctx 上下文对象 ，含有管道pipeline,通道channel
     *            服务地址
     * @param msg 发来的消息
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx=" + ctx);
        //将msg转成bytebuffer
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送的消息" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址为:" + ctx.channel().remoteAddress());
    }

    /**
     * 数据读取完毕
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写入到缓冲，并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello 客户端", CharsetUtil.UTF_8));

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //异常处理，关闭通道

    }
}
