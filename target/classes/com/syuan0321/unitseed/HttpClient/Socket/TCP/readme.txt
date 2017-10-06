/**********************************************************
TCP/IP (Internet protocol)
IP package directly wrap the data, not ensure the arriving sequence and not ensure the successful delivery either.
TCP is used to build the connection channel between devices, and ensure the IP Package order(mark index on IP Packages) in these channels. 
***********************************
IP Package have four components:
1.Source IP 
2.Destination IP 
3.Source Port 
4.Destination Port
***********************************
Socket.class & ServerSocket.class ==> IO streaming transfer data

Create Sender & Receiver ==> TCP Socket ==> Socket.send() & ServerSocket.receive()
==> Socket/ServerSocket.close()





***********************************************************/