package com.hnkalhp;

public class Main {

    public static void main(String[] args) {
    	
    	ProtocolType protocol = ProtocolType.TCP;
    	if(args.length > 0) {
    		if(args[0].toLowerCase() == ProtocolType.UDP.toString()) {
    			protocol = ProtocolType.UDP;
    		}
    	}
    	System.out.println("olá");
    	// instanciar server e client
    }
}
