package com.ice.packetrouter.router;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.ice.packetrouter.packet.Packet;

public class Router {

    private static final long TIMEOUT = 100;
	private PriorityBlockingQueue<Packet> queue;
    
    public Router(int maxCapacity, Comparator<Packet> comparator) {
    	this.queue = new PriorityBlockingQueue<>(maxCapacity, comparator);
    }
    
    public void addPacket(Packet packet) {
    	packet.setReceivedTime(System.currentTimeMillis());
    	queue.offer(packet);
    }
    
    public Packet removePacket() throws InterruptedException{
    	Packet highestPriorityPacket = queue.peek();
    	if (highestPriorityPacket != null) {
    		highestPriorityPacket = queue.poll();
    	}
    	else {
    		highestPriorityPacket = queue.poll(TIMEOUT, TimeUnit.MILLISECONDS);
    	}
    	return highestPriorityPacket;
    }
}
