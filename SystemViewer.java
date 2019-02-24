import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import com.fazecast.jSerialComm.SerialPort;

public class SystemViewer
{
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 800;

    public static void main(String[] args) throws InterruptedException
    {
        SerialPort serialPort = SerialPort.getCommPorts()[0];
        serialPort.openPort();
        serialPort.setComPortParameters(9600, 8, 1, 0);
        boolean broken = false;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Huskie Track");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        SystemComponent component = new SystemComponent();
        frame.add(component);

        frame.setVisible(true);

        //sensor stuff
        while (true)
        {
            while(serialPort.bytesAvailable() == 0){
                Thread.sleep(20);
            }

            byte[] readBuffer = new byte[1];
            serialPort.readBytes(readBuffer, 1);
            if((int)readBuffer[0] == 1)
                broken = false;
            if((int)readBuffer[0] == 0)
            {
                broken = true;
                break;
            }
        }

        if (broken == true)
        {
            String timestamp = component.doorBreak();
            component.repaint();
            JOptionPane.showMessageDialog(frame,
                "Sensor #1 has been broken. \nFloor: 1 | Room: 1 \nTime: " + timestamp,
                "ALERT",
                JOptionPane.WARNING_MESSAGE);
            System.out.println("Sensor #1 was broken at " + timestamp);
        }

    }
}