//////////////////////////////////
// Final Packing Code
//////////////////////////////////

import java.io.*;

class FilePacker
{
    private static final int HEADER_SIZE = 100;
    private static final int BUFFER_SIZE = 1024;
    private static final int KEY = 4242;
    
    public static boolean pack(String FolderName, String PackFileName) throws Exception
    {
        int iRet = 0;
        int Size = 0;
        int i = 0, j = 0;

        String header = ""; //IMP

        FileOutputStream foobj = null;
        FileInputStream fiobj = null;

        byte Buffer[] = new byte[BUFFER_SIZE];
        byte bHeader[] = null;
        
        File fobjfolder = new File(FolderName);

        if((fobjfolder.exists()) && (fobjfolder.isDirectory()))
        {
            System.out.println("Folder exists");

            File fobjpack = new File(PackFileName);
            fobjpack.createNewFile();   // Pack file gets created

            foobj = new FileOutputStream(fobjpack);

            File fArr[] = fobjfolder.listFiles();
            
            System.out.println("Number of files in folder : "+fArr.length);


            for(i = 0; i < fArr.length; i++)
            {

                if(fArr[i].isFile()) //$
                {
                    String FileName = fArr[i].getName().toLowerCase(); //$

                    if(FileName.endsWith(".txt") ||     //File extension filter
                        FileName.endsWith(".c") ||
                        FileName.endsWith(".cpp") ||
                        FileName.endsWith(".java") 
                        )
                    {
                        fiobj = new FileInputStream(fArr[i]);

                        header = header + fArr[i].getName();
                        header = header + " ";
                        header = header + fArr[i].length();

                        Size = 100 - header.length();

                        for(j = 1; j <= Size; j++)
                        {
                            header = header + " ";
                        }

                        bHeader = header.getBytes();
                                        
                        // Write file name and size 
                        
                        foobj.write(bHeader);

                        // Read, encrypt and write file data        //$
                        while((iRet = fiobj.read(Buffer)) != -1)
                        {
                            for(int k = 0; k < iRet; k++)
                            {
                                Buffer[k] = (byte)(Buffer[k] ^ KEY); //XOR Operation (forward)
                            }

                            foobj.write(Buffer, 0, iRet);
                        }
                        fiobj.close();
                        header = ""; //IMP

                    }
                }
            }

            foobj.close();
            return true;
        }
        else
        {
            return false;
        }
    }
}