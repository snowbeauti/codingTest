package codingTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

public class MessengerA {

	protected JTextField textField;
	protected JTextArea textArea;
	DatagramSocket socket;
	DatagramPacket packet;
	InetAddress address = null;
	
	final int myport = 5000; //수신용 포트
	final int otherPort = 6000; //송신용 포트

	public MessengerA() throws IOException{
		MyFrame f = new MyFrame();
		address = InetAddress.getByName("127.0.0.1");
		socket = new DatagramSocket(myport);
	}
	
	public void process() {
		while(true) {
			try {
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet); //패킷을 받는다.
				//받은 패킷을 텍스트 영역에 표시한다.
				textArea.append("받은 메세지: " + new String(buf) + "\n");
			}
			catch (IOException iOException) {
				iOException.printStackTrace();
			}
		}
	}
	
	//내부 클래스 정의
	class MyFrame extends JFrame implements ActionListener{
		public MyFrame() {
			super("MessengerA");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			textField = new JTextField(30);
			textField.addActionListener(this);
			
			textArea = new JTextArea(10,30);
			textArea.setEditable(false);
			
			add(textField, BorderLayout.PAGE_END);
			add(textArea, BorderLayout.CENTER);
			pack();
			setVisible(true);
		}
		public void actionPerformed(ActionEvent evt) {
			String s = textField.getText();
			byte[] buffer = s.getBytes();
			DatagramPacket packet;
			
			//패킷을 생성한다.
			packet = new DatagramPacket(buffer, buffer.length, address, otherPort);
			try {
				socket.send(packet); //패킷을 보낸다.
			} catch (IOException e) {
				e.printStackTrace();
			}
			textArea.append("보낸 메세지: " + s + "\n");
			textField.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}
	public static void main(String[] args) throws IOException{
		MessengerA m = new MessengerA();
		m.process();
	}
}
