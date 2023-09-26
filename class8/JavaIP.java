import java.net.*;
class JavaIP {
    public static void main(String[] args) {
        
            try {
                if(args.length != 1){
                    System.out.println("Usage : java JavaIP <hostname/IP>");
                    System.exit(1);
                }
                InetAddress ad = InetAddress.getByName(args[0]);
                System.out.println("HostName : " + ad.getHostName());
                System.out.println("IP :" + ad.getHostAddress());
    
            } catch(UnknownHostException e){
                System.out.println("Error: unknownhost or IP address");
            } catch (Exception e) {
                System.out.println("Usage : java JavaIP <hostname/IP>");
            }
        
    }
}