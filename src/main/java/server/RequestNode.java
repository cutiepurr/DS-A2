package server;


import rest.Request;

import java.net.Socket;
import java.util.Comparator;

public class RequestNode {
    private static int priority = 0;
    public Socket socket;
    public Request request;
    public RequestNode(Socket socket, Request req) {
        priority++;
        this.socket = socket;
        this.request = req;
    }
    public int getPriority() { return priority; }
}

class RequestComparator implements Comparator<RequestNode> {
    public int compare(RequestNode n1, RequestNode n2) {
        int p1 = n1.getPriority();
        int p2 = n2.getPriority();
        return Integer.compare(p2, p1);
    }
}