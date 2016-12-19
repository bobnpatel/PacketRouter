package com.ice.packetrouter.packet;

import java.util.Comparator;

public class PacketComparator implements Comparator<Packet>{

	@Override
	public int compare(Packet o1, Packet o2) {
		
		// Management Packet  has higher priority than User
		if(o1.getSourceType() == SourceType.MANAGEMENT && o2.getSourceType() == SourceType.USER) {
			return 1;
		}
		else if(o1.getSourceType() == SourceType.USER && o2.getSourceType() == SourceType.MANAGEMENT) {
			return -1;
		} 
		
		// If Source Type is same then the larger packet has higher priority
		if (o1.isLarge() && !o2.isLarge()) {
            return 1;
        } else if (!o1.isLarge() && o2.isLarge()) {
            return -1;
        }

        // All else being equal, packets that have been received earlier should be removed before the most recently received packets.
        if (o1.getReceivedTime() < o2.getReceivedTime()) {
            return 1;
        } else {
            return -1;
        }
	}

}
