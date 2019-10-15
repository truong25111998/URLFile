
package downloadmanager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;



public class DownloadManager {

    public void downloadManager(String link){
        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            int sizefile = conn.getContentLength();
            String typefile = conn.getContentType();
            FileOutputStream out = new FileOutputStream("test.jpg");
            InputStream in = conn.getInputStream();
            byte[] b = new byte[1024];
            int le = in.read(b);// le la"\ so luong byte doc duoc
            while(le>=0){// neu le = -1 dang doc den cuoi file
                out.write(b,0, le);
                le = in.read(b);
            }
            in.close();
            out.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }      
    }   
}
