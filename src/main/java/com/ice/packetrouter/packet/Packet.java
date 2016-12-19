package com.ice.packetrouter.packet;

public class Packet{

	private final SourceType sourceType;
	private final boolean isLarge;
	private long receivedTime;
	
	public Packet(SourceType sourceType, boolean isLarge) {
		this.sourceType = sourceType;
		this.isLarge = isLarge;
	}

	public SourceType getSourceType() {
		return sourceType;
	}

	public boolean isLarge() {
		return isLarge;
	}
	
	public long getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(long receivedTime) {
		this.receivedTime = receivedTime;
	}
}
