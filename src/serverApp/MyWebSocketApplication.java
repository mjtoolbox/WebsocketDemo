package serverApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import socket.ClientSocket;

import com.sun.grizzly.tcp.Request;
import com.sun.grizzly.websockets.ProtocolHandler;
import com.sun.grizzly.websockets.WebSocket;
import com.sun.grizzly.websockets.WebSocketApplication;
import com.sun.grizzly.websockets.WebSocketListener;

public class MyWebSocketApplication extends WebSocketApplication
{
	// Collection<WebSocket> sockets = new ArrayList<WebSocket>();

	public WebSocket createSocket(ProtocolHandler handler,
			WebSocketListener... listeners)
	{
		return new ClientSocket(handler, listeners);
	}

	@Override
	public boolean isApplicationRequest(Request arg0)
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void onConnect(WebSocket socket)
	{
		super.onConnect(socket);
		System.out.println("On Connect.....");
	}

	@Override
	public void onMessage(WebSocket socket, String data)
	{
		System.out.println("OnMessage() starts");
		for (final WebSocket webSocket : getWebSockets())
		{
			try
			{
				// send data to all connected clients (including caller)
				webSocket.send(data);
				System.out.println("Sent");
			} catch (Exception e)
			{
				e.printStackTrace();
				webSocket.close();
			}
		}

		// System.out.println("is this socket connected? : " +
		// socket.isConnected() );
		//System.out.println("getWebSockets : " + getWebSockets().size());
		//socket.send("WS Server response : " + data);
	}

}
