package nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassNameNettyServer
 * @Description
 * @Author fenggaopan
 * @Date2020/7/12 8:09 下午
 * @Version V1.0
 **/
public class NettyServer {

    public static void main(String[] args) throws Exception {
        //1.创建两个线程组 bossGroup和workergroup
        //2.bossgroup只处理连接请求，workergoup真正的与客户端业务处理
        //3.两个都是无限循环
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        //创建服务端启动对象，配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();

        //使用链式变成组进行设置
        bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                 .channel(NioServerSocketChannel.class)
                 .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列连接数
                 .childOption(ChannelOption.SO_KEEPALIVE, true)  //设置活动连接状态
                 .childHandler(new ChannelInitializer<SocketChannel>() {
                     //匿名方式创建一个通道测试对象
                     //向通道关联的pipeline增加一个handler
                     @Override
                     protected void initChannel(SocketChannel socketChannel) throws Exception {
                         socketChannel.pipeline().addLast(new NettyServerHandler());
                     }
                 }); //设置请求处理器

        System.out.println("服务器 is ready .............");

        //绑定端口号,同步处理
        ChannelFuture ch =bootstrap.bind(6688).sync();

        //对关闭通道进行监听
        ch.channel().closeFuture().sync();

        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
