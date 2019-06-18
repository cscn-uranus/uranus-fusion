package com.uranus.toolkit.udp;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author tellxp@github.com
 * @date 2019/5/30 12:03
 */
@Slf4j
public class MulticastEchoServer  extends Thread {
  protected MulticastSocket socket = null;
  protected byte[] buf = new byte[8192];
  protected InetAddress group = null;

  public MulticastEchoServer() throws IOException {
    log.info("Starting on address {} and port {}", "50000", "225.25.25.25");
    socket = new MulticastSocket(50000);
    socket.setReuseAddress(true);
    group = InetAddress.getByName("225.25.25.25");
    socket.joinGroup(group);
  }

  @Override
  public void run() {
    try {
      while (true) {
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        packet = new DatagramPacket(buf, buf.length, address, port);
        String received = new String(packet.getData(), 0, packet.getLength());

        log.info("Server - Received package from {}:{}", packet.getAddress(), packet.getPort());

        if (received.startsWith("end")) {
          break;
        }

//        socket.send(packet);
      }
      socket.leaveGroup(group);
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
