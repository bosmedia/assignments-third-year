/*****
 * CT326 - Assignment 12 - c.loughnane1@nuigalway.ie - 09101916
 */
package pkg12;

import java.io.Serializable;

public class Message implements Serializable {

    private int segmentID;
    private byte[] packet;

    public Message(){} //empty constructor required for UDPFileReceiver. This is more tidy.
    
    public Message(int segmentID, byte[] packet) {
        this.segmentID = segmentID;
        this.packet = packet;
    }

    public int getSegmentID() {
        return segmentID;
    }

    public byte[] getPacket() {
        return packet;
    }
}
