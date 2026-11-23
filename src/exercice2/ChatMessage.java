package exercice2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.Instant;

public class ChatMessage implements Externalizable {
    private static final long serialVersionUID = 5L;
    private static final int SCHEMA_VERSION = 1;

    private String sender;      
    private String content;     
    private Instant sentAt;     
    private transient int charCount; 
    public ChatMessage() {
    }

    public ChatMessage(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.sentAt = Instant.now();
        this.charCount = content.length();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(SCHEMA_VERSION);
        out.writeUTF(sender);
        out.writeUTF(content);
        out.writeLong(sentAt.toEpochMilli());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version != SCHEMA_VERSION) {
            throw new IOException("La version de schéma non prise en charge : " + version);
        }

        sender = in.readUTF();
        content = in.readUTF();
        sentAt = Instant.ofEpochMilli(in.readLong());
        charCount = content.length();
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public Instant getSentAt() {
        return sentAt;
    }

    public int getCharCount() {
        return charCount;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) : %s", sentAt, sender, content);
    }
}
