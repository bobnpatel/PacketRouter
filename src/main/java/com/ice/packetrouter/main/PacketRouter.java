package com.ice.packetrouter.main;

import java.util.Arrays;

import com.ice.packetrouter.packet.Packet;
import com.ice.packetrouter.packet.PacketComparator;
import com.ice.packetrouter.packet.SourceType;
import com.ice.packetrouter.router.Router;

public class PacketRouter {

	public static void main(String[] args) {
		
		Packet[] packets = new Packet[5];
		packets[0] = new Packet(SourceType.MANAGEMENT, false);
		packets[1] = new Packet(SourceType.USER, false);
		packets[2] = new Packet(SourceType.MANAGEMENT, true);
		packets[3] = new Packet(SourceType.USER, true);
		packets[4] = new Packet(SourceType.MANAGEMENT, true);
		
		Router router = new Router(5, new PacketComparator().reversed());
		
		Arrays.stream(packets).forEach(e -> router.addPacket(e));

		try {
	        for (int i = 0; i < 5; i++) {
	            Packet p = router.removePacket();
	            StringBuilder builder = new StringBuilder();
	            builder.append("Packet ").append(i).append(" ").append(p.getSourceType()).append(" ").append("isLarge ").append(p.isLarge()).append(" ReceivedTime ").append(p.getReceivedTime());
	            
	            System.out.println(builder.toString());
	        }
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
