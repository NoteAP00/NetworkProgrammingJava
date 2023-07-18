import java.io.*;
public class JavaList{
    public static void main(String[] args) {
        try {
            String dir = args[0];
            File file = new File(dir);
            File list[] = file.listFiles();
            if (args.length != 1){
                System.out.println("Usage : JavaList  <File/Directory Name>");
                System.exit(1);
            }
            else if (!file.exists()){
                System.out.println("File not found");
                System.exit(1);
            }
            else if (file.isFile()){
                System.out.println(file.getName()+ " " + file.length() + " Bytes");
            }
            else if (file.isDirectory()){
                for(int i = 0; i < list.length; i++){
                    if(list[i].isDirectory()){
                        System.out.println(list[i].getName());
                    }
                    else if(list[i].isFile()){
                        System.out.println(list[i].getName()+ " " + list[i].length() + " Bytes");
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                    
                }
            }
        
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Usage : JavaList  <File/Directory Name>");
        }
        catch(IllegalArgumentException e){
			System.out.println("Error");
		}
    }
}   
