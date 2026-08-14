//////////////////////////////////
// Final UnPacking Code
//////////////////////////////////

import java.io.*;

class FileUnpacker
{
    private static final int HEADER_SIZE = 100;
    private static final int KEY = 4242;

    public static boolean unpack(String PackFileName) throws Exception
    {
        File fpackobj = null;
        FileInputStream fiobj = null;
        FileOutputStream foobj = null;
        byte Header[] = new byte[HEADER_SIZE];
        String strHeader = null;
        File NewFile = null;
        byte Buffer[] = null;
        int iRet = 0;

        fpackobj = new File(PackFileName);

        if(fpackobj.exists())
        {
            fiobj = new FileInputStream(fpackobj);

            // Read header
            while((iRet = fiobj.read(Header, 0, HEADER_SIZE)) != -1)
            {
                strHeader = new String(Header);

                strHeader = strHeader.trim();

                int iPos = strHeader.lastIndexOf(' '); //$ handles whitespaces inside  filenames

                String FileName = strHeader.substring(0, iPos); //$
                String FileSize = strHeader.substring(iPos + 1); //$

                System.out.println("File name : " + FileName);
                System.out.println("File size : " + FileSize);

                NewFile = new File(FileName);
                NewFile.createNewFile();

                foobj = new FileOutputStream(NewFile);

                int FileSizeInt = Integer.parseInt(FileSize);

                Buffer = new byte[FileSizeInt]; //$

                // read  encrypt data
                fiobj.read(Buffer, 0, FileSizeInt);

                //Decrypt Data
                for(int k = 0; k < FileSizeInt; k++)         //$
                {
                    Buffer[k] = (byte)(Buffer[k] ^ KEY);     //XOR operation
                }

                // Write decrypted  data
                foobj.write(Buffer, 0, FileSizeInt);

                foobj.close();

            }// End of while
            
            fiobj.close();
            return true;
        }
        else
        {
            return false;
        }
    }
}