import estate.common.util.LogUtil;
import estate.entity.database.ParkingLotEntity;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketTest {
    private String ip="192.168.1.8";
    private Integer port=4800;

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }
    private static int toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    @Test
    public void test() throws IOException
    {
        Socket socket;
        DataOutputStream dos ;
        DataInputStream dis;
        socket=new Socket(ip,port);
        dos = new DataOutputStream(socket.getOutputStream());
        dis=new DataInputStream(socket.getInputStream());
        byte[] b;
        b=hexStringToByte("00000000");
//        b= new byte[]{0x00, 0x0B, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
        dos.write(b);

        b=hexStringToByte("010B818283848586878880222222220405060708");
        dos.write(b);
//        b=new byte[]{0x01,0x0B, (byte) 0x81, (byte) 0x82, (byte) 0x83, (byte) 0x84, (byte) 0x85, (byte) 0x86, (byte) 0x87, (byte) 0x88, (byte) 0x80,0x22,0x2,0x22,0x22,0x04,0x05,0x06,0x07,0x08};

        b=hexStringToByte("0218000000000000000189000102030405060708");
        dos.write(b);

//        b=new byte[]{0x02,0x18,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x01, (byte) 0x89,0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08};

        dos.flush();

    }


    @Test
    public void test2()
    {
        LogUtil.E(ParkingLotEntity.class.getSimpleName());
    }
}