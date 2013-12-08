
package painter;

import java.io.*;
public class OpenFile {

    OpenFile()
    {
        try
        {
            File file = new File("client.exe");
            boolean success = file.createNewFile();
        }
        catch(IOException e){}
    }
}
