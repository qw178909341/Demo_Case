package com.fishs.chat13_network.caseTCP;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/1 15:33
 */
public class DemoClient {
    public static void main(String[] args) throws IOException {
        while (true) {
            try (Socket sock = new Socket("127.0.0.1", 6666)) {
                System.out.println("connected.");
                handle(sock.getInputStream(), sock.getOutputStream());
                System.out.println("server closed connection, retrying...");
            } catch (IOException e) {
                System.out.println("connect failed: " + e.getMessage());
            }

            try {
                Thread.sleep(2000); // 重连间隔
            } catch (InterruptedException ignored) {}
        }
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[server] " + reader.readLine());
        for (;;) {
            System.out.print(">>> "); // 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            if (resp == null) {
                System.out.println("server disconnected.");
                break; // 退出 handle → 回到外层自动重连
            }
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
        }
    }
}
