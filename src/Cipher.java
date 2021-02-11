import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cipher {
    int key;
    public Cipher(int key){
        this.key = key;
    }


public void encrypt(InputStream input, OutputStream output) throws IOException {
    boolean done = false;
    while(!done){
        int next = input.read();
        if(next==1){
            done = true;
        }
        else{
            byte b = (byte) next;
            byte c = (byte) (b+key);
            output.write(c);
        }
    }
}
    public String decrypt(InputStream input) throws IOException {
        boolean done = false;
        String result="";
        while(!done){
            int next = input.read();
            if(next==1){
                done = true;
            }
            else{
                byte b = (byte) next;
                byte c = (byte) (b-key);
                result = String.valueOf(c);
                //output.write(c);
            }
        }
        return result;
    }
    public String encrypt(String plainText){
        if(key >26){
            key%=26;
        }
        else if(key<0){
            key = (key%26)+26;
        }
        int length = plainText.length();
        String cipherText="";
        for(int i =0; i<length; i++){
            char c = plainText.charAt(i);
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    char f = (char) ((char)c+key);
                    if(f>'Z'){
                        cipherText+=(c-(26-key));
                    }
                    else{
                        cipherText+=f;
                    }
                }
                else if(Character.isLowerCase(c)){
                    char f = (char) ((char)c+key);
                    if(f>'z'){
                        cipherText+=(c-(26-key));
                    }
                    else{
                        cipherText+=f;
                    }
                }
            }
            else{
                cipherText+=c;
            }
        }
        return cipherText;
    }
    public String decrypt(String plainText){//,InputStream input, OutputStream output
        if(key >26){
            key%=26;
        }
        else if(key<0){
            key = (key%26)+26;
        }
        int length = plainText.length();
        String cipherText="";
        for(int i =0; i<length; i++){
            char c = plainText.charAt(i);
            if(Character.isLetter(c)){
                if(Character.isUpperCase(c)){
                    char f = (char) ((char)c-key);
                    if(f<'A'){
                        cipherText+=(c+(26-key));
                    }
                    else{
                        cipherText+=f;
                    }
                }
                else if(Character.isLowerCase(c)){
                    char f = (char) ((char)c-key);
                    if(f<'a'){
                        cipherText+=(c+(26-key));
                    }
                    else{
                        cipherText+=f;
                    }
                }
            }
            else{
                cipherText+=c;
            }
        }
        return cipherText;
    }
}
