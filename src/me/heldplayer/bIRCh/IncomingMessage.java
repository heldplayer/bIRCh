
package me.heldplayer.bIRCh;

public class IncomingMessage {
    private String source = "";
    private String type = "";
    private String[] args = null;
    private String argString = "";

    protected IncomingMessage(String base) {
        String editable = base.trim();

        if (editable.startsWith(":")) {
            if (editable.indexOf(" ") < 0) {
                return;
            }

            source = editable.substring(1, editable.indexOf(" "));

            editable = editable.substring(source.length() + 1).trim();
        }

        String[] split = editable.split(" ");

        if (split.length <= 0) {
            return;
        }

        type = split[0];

        editable = editable.substring(type.length()).trim();

        argString = editable;
        args = argString.split(" ");
    }

    public boolean parse(bIRCh plugin) {
        if (type.equalsIgnoreCase("PING")) {
            plugin.addToIrcList(new OutgoingMessage("PONG " + argString));
            ;
            return true;
        }
        return false;
    }
}
